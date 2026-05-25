package com.websitemonitor.service;

import com.websitemonitor.model.Website;

// Monitors websites and detects updates.
public class UpdateChecker {
    private int checkInterval;
    public UpdateChecker(int interval){
        this.checkInterval=interval;

    }
    public void monitor(Website w){
        System.out.println("Monitoring website: "+w.getUrl() );
    }

    public boolean detectUpdate(){
        return true;
    }
}
