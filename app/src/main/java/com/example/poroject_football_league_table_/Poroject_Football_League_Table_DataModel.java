package com.example.poroject_football_league_table_;

public class Poroject_Football_League_Table_DataModel {
    private int Rows;
    private int ImgResource_Flags;
    private String Teams;
    private int Games;
    private int Win;
    private int Lose;
    private int DifferentialOfGoals;
    private int Points;
    private String flagUrl;

    public Poroject_Football_League_Table_DataModel(int Rows, int ImgResource_Flags, String Teams, int Games, int win, int lose, int DifferentialOfGoals, int Points) {
        this.Rows = Rows;
        this.ImgResource_Flags = ImgResource_Flags;
        this.Teams = Teams;
        this.Games = Games;
        this.Win = win;
        this.Lose = lose;
        this.DifferentialOfGoals = DifferentialOfGoals;
        this.Points = Points;
    }

    public Poroject_Football_League_Table_DataModel(int Rows, int ImgResource_Flags, String Teams, int Games, int win, int lose, int DifferentialOfGoals, int Points, String flagUrl) {
        this.Rows = Rows;
        this.ImgResource_Flags = ImgResource_Flags;
        this.Teams = Teams;
        this.Games = Games;
        this.Win = win;
        this.Lose = lose;
        this.DifferentialOfGoals = DifferentialOfGoals;
        this.Points = Points;
        this.flagUrl = flagUrl;
    }

    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        this.Rows = rows;
    }

    public int getImgresourceFLAG() {
        return ImgResource_Flags;
    }

    public void setImgresourceFLAG(int imgresourceFLAG) {
        this.ImgResource_Flags = imgresourceFLAG;
    }

    public String getTeams() {
        return Teams;
    }

    public void setTeams(String teams) {
        this.Teams = teams;
    }

    public int getGames() {
        return Games;
    }

    public void setGames(int games) {
        this.Games = games;
    }

    public int getWin() {
        return Win;
    }

    public void setWin(int win) {
        this.Win = win;
    }

    public int getLose() {
        return Lose;
    }

    public void setLose(int lose) {
        this.Lose = lose;
    }

    public int getDifferentialOfGoals() {
        return DifferentialOfGoals;
    }

    public void setDifferentialOfGoals(int differentialOfGoals) {
        this.DifferentialOfGoals = differentialOfGoals;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        this.Points = points;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}
