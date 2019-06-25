package com.jctp.tools;

public class ElementDict {
    private String term;
    private int freq;
    
    public ElementDict(String term, int freq) {
        this.term = term;
        this.freq = freq;
    }
    
    
    public void setFreq (int freq) {
        this.freq = freq;
    }

    
    public String getTerm() {
        return term;
    }

    
    public int getFreq() {
        return freq;
    }

}
