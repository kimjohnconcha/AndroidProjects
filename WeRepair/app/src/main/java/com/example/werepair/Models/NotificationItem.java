package com.example.werepair.Models;

public class NotificationItem {
    private String datetime;
    private String notification;
    private int profile_icon;

    public  NotificationItem(String datetime, int profile_icon, String notification) {
        this.setDatetime(datetime);
        this.setProfile_icon(profile_icon);
        this.setNotification(notification);
    }

    public int getProfile_icon() {
        return profile_icon;
    }

    public void setProfile_icon(int profile_icon) {
        this.profile_icon = profile_icon;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
