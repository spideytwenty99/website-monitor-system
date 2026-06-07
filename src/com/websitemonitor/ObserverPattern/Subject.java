package com.websitemonitor.ObserverPattern;

//Observer pattern interface for managing observers.
public interface Subject {
    void attachObserver(Observer o);
    void detachObserver(Observer o);
    void notifyObserver(String websiteUrl);
}
