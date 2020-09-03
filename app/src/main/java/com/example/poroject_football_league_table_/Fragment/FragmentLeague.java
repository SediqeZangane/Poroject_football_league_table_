package com.example.poroject_football_league_table_.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poroject_football_league_table_.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLeague#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLeague extends Fragment {
    RecyclerView leagueRVitem;
    League_Adapter LeagueAdapter;
    List<League_DateModel> DataLeague;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLeague() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentLeague.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLeague newInstance() {
        FragmentLeague fragment = new FragmentLeague();
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
        return inflater.inflate(R.layout.league_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        ControlViews();
    }

    private void initViews() {
        leagueRVitem = getView().findViewById(R.id.league_rv);

    }

    private void ControlViews() {
        DataLeague = new ArrayList<>();
        DataLeague.add(new League_DateModel(R.drawable.ic_baseline_flag_24,"ali"));
        DataLeague.add(new League_DateModel(R.drawable.ic_baseline_flag_24,"hasan"));

        LeagueAdapter = new League_Adapter(this.getContext(), DataLeague);
        RecyclerView.LayoutManager LManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);

        leagueRVitem.setLayoutManager(LManager);
        leagueRVitem.setAdapter(LeagueAdapter);
    }
}