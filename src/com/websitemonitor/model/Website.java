package com.websitemonitor.model;


//Represents a monitored website
public class Website {
   private String url;

    //Added two new variables to demonstrate strategy pattern
    private String htmlContent;
    private String textContent;

    public Website(String url, String htmlContent, String textContent){
        this.url         = url;
        this.htmlContent = htmlContent;
        this.textContent = textContent;
    }

    public String getUrl(){
        return url;
    }

    public String getHtmlContent(){
        return htmlContent;
    }

    public String getTextContent(){
        return textContent;
    }

    public int getContentSize(){
        return htmlContent.length();
    }

    //Added two  new setter methods to manually update the website, that will help us detect updates
    //using different comparison strategy to demonstrate strategy pattern
    public void setNewHtmlContent(String newHtmlContent){
        this.htmlContent=newHtmlContent;
    }

    public void setNewTextContent(String newTextContent){
        this.textContent=newTextContent;
    }

}

