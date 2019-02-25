package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.detail;

import android.content.Context;
import android.os.Bundle;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

public interface DetailStadiumContract {

    interface View{
        void showDetailStadium(StadiumData stadiumData);
        void showFailureMessage(String msg);
        void showSuccessMessage(String msg);
    }

    interface presenter{
        void getDetailTeam(Bundle bundle );
        void addToFavorite(Context context, StadiumData mStadiumData);
        void removeFavorite(Context context, StadiumData mStadiumData );
        Boolean checkFavorite(Context context, StadiumData mStadiumData);

    }
}
