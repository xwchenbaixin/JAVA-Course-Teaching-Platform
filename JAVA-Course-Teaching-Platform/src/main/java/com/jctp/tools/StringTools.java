package com.jctp.tools;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;

import net.minidev.json.JSONObject;

public class StringTools {
	public static String upperCharToUnderLine(String param) {
			Pattern p=Pattern.compile("[A-Z]"); 
			if(param==null ||param.equals("")){  
		            return "";
		        }  
		        StringBuilder builder=new StringBuilder(param);  
		        Matcher mc=p.matcher(param);  
		        int i=0; 
		        while (mc.find()) {
		            builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());  
		            i++;
		        }  
		  
		        if('_' == builder.charAt(0)){  
		            builder.deleteCharAt(0);  
		        }  
		        return builder.toString();  
		    }
	
	public static String subDate(Timestamp endDateStr) {
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String lastTime="";
	    try  
	    {  
	      Date startDate = new Date();
	      Date endDate = endDateStr;  
	      long diff = endDate.getTime() - startDate.getTime();//这样得到的差值是毫秒级别  
	      long days = diff / (1000 * 60 * 60 * 24);  
	   
	      long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
	      long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);  
	      if(days>0)
	    	  lastTime=days+"天";
	      if(hours>0)
	    	  lastTime+=hours+"小时";
	      if(minutes>=0)
	    	  lastTime+=minutes+"分";
	      if(minutes<0)
	    	  lastTime="overtime";
	    }catch (Exception e)  
	    { 
	    	e.printStackTrace();
	    }
	    return lastTime;
	    
	}
	
	public static List<Map<String,String>> jsonArrayToList(String jsonStr){
		if(jsonStr==null||jsonStr=="")
			return null;
		ObjectMapper objectMapper = new ObjectMapper();
		CollectionLikeType type = objectMapper.getTypeFactory().constructCollectionLikeType(List.class, Map.class);
		List<Map<String,String>> listMap=null;
		try {
			listMap= objectMapper.readValue(jsonStr, type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMap;
	}
	
	public static Map<String, String> jsonStrToMap(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map=null;
		try {
			map = mapper.readValue(jsonStr, Map.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;		
	}
	
}
