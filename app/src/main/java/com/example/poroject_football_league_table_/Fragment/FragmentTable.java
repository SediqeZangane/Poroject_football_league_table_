package com.example.poroject_football_league_table_.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poroject_football_league_table_.Poroject_Football_League_Table_Adapter;
import com.example.poroject_football_league_table_.Poroject_Football_League_Table_DataModel;
import com.example.poroject_football_league_table_.R;
import com.example.poroject_football_league_table_.models.StandingModel;
import com.example.poroject_football_league_table_.models.TableItemModel;
import com.example.poroject_football_league_table_.models.TableResponseModel;
import com.example.poroject_football_league_table_.network.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTable#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTable extends Fragment {
    Poroject_Football_League_Table_Adapter adapterTable;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTable() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentTable.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTable newInstance() {
        FragmentTable fragment = new FragmentTable();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.table_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RetrofitManager.getFootballApi().getSALeagueTable().enqueue(new Callback<TableResponseModel>() {
            @Override
            public void onResponse(Call<TableResponseModel> call, Response<TableResponseModel> response) {
                if (response.body() != null) {
                    StandingModel standingModel = response.body().getTotalTableStanding();
                    if (standingModel != null) {
                        List<Poroject_Football_League_Table_DataModel> newData = new ArrayList<>();
                        for (TableItemModel tableItemModel : standingModel.getTableItems()) {
                            newData.add(tableItemModel.convertToAdapterModel());
                        }
                        adapterTable.swapData(newData);
                    }
                }
            }

            @Override
            public void onFailure(Call<TableResponseModel> call, Throwable t) {
                int a = 0;
            }
        });
    }
}