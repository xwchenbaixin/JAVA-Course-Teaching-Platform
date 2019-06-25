package com.jctp.tools;

public class TermDict {
	//term为词
    private String term;
    //词频
    private int freq;
    
    public TermDict(String term, int freq) 
    {
        this.term = term;
        this.freq = freq;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }
    
}
