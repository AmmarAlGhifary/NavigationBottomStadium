package com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

import java.util.List;

@Dao
public interface StadiumDAO {

    @Insert
    void insertItem(StadiumData stadiumData);

    @Query("SELECT * FROM stadium WHERE idTeam = :id")
    StadiumData selectedItem(String id);

    @Delete
    void delete(StadiumData stadiumData);

    @Query("SELECT * FROM stadium ORDER BY strStadium ASC")
    List<StadiumData> selectFavorite();
}
