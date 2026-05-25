package com.websitemonitor.model;

import com.websitemonitor.communication.CommunicationChannel;

// Creates and sends notification messages.
public class Notifications {
    private String message;

    public Notifications(String msg){
        this.message=msg;
    }

    public String getMessage(){
        return message;
    }

    public void sendNotification(User u){
            for (CommunicationChannel channel:u.getChannels()) {
                channel.deliverMessage(message);
        }
    }
}
