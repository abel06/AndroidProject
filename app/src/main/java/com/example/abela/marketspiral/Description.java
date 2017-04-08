package com.example.abela.marketspiral;

/**
 * Created by Abela on 3/18/2017.
 */

public class Description {
    private String name;
    private String description;
    private int thumbnail;

    public Description() {
    }

    public Description(String name, String description) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
/*
    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }*/
}
