package com.blogspot.yourfavoritekaisar.navigationbottomstadium.data.remote;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    Call<StadiumResponse> getAllTeams(
            @Query("s") String s, @Query("c") String c
    );

}
