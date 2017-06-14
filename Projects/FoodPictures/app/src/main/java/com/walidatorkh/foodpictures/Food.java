package com.walidatorkh.foodpictures;

/**
 * Created by jbt on 14/06/2017.
 */

public class Food {
    private String name;
    private int imageID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Food(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }
}
