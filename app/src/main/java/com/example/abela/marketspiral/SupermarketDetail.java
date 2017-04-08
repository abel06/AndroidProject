package com.example.abela.marketspiral;

/**
 * Created by Abela on 3/20/2017.
 */

public class SupermarketDetail {
    private String title;
    private String subtitle;
    private int thumbnail;

    public SupermarketDetail() {
    }

    public SupermarketDetail(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String getSubtitle(){
        return subtitle;
    }

    public void setSubtitle(int numOfSongs) {
        this.subtitle = subtitle;
    }


}