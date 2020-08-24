package com.example.a9gag;

public class ImageItem {

    int imgResource;
    String description;
    int points;
    int comments;
    boolean isButtonUpPressed;
    boolean isButtonDownPressed;

    public ImageItem(int imgResource, String description) {
        this.imgResource = imgResource;
        this.description = description;
        this.points = 0;
        this.comments = 0;
        this.isButtonUpPressed = false;
        this.isButtonDownPressed = false;
    }

}
