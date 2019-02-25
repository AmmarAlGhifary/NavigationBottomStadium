package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.favorite;

import android.content.Context;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

import java.util.List;

public interface FavoriteContract {

    interface View{
        void showDataList(List<StadiumData> stadiumDataList);
        void showFailureMEssage(String msg);
        void hideRefresh();
    }

    interface presenter{
        void getDataListStadium(Context context);
    }
}
