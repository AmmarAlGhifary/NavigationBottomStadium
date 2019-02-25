package com.blogspot.yourfavoritekaisar.navigationbottomstadium.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StadiumResponse {

    @SerializedName("teams")
    private List<StadiumData> stadium;

    public List<StadiumData> getTeams() {
        return stadium;
    }

    public void setStadium(List<StadiumData> stadium) {
        this.stadium = stadium;
    }
}
