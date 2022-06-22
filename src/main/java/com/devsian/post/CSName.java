package com.devsian.post;

public enum CSName {
    GS25("GS25"), CU("CU"), _7ELEVEN("7ELEVEN"), MINISTOP("MINISTOP"), EMART24("EMART24");

    private final String value;

    CSName(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
