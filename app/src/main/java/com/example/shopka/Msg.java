package com.example.shopka;

public class Msg {
    public String msg;
    public String imageURL;
    public Msg(){

    }
    public Msg(String imageURL, String msg) {
        this.msg = msg;
        this.imageURL = imageURL;
    }
    public String getImage() {
        return imageURL;
    }

    public String getMsg() {
        return msg;
    }


}
