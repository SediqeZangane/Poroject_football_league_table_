package com.example.poroject_football_league_table_.network;

import com.example.poroject_football_league_table_.models.TableResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FootballApi {
    /**
     * Get data of serie A league table
     */
    @GET("/v2/competitions/SA/standings")
    Call<TableResponseModel> getLeagueTable();
}
