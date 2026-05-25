package com.websitemonitor.model;

public class Subscription {

    private String status;
    private int subsID;
    private int frequency;
    private Website website; // com.websitemonitor.model.Subscription class depends on the class  com.websitemonitor.model.Website!!

    public Subscription( int subsID, Website w){
        this.status="active";
        this.subsID=subsID;
        this.website=w;

    }

    public void activate(){
        if (status.equals("active")){
            System.out.println("com.websitemonitor.model.Subscription activated");
        }
    }

    public void deactivate(){
        if (status.equals("inactive")){
            System.out.println("com.websitemonitor.model.Subscription deactivated");
        }
    }

    public Website getWebsite(){
        return website;
    }
    public String getStatus(){
        return status;
    }
    public void setFrequency(int f){
        this.frequency=f;
    }
    public void setStatus(String status){
        this.status=status;
    }

}
