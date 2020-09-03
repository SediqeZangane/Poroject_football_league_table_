package com.example.poroject_football_league_table_.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.poroject_football_league_table_.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ControlView();
    }

    private void ControlView() {
        FragmentLeague frgLeague = FragmentLeague.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frg_holder, frgLeague);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
