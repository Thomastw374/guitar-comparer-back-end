package com.example.guitarsuggester;


public class NewUserGuitar {
    protected String guitarName;
    protected String guitarPrice;
    protected String guitarPicUrl;
    protected String guitarDescription;

    public NewUserGuitar(String guitarName, String guitarPrice, String guitarPicUrl, String guitarDescription) {
        this.guitarName = guitarName;
        this.guitarPrice = guitarPrice;
        this.guitarPicUrl = guitarPicUrl;
        this.guitarDescription = guitarDescription;
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
}
