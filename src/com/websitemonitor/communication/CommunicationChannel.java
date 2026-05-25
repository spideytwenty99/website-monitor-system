package com.websitemonitor.communication;

// Base class for all communication methods.
 public abstract class CommunicationChannel {
    protected String type;

    public abstract void deliverMessage(String message);
}
