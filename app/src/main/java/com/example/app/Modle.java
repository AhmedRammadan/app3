package com.example.app;

public class Modle {
    private String title;
    private String descrpition;
    private int image;

    public Modle() {
    }

    public Modle(String title, String descrpition, int image) {
        this.title = title;
        this.descrpition = descrpition;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String dec) {
        this.descrpition = dec;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
