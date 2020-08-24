
package com.example.poroject_football_league_table_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.poroject_football_league_table_.models.StandingModel;
import com.example.poroject_football_league_table_.models.TableItemModel;
import com.example.poroject_football_league_table_.models.TableResponseModel;
import com.example.poroject_football_league_table_.network.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class Poroject_Football_League_Table_MainActivity extends AppCompatActivity {
    RecyclerView RowsOfRecyclerViewsData;
    List<Poroject_Football_League_Table_DataModel> DataModels;
    Poroject_Football_League_Table_Adapter MyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poroject__football__league_table_);
        DataModels = new ArrayList<>();
        DataModels.add(new Poroject_Football_League_Table_DataModel(1, R.drawable.ic_baseline_flag_24, "milan", 3, 2, 1, 4, 6));
        DataModels.add(new Poroject_Football_League_Table_DataModel(2, R.drawable.ic_baseline_flag_24, "inter", 7, 2, 5, 4, 3));

        // Call league table method as async and in response use data for update
        RetrofitManager.getFootballApi().getLeagueTable().enqueue(new Callback<TableResponseModel>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<TableResponseModel> call, Response<TableResponseModel> response) {
                if (response.body() != null) {
                    StandingModel standingModel = response.body().getTotalTableStanding();
                    if (standingModel != null) {
                        List<Poroject_Football_League_Table_DataModel> newData = new ArrayList<>();
                        for (TableItemModel tableItem : standingModel.getTableItems()) {
                            newData.add(tableItem.convertToAdapterModel());
                        }
                        MyAdapter.swapData(newData);
                    }
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<TableResponseModel> call, Throwable t) {
                int a = 0;
            }
        });

        InitialViews();
        ControlViews();
    }

    private void InitialViews() {
        RowsOfRecyclerViewsData = findViewById(R.id.RecyclerView_Data_Of_Rows);
    }

    private void ControlViews() {
        MyAdapter = new Poroject_Football_League_Table_Adapter(Poroject_Football_League_Table_MainActivity.this, DataModels);
        RecyclerView.LayoutManager lManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();


        RowsOfRecyclerViewsData.setLayoutManager(lManager);
        RowsOfRecyclerViewsData.setItemAnimator(animator);
        RowsOfRecyclerViewsData.setAdapter(MyAdapter);
    }
}