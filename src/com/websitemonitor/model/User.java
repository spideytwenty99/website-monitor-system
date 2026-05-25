package com.websitemonitor.model;
import com.websitemonitor.communication.CommunicationChannel;

import java.util.ArrayList;

public class User {

    private String username;
    private int userID;
    private  String email;
    private String password;

    private ArrayList<Subscription>subscriptions=new ArrayList<>();
    private ArrayList<CommunicationChannel>channels=new ArrayList<>();

    public User(String uname, int uID, String email, String pwd){
        this.username=uname;
        this.userID=uID;
        this.email=email;
        this.password=pwd;

    }

    public void register(){
        System.out.println("Creating a new account");
    }

    public boolean login(String enteredPassword){
    if (enteredPassword.equals(password)){
        return true;
    }
    return false;
    }


    public void logOut() {
        System.out.println("Logged out successfully");
    }

    public String getUsername(){
        return username;
    }

    public void addChannel(CommunicationChannel c){
        channels.add(c);
    }
    public void addSubscription(Subscription s){
        subscriptions.add(s);
    }

    public ArrayList<CommunicationChannel> getChannels(){
        return channels;
    }



}
