package com.websitemonitor.ObserverPattern;

import com.websitemonitor.StrategyPattern.ComparingContentSize;
import com.websitemonitor.StrategyPattern.ComparingHtmlContent;
import com.websitemonitor.StrategyPattern.ComparingTextContent;
import com.websitemonitor.communication.Gmail;
import com.websitemonitor.communication.Sms;
import com.websitemonitor.gui.GUI;
import com.websitemonitor.model.Registration;
import com.websitemonitor.model.Subscription;
import com.websitemonitor.model.User;
import com.websitemonitor.model.Website;


public class Main {

    public static void main(String[] args) {

        GUI g=new GUI();
        g.displayInterface();

        SoftwareController controller=new SoftwareController();

        User u1=new User("saruabh10",10,"saruabh@gmail.com","theGoatMessi");
        u1.addChannel(new Gmail("saurabh@gmail.com"));
        u1.addChannel(new Sms("015754984846"));

        User u2 = new User("Thomas", 11, "thomas@gmail.com", "thomas123");
        u2.addChannel(new Gmail("thomas@gmail.com"));

        Registration r1 = new Registration(100);
        Registration r2 = new Registration(101);
        controller.handleUserRegistration(r1, u1);
        controller.handleUserRegistration(r2, u2);

        Website w       = new Website("https://java&uml.com","<h1>Hello</h1>","Hello");
        Subscription s1 = new Subscription(1042, w);
        Subscription s2 = new Subscription(1043, w);
        u1.addSubscription(s1);
        u2.addSubscription(s2);

        System.out.println();
        controller.handleSubscriptionActivation(s1);
        controller.handleSubscriptionActivation(s2);
        System.out.println();


        String oldHtmlContent=w.getHtmlContent();
        String oldTextContent=w.getTextContent();

        //Website updated!!
        w.setNewHtmlContent("<h2>Hallo</h2>");
        w.setNewTextContent("Hallo");

        String newHtmlContent=w.getHtmlContent();
        String newTextContent=w.getTextContent();

        UpdateChecker c  = new UpdateChecker(10);

        Notifications n1 = new Notifications(u1);
        Notifications n2 = new Notifications(u2);
        controller.handleRegisterObserver(c,n1);
        controller.handleRegisterObserver(c,n2);
        System.out.println();


        //Size comparison strategy is used here
        c.setComparingStrategy(new ComparingContentSize());
        boolean detectSizeChange=c.detectUpdate(oldHtmlContent,newHtmlContent);

        //Comparison strategy is set to ComparingHtml
        c.setComparingStrategy(new ComparingHtmlContent());
        boolean detectHtmlChange=c.detectUpdate(oldHtmlContent,newHtmlContent);

        //Comparison strategy is set to ComparingText
        c.setComparingStrategy(new ComparingTextContent());
        boolean detectTextChange=c.detectUpdate(oldTextContent,newTextContent);

        //UpdateDetected becomes true, if one of the changes is detected
        if (detectSizeChange || detectHtmlChange || detectTextChange){
                c.setUpdateDetected(true);
        }


        controller.handleUpdateRequest(c, w);

        System.out.println("\n--- u1 unsubscribes ---");
        controller.handleSubscriptionDeactivation(s1);
        c.detachObserver(n1);

        System.out.println("\n--- Now only u2 gets notified ---");
        c.checkForUpdates(w);


    }

}
