package com.websitemonitor.ObserverPattern;



import com.websitemonitor.model.*;


// GRASP Controller that coordinates system operations.
public class SoftwareController {
    public void handleUserRegistration(Registration r, User u){
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

    public void handleRegisterObserver(UpdateChecker c, Observer o){
        c.attachObserver(o);
    }

    public void handleUpdateRequest(UpdateChecker c, Website w){
      c.checkForUpdates(w);
    }


    //This method is removed for the observer pattern because, observer pattern handles notifications and updates automatically now
//    public void handleNotificationRequest(User u, String msg){
//        Notifications n=new Notifications(msg);
//        n.sendNotification(u);
//    }
}
