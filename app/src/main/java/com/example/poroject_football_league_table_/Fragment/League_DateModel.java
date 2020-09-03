package com.example.poroject_football_league_table_.Fragment;

public class League_DateModel {
    private int Picture;
    private String LeagueName;

    public League_DateModel(int picture, String leagueName) {
        Picture = picture;
        LeagueName = leagueName;
    }

    public int getPicture() {
        return Picture;
    }

    public String getLeagueName() {
        return LeagueName;
    }
}
