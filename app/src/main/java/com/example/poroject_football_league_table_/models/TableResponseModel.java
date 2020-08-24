package com.example.poroject_football_league_table_.models;

import java.util.List;

public class TableResponseModel {
    private List<StandingModel> standings;

    public StandingModel getTotalTableStanding() {
        if (standings != null) {
            for (StandingModel standing : standings) {
                if ("TOTAL".equals(standing.getType())) {
                    return standing;
                }
            }
        }
        return null;
    }
}
