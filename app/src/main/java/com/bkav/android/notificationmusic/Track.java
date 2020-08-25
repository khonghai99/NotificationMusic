package com.bkav.android.notificationmusic;

public class Track {
    private String title;
    private String Artist;
    private int image;

    public Track(String title, String artist, int image) {
        this.title = title;
        Artist = artist;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
