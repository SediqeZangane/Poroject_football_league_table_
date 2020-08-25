package com.example.poroject_football_league_table_.models;

import com.example.poroject_football_league_table_.Poroject_Football_League_Table_DataModel;
import com.example.poroject_football_league_table_.R;

public class TableItemModel {
    private TeamModel team;
    private int position;
    private int playedGames;
    private int won;
    private int draw;
    private int lost;
    private int points;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;

    public Poroject_Football_League_Table_DataModel convertToAdapterModel() {
        return new Poroject_Football_League_Table_DataModel(points, R.drawable.ic_baseline_flag_24, team.getName(), playedGames, won, lost, goalDifference, points, team.getCrestUrl());
    }
}
