package com.example.poroject_football_league_table_;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataOnline {
    String BaseUrl="http://dl.android-studio.ir/files/";
    @GET("city.json")
    Call<List<Poroject_Football_League_Table_DataModel>>GetData();
}
