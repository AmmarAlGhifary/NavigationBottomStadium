package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.remote.ApiClient;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.remote.ApiInterface;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumResponse;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StadiumPresenter implements StadiumContract.presenter {

    private final StadiumContract.view view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public StadiumPresenter(StadiumContract.view view) {
        this.view = view;
    }

    @Override
    public void getDataListItem() {
        view.showProgress();

        Call<StadiumResponse> call = apiInterface.getAllTeams(Constant.S, Constant.C);
        call.enqueue(new Callback<StadiumResponse>() {
            @Override
            public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                view.hideProgress();

                if (response.body() != null){
                    view.showDataList(response.body().getTeams());
                }else {
                    view.showFailureMessage("Tidak Dapat memanggil Data");
                }

            }

            @Override
            public void onFailure(Call<StadiumResponse> call, Throwable t) {
                view.showFailureMessage(t.getMessage());

            }
        });
    }

    @Override
    public void getSearchStadium(final String searchText) {
        if (!searchText.isEmpty()){
            view.showProgress();

            Call<StadiumResponse> call = apiInterface.getAllTeams(Constant.S,Constant.C);
            call.enqueue(new Callback<StadiumResponse>() {
                @Override
                public void onResponse(Call<StadiumResponse> call, Response<StadiumResponse> response) {
                    view.hideProgress();
                    if (response.body() !=null) {
                        List<StadiumData> stadiumDataList = response.body().getTeams();
                        List<StadiumData> mStadiumItemList = new ArrayList<>();

                        for (StadiumData data: stadiumDataList){
                            String namaStd = data.getStrStadium().toLowerCase();
                            if (namaStd.contains(searchText.toLowerCase())){
                                mStadiumItemList.add(data);
                            }
                        }
                        view.showDataList(mStadiumItemList);
                    }
                }

                @Override
                public void onFailure(Call<StadiumResponse> call, Throwable t) {
                    view.hideProgress();
                    view.showFailureMessage(t.getMessage());
                }
            });
        }else {
            view.hideProgress();
            getDataListItem();
        }
    }
}
