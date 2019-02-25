package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

import java.util.List;

public interface StadiumContract {


    interface view{
        void showProgress();
        void hideProgress();
        void showDataList(List<StadiumData> stadiumDataList);
        void showFailureMessage(String msg);

    }

    interface presenter {
        void getDataListItem();
    }
}
