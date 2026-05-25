package com.websitemonitor.controller;

import com.websitemonitor.model.*;
import com.websitemonitor.service.UpdateChecker;

// GRASP Controller that coordinates system operations.
public class SoftwareController {
    public void handleUserRegistraion(Registration r, User u){
        r.createAccount(u);

    }
    public void handleSubscriptionActivation(Subscription s) {
        s.activate();
    }

    public void handleSubscriptionDeactivation(Subscription s) {
        s.deactivate();
    }

    public void handleSubscriptionModification(Subscription s, int f) {
        s.setFrequency(f);
    }

    public void handleUpdateRequest(UpdateChecker c, Website w){
        c.monitor(w);
        if (c.detectUpdate()){
            System.out.println("Update detected on website: "+w.getUrl());
        }

    }

    public void handleNotificationRequest(User u, String msg){
        Notifications n=new Notifications(msg);
        n.sendNotification(u);
    }
}
