package com.jctp.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

@Service
public class TextCosine {
    private Map<String, String> map= null; 
    private double expectSocre =0.5;
    
    
    public TextCosine() {
        map = new HashMap<String, String>();
        try {
        	//读取近义词表
            InputStreamReader isReader = new InputStreamReader(new FileInputStream(TextCosine.class.getResource("synonyms.dict").getPath()), "UTF-8");
            BufferedReader br = new BufferedReader(isReader);
            String s = null;
            while ((s = br.readLine()) !=null) {
                String []synonymsEnum = s.split("→");
                map.put(synonymsEnum[0], synonymsEnum[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean isRight(String str1,String str2,double expectSocre) {
    	List<ElementDict> list1=tokenizer(str1);

    	List<ElementDict> list2=tokenizer(str2);
    	double result=analysis(list1, list2);
    	if(result>=expectSocre)
    		return true;
    	return false;
    }
    
    public double getScore(String str1,String str2) {
    	List<ElementDict> list1=tokenizer(str1);
    	List<ElementDict> list2=tokenizer(str2);
    	return analysis(list1, list2);
    }
    
    //对文本进行分词
    public List<ElementDict> tokenizer(String str) {
        List<ElementDict> list = new ArrayList<ElementDict>();
        IKAnalyzer analyzer = new IKAnalyzer(true);
        try {
            TokenStream stream = analyzer.tokenStream("", str);
            CharTermAttribute cta = stream.addAttribute(CharTermAttribute.class);
            stream.reset();
            int index = -1;
            while (stream.incrementToken()) {
                if ((index = isContain(cta.toString(), list)) >= 0) {
                    list.get(index).setFreq(list.get(index).getFreq() + 1);
                }
                else {
                    list.add(new ElementDict(cta.toString(), 1));
                }
            }
            analyzer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return list;
    }
    
    //判断近义词表里面是否有该word
    public int isContain(String str, List<ElementDict> list) {
        for (ElementDict ed : list) {
            if (ed.getTerm().equals(str)) {
                return list.indexOf(ed);
            } else if (map.get(ed.getTerm())!= null && map.get(ed.getTerm()).equals(str)) {
                return list.indexOf(ed);
            }
        }
        return -1;
    }
    
    //合并两个分词结果
    public List<String> mergeTerms(List<ElementDict> list1, List<ElementDict> list2) {
        List<String> list = new ArrayList<String>();
        for (ElementDict ed : list1) {
            if (!list.contains(ed.getTerm())) {
                list.add(ed.getTerm());
            } else if (!list.contains(map.get(ed.getTerm()))) {
                list.add(ed.getTerm());
            }
        }
        
        for (ElementDict ed : list2) {
            if (!list.contains(ed.getTerm())) {
                list.add(ed.getTerm());
            } else if (!list.contains(map.get(ed.getTerm()))) {
                list.add(ed.getTerm());
            }
        }
        return list;
    }
    
    //分析
    public int anslysisTerms(List<ElementDict> list1, List<ElementDict> list2) {
        int len1 = list1.size();
        int len2 = list2.size();
        if (len2 >= len1 * 1.5) {
            List<ElementDict> newList = new ArrayList<ElementDict>();
            for (int i = 0; i + len1 <= len2; i++) {
                for (int j = 0; j < len1; j++) 
                    newList.add(list2.get(i+j));
                
                newList = adjustList(newList, list2, len2, len1, i);
                if (getResult(analysis(list1, newList))) 
                    return 1;
                else 
                    newList.clear();
            }
        } else if (len1 >= len2 * 1.5) {
            List<ElementDict> newList = new ArrayList<ElementDict>();
            for (int i = 0; i + len2 <= len1; i++) {
                for (int j = 0; j < len2; j++)
                    newList.add(list1.get(i+j));
                
                newList = adjustList(newList, list1, len1, len2, i);
                if (getResult(analysis(newList, list2))) 
                    return 1;
                else 
                    newList.clear();
            }
        } else {
            if (getEasyResult(analysis(list1, list2))) 
                return 1;
        }
        return 0;
    }
    
    
    public List<ElementDict> adjustList(List<ElementDict> newList, List<ElementDict> list, int lenBig, int lenSmall, int index) {
        int gap = lenBig -lenSmall;
        int size = (gap/2 > 2) ? 2: gap/2;
        if (index < gap/2) {
            for (int i = 0; i < size; i++) {
                newList.add(list.get(lenSmall+index+i));
            }
        } else {
            for (int i = 0; i > size; i++) {
                newList.add(list.get(lenBig-index-i));
            }
        }
        return newList;
    }
    
    
    public double analysis(List<ElementDict> list1, List<ElementDict> list2) {
        List<String> list = mergeTerms(list1, list2);
        List<Integer> weightList1 = assignWeight(list, list1);
        List<Integer> weightList2 = assignWeight(list, list2);
        return countCosSimilariry(weightList1, weightList2);
    }
    
    
    public List<Integer> assignWeight(List<String> list, List<ElementDict> list1) {
        List<Integer> vecList = new ArrayList<Integer>(list.size());
        boolean isEqual = false;
        for (String str : list) {
            for (ElementDict ed : list1) {
                if (ed.getTerm().equals(str)) {
                    isEqual = true;
                    vecList.add(new Integer(ed.getFreq()));
                } else if (map.get(ed.getTerm())!= null && map.get(ed.getTerm()).equals(str)) {
                    isEqual = true;
                    vecList.add(new Integer(ed.getFreq()));
                }
            }
            
            if (!isEqual) {
                vecList.add(new Integer(0));
            }
            isEqual = false;
        }
        return vecList;
    }
    
    //计算余弦相似度
    public double countCosSimilariry(List<Integer> list1, List<Integer> list2) {
        double countScores = 0;
        int element = 0;
        int denominator1 = 0;
        int denominator2 = 0;
        int index = -1;
        for (Integer it : list1) {
            index ++;
            int left = it.intValue();
            int right = list2.get(index).intValue();
            element += left * right;
            denominator1 += left * left;
            denominator2 += right * right;
        }
        try {
            countScores = (double)element / Math.sqrt(denominator1 * denominator2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return countScores;
    }
    
    
    public boolean getResult(double scores) {
        System.out.println(scores);
        if (scores >= 0.85)
            return true;
        else 
            return false;
    }
    
    
    public boolean getEasyResult(double scores) {
        System.out.println(scores);
        if (scores >= 0.75)
            return true;
        else 
            return false;
    }

}
