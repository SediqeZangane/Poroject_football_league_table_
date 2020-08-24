package com.example.poroject_football_league_table_.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StandingModel {
    private String stage;
    private String type;
    @SerializedName("table")
    private List<TableItemModel> tableItems;

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TableItemModel> getTableItems() {
        return tableItems;
    }

    public void setTableItems(List<TableItemModel> tableItems) {
        this.tableItems = tableItems;
    }
}
