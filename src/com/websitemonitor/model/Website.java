package com.websitemonitor.model;


//Represents a monitored website
public class Website {
    String url;

    public Website(String url){
        this.url=url;
    }

    public String getUrl(){
        return url;
    }
}
