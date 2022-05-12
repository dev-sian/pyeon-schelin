package com.devsian.post;

public enum PostType {
    REVIEW_POST("REVIEW_POST"), GENERAL_POST("GENERAL_POST");

    private final String value;

    PostType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
