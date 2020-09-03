package com.example.poroject_football_league_table_.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poroject_football_league_table_.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class League_Adapter extends RecyclerView.Adapter<League_Adapter.MyViewHolder> {
    private Context context;
    private List<League_DateModel> LeagueData;

    public League_Adapter(Context context, List<League_DateModel> leagueData) {
        this.context = context;
        LeagueData = leagueData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.league_rv_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Control Views
        League_DateModel League_Data = LeagueData.get(position);
        holder.LeaguePic.setImageResource(League_Data.getPicture());
        holder.LeagueName.setText(League_Data.getLeagueName());
    }


    @Override
    public int getItemCount() {
        return LeagueData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // create Views
        private ImageView LeaguePic;
        private TextView LeagueName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            init Views
            LeaguePic = itemView.findViewById(R.id.League_Pic);
            LeagueName = itemView.findViewById(R.id.League_Name);
        }
    }
}