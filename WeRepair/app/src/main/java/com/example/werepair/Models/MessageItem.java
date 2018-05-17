package com.example.werepair.Models;

public class MessageItem {
    private String datetime;
    private String message;
    private int profile_icon;

    public MessageItem(String datetime, String message, int profile_icon) {
        this.setDatetime(datetime);
        this.setProfile_icon(profile_icon);
        this.setMessage(message);
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getProfile_icon() {
        return profile_icon;
    }

    public void setProfile_icon(int profile_icon) {
        this.profile_icon = profile_icon;
    }
}
