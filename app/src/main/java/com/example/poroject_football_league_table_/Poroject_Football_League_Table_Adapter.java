package com.example.poroject_football_league_table_;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Poroject_Football_League_Table_Adapter extends RecyclerView.Adapter<Poroject_Football_League_Table_Adapter.MyViewHolder> {

    private Activity Context;
    private List<Poroject_Football_League_Table_DataModel> DataModels;

    public Poroject_Football_League_Table_Adapter(Activity Context, List<Poroject_Football_League_Table_DataModel> DataModels) {
        this.Context = Context;
        this.DataModels = DataModels;
    }

    public void swapData(List<Poroject_Football_League_Table_DataModel> newData) {
        DataModels.clear();
        DataModels.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Context).inflate(R.layout.poroject_football_league_table_data_model, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        control views
        Poroject_Football_League_Table_DataModel DATAMODEL = DataModels.get(position);
        holder.TxtRow.setText(DATAMODEL.getRows() + "");
        holder.TxtTeam.setText(DATAMODEL.getTeams() + "");
        holder.TxtGame.setText(DATAMODEL.getGames() + "");
        holder.TxtWin.setText(DATAMODEL.getWin() + "");
        holder.TxtLose.setText(DATAMODEL.getLose() + "");
        holder.TxtDiffrentialOfGoals.setText(DATAMODEL.getDifferentialOfGoals() + "");
        holder.TxtPoints.setText(DATAMODEL.getPoints() + "");

        holder.ImgFlag.setImageResource(DATAMODEL.getImgresourceFLAG());

//        listener


    }

    @Override
    public int getItemCount() {
        return DataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        create views
        private CardView cardView;
        private TableRow tableRow1;
        private ImageView ImgFlag;
        private TextView TxtRow;
        private TextView TxtTeam;
        private TextView TxtGame;
        private TextView TxtWin;
        private TextView TxtLose;
        private TextView TxtDiffrentialOfGoals;
        private TextView TxtPoints;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //            init views
            ImgFlag = itemView.findViewById(R.id.Img_Flag);
            TxtRow = itemView.findViewById(R.id.Txt_Row);
            TxtTeam = itemView.findViewById(R.id.Txt_Flag);
            TxtGame = itemView.findViewById(R.id.Txt_Team);
            TxtWin = itemView.findViewById(R.id.Txt_Game);
            TxtLose = itemView.findViewById(R.id.Txt_Win);
            TxtDiffrentialOfGoals = itemView.findViewById(R.id.Txt_Lose);
            TxtPoints = itemView.findViewById(R.id.Txt_Diffrential_Of_Goal);


        }
    }
}
