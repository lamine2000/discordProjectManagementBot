package com.lamine.model;

import org.bson.types.ObjectId;

public class User {
    String uid;

    public User(String uid) {
        this.uid = uid;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
