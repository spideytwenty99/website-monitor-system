package com.websitemonitor.communication;

 public abstract class CommunicationChannel {
    protected String type;

    public abstract void deliverMessage(String message);
}
