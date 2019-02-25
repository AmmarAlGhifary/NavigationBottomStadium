package com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

@Database(entities = StadiumData.class, version = 1, exportSchema = false)
public abstract class StadiumDatabase extends RoomDatabase {


    public abstract StadiumDAO stadiumDAO();

    private static StadiumDatabase mStadiumDatabase;

    public static StadiumDatabase getStadiumDatabase(Context context){
        synchronized (StadiumDatabase.class){
            if (mStadiumDatabase == null){
                // Membuat Table
                mStadiumDatabase = Room.databaseBuilder(context,
                        StadiumDatabase.class, "db_football").allowMainThreadQueries().build();
            }
        }return mStadiumDatabase;
    }
}
