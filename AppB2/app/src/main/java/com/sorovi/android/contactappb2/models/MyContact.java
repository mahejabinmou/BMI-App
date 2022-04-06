package com.sorovi.android.contactappb2.models;

import java.util.ArrayList;
import java.util.List;

public class MyContact {
    private String name;
    private String mobile;
    private String email;
    private String streetAddress;
    private String image;

    public MyContact(String name, String mobile, String email, String streetAddress, String image) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.streetAddress = streetAddress;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static List<MyContact> getContacts() {
        final List<MyContact> contacts = new ArrayList<>();
        contacts.add(new MyContact(
                "Limon",
                "0156565788",
                "lim@gmail.com",
                "Dhanmondi, Dhaka", null));
        contacts.add(new MyContact(
                "milon",
                "01565765788",
                "mil@gmail.com",
                "Farmgate, Dhaka", null));

        return contacts;
    }
}
