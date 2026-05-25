package com.websitemonitor.main;

import com.websitemonitor.communication.Gmail;
import com.websitemonitor.communication.Sms;
import com.websitemonitor.controller.SoftwareController;
import com.websitemonitor.gui.GUI;
import com.websitemonitor.model.Registration;
import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.User;
import com.websitemonitor.model.Website;
import com.websitemonitor.service.UpdateChecker;

public class Main {


    public static void main(String[] args) {

        // Create GUI
        GUI g=new GUI();
        g.displayInterface();

        // Create controller
        SoftwareController controller=new SoftwareController();

        // Create user
        User u1=new User("saurabh10", 10,"saurabh@gmail.com","theGoatMessi");

        // Add communication channels
        u1.addChannel(new Gmail("saurabh@gmail.com"));
        u1.addChannel(new Sms("01241536"));

        // Registration
        Registration r=new Registration(100);
        controller.handleUserRegistraion(r,u1);

        // Website and subscription
        Website w=new Website("https://10ReasonswhyMessiIsGoat.com");
        Subscription s=new Subscription(1042, w);

        controller.handleSubscriptionActivation(s);

        //Update checking
        UpdateChecker checker=new UpdateChecker(10);
        controller.handleUpdateRequest(checker,w);

        // Send notification
        controller.handleNotificationRequest(u1,"Update detected for: " +w.getUrl());

    }

}
