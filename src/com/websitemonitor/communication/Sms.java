package com.websitemonitor.communication;

public class Sms extends CommunicationChannel {
    private String phoneNumber;

    public Sms(String phoneNumber){
        this.phoneNumber=phoneNumber;
        this.type="SMS";
    }

    @Override
    public void deliverMessage(String message) {
        System.out.println("Sending a sms to "+phoneNumber+" Notification: "+message);
    }
}
