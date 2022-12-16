package com.example.backend.util;

public class MessegeStatus {

    private String returnMessage;
    private String status; // fail , sussces , pending

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MessegeStatus(String returnMessage, String status) {
        this.returnMessage = returnMessage;
        this.status = status;
    }

}
