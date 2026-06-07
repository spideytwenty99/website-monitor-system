package com.websitemonitor.ObserverPattern;

import com.websitemonitor.communication.CommunicationChannel;
import com.websitemonitor.model.User;

//Concrete Observer in the Observer Pattern
//Sends notifications to user after update detection
public class Notifications implements Observer{

    private User user;
    public Notifications(User u){
        this.user=u;

    }

    @Override
    public void update(String websiteUrl) {
        String msg ="Update detected on: " + websiteUrl;
        sendNotification(msg);

    }
    public void sendNotification(String message){
        for (CommunicationChannel channel: user.getChannels()){
            channel.deliverMessage(message);
        }
    }

}
