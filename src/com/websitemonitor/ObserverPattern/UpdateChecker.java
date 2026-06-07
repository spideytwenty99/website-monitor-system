package com.websitemonitor.ObserverPattern;

import com.websitemonitor.StrategyPattern.ComparingStrategy;
import com.websitemonitor.model.Website;
import java.util.ArrayList;

//Concrete Subject in the Observer pattern and Context class in the Strategy pattern.
//Monitor websites and checks for updates.
public class UpdateChecker implements Subject {

    private int checkInterval;
    private ComparingStrategy comparingStrategy;
    private boolean updateDetected;
    private ArrayList<Observer>observers=new ArrayList<>();

    public UpdateChecker(int interval){
        this.checkInterval  = interval;
        this.updateDetected = false;
    }

    public void setComparingStrategy(ComparingStrategy comparingStrategy){
        this.comparingStrategy=comparingStrategy;
    }

    public void setUpdateDetected(boolean update){
        this.updateDetected=update;
    }

    @Override
    public void attachObserver(Observer o) {
        observers.add(o);
        System.out.println("Observer attached successfully");
    }

    @Override
    public void detachObserver(Observer o) {
        observers.remove(o);
        System.out.println("Observer removed successfully");
    }

    @Override
    public void notifyObserver(String websiteUrl) {
        System.out.println("Notifying observers of change on: "+websiteUrl);
        for (Observer o: observers){
            o.update(websiteUrl);
        }
    }

    public void monitor(Website w){
        System.out.println("\nMonitoring: "+w.getUrl());
    }

    //detectUpdate method is changed so that a selected comparison can be used to detect different changes in website
    public  boolean detectUpdate(String oldContent,String newContent){
        return comparingStrategy.compare(oldContent,newContent);
    }

    //checkForUpdates method is also changed to accommodate with the existing different comparison strategy
    public void checkForUpdates(Website w){
        monitor(w);
        if (updateDetected){
            notifyObserver(w.getUrl());
        }
    }
}

