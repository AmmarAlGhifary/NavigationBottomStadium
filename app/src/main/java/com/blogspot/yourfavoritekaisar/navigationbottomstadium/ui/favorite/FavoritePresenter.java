package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.favorite;

import android.content.Context;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.local.StadiumDatabase;

public class FavoritePresenter implements FavoriteContract.presenter {

    private final FavoriteContract.View view;
    private StadiumDatabase stadiumDatabase;

    public FavoritePresenter(FavoriteContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListStadium(Context context) {
        stadiumDatabase = stadiumDatabase.getStadiumDatabase(context);
        if (stadiumDatabase.stadiumDAO().selectFavorite() != null){
            view.showDataList(stadiumDatabase.stadiumDAO().selectFavorite());
        }else {
            view.showFailureMEssage("data di favorite tidak ada");
        }
        view.hideRefresh();
    }
}

