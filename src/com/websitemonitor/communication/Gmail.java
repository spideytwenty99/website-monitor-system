package com.websitemonitor.communication;

//Sends notification via email.
public class Gmail extends CommunicationChannel {

    private String emailAddress;

    public Gmail(String eaddress){
        this.emailAddress = eaddress;
        this.type         = "Email";
    }

    @Override
    public void deliverMessage(String message) {
        System.out.println("Sending email at "+emailAddress+ ".Notification: "+message);

    }
}
