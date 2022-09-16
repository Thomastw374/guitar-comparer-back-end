package com.example.guitarsuggester;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "user_guitar")
public class UserGuitar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String guitarName;
    protected String guitarPrice;
    protected String guitarPicUrl;
    protected String guitarDescription;
    protected String userKey;

    public UserGuitar() {
    }

    public UserGuitar(String guitarName, String guitarPrice, String guitarPicUrl, String guitarDescription, String userKey) {
        this.guitarName = guitarName;
        this.guitarPrice = guitarPrice;
        this.guitarPicUrl = guitarPicUrl;
        this.guitarDescription = guitarDescription;
        this.userKey = userKey;
    }

    public UserGuitar(int id, String guitarName, String guitarPrice, String guitarPicUrl, String guitarDescription, String userKey) {
        this.id = id;
        this.guitarName = guitarName;
        this.guitarPrice = guitarPrice;
        this.guitarPicUrl = guitarPicUrl;
        this.guitarDescription = guitarDescription;
        this.userKey = userKey;
    }

    public UserGuitar(String guitarName, String guitarPrice, String guitarPicUrl, String guitarDescription) {
        this.guitarName = guitarName;
        this.guitarPrice = guitarPrice;
        this.guitarPicUrl = guitarPicUrl;
        this.guitarDescription = guitarDescription;
        this.userKey = generateUserKey();
    }

    public static String generateUserKey() {
        String userKey = "";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        for (int i = 0; i <= 32; i++) {
            Random random = new Random();
            userKey += characters.charAt(random.nextInt(characters.length()));
        }

        return userKey;
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
