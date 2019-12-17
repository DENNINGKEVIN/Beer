package com.mulama.beer_superior.models;

public class BeerModel {
    String pombeImage;
    String pombeText;

    public BeerModel(String pombeImage, String pombeText) {
        this.pombeImage = pombeImage;
        this.pombeText = pombeText;
    }

    public String getPombeImage() {
        return pombeImage;
    }

    public void setPombeImage(String pombeImage) {
        this.pombeImage = pombeImage;
    }

    public String getPombeText() {
        return pombeText;
    }

    public void setPombeText(String pombeText) {
        this.pombeText = pombeText;
    }
}
