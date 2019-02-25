package com.blogspot.yourfavoritekaisar.navigationbottomstadium.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "stadium")
public class StadiumData implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    @SerializedName("idTeam")
    @NonNull private String idTeam;

    @ColumnInfo(name = "strTeam")
    @SerializedName("strTeam")
    private String strTeam;

    @ColumnInfo(name = "strStadium")
    @SerializedName("strStadium")
    private String strStadium;

    @ColumnInfo(name = "strTeamBadge")
    @SerializedName("strTeamBadge")
    private String strTeamBadge;

    @ColumnInfo(name = "strStadiumThumb")
    @SerializedName("strStadiumThumb")
    private String strStadiumThumb;

    @ColumnInfo(name = "strStadiumDescription")
    @SerializedName("strStadiumDescription")
    private String strStadiumDescription;

    public StadiumData(@NonNull String idTeam, String strTeam, String strStadium, String strTeamBadge, String strStadiumThumb, String strStadiumDescription) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strTeamBadge = strTeamBadge;
        this.strStadiumThumb = strStadiumThumb;
        this.strStadiumDescription = strStadiumDescription;
    }

    @NonNull
    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(@NonNull String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }
}
