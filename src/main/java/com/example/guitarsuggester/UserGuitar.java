package com.example.guitarsuggester;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserGuitar {

    protected int id;
    protected String guitarName;
    protected String guitarPrice;
    protected String guitarPicUrl;
    protected String guitarDescription;
    protected String userKey;

    public UserGuitar() {
    }

    public UserGuitar(int id, String guitarName, String guitarPrice, String guitarPicUrl, String guitarDescription) {
        this.id = id;
        this.guitarName = guitarName;
        this.guitarPrice = guitarPrice;
        this.guitarPicUrl = guitarPicUrl;
        this.guitarDescription = guitarDescription;
        this.userKey = userKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuitarName() {
        return guitarName;
    }

    public void setGuitarName(String guitarName) {
        this.guitarName = guitarName;
    }

    public String getGuitarPrice() {
        return guitarPrice;
    }

    public void setGuitarPrice(String guitarPrice) {
        this.guitarPrice = guitarPrice;
    }

    public String getGuitarPicUrl() {
        return guitarPicUrl;
    }

    public void setGuitarPicUrl(String guitarPicUrl) {
        this.guitarPicUrl = guitarPicUrl;
    }

    public String getGuitarDescription() {
        return guitarDescription;
    }

    public void setGuitarDescription(String guitarDescription) {
        this.guitarDescription = guitarDescription;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
