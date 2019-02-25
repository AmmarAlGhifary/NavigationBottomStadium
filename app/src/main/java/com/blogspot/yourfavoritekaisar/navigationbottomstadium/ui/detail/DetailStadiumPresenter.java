package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.detail;

import android.content.Context;
import android.os.Bundle;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.local.StadiumDatabase;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.utils.Constant;

public class DetailStadiumPresenter implements DetailStadiumContract.presenter {

    private final DetailStadiumContract.View view;
    private StadiumDatabase stadiumDatabase;

    public DetailStadiumPresenter(DetailStadiumContract.View view) {
        this.view = view;
    }


    @Override
    public void getDetailTeam(Bundle bundle) {
        if (bundle != null){
            StadiumData stadiumData = (StadiumData) bundle.getSerializable(Constant.KEY_DATA);
            view.showDetailStadium(stadiumData);
        }else {
            view.showFailureMessage("Data Tidak dapat dipanggil dari server");
        }
    }

    @Override
    public void addToFavorite(Context context, StadiumData mStadiumData) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDAO().insertItem(mStadiumData);
        view.showSuccessMessage("Tersimpan");
    }

    @Override
    public void removeFavorite(Context context, StadiumData mStadiumData) {
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        stadiumDatabase.stadiumDAO().delete(mStadiumData);
        view.showFailureMessage("Terhapus");
    }

    @Override
    public Boolean checkFavorite(Context context, StadiumData mStadiumData) {
        Boolean aBoolean = false;
        stadiumDatabase = StadiumDatabase.getStadiumDatabase(context);
        return aBoolean = stadiumDatabase.stadiumDAO().selectedItem(mStadiumData.getIdTeam()) !=null;
    }
}
