package com.example.hackathon;

public class Item {

    String itemName, itemEmail, itemProfile;

    public String getItemName() {
        return itemName;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getItemEmail() {
        return itemEmail;
    }

    public Item setItemEmail(String itemEmail) {
        this.itemEmail = itemEmail;
        return this;
    }

    public String getItemProfile() {
        return itemProfile;
    }

    public Item setItemProfile(String itemProfile) {
        this.itemProfile = itemProfile;
        return this;
    }

    public Item(String itemName, String itemEmail, String itemProfile) {
        this.itemName = itemName;
        this.itemEmail = itemEmail;
        this.itemProfile = itemProfile;
    }
}
