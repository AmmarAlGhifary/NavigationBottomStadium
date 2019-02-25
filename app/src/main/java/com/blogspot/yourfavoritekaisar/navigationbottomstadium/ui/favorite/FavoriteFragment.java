package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.favorite;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.R;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium.StadiumAdapter;

import java.util.List;

import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements FavoriteContract.View{

    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;
    Unbinder unbinder;

    private FavoritePresenter favoritePresenter = new FavoritePresenter(this);

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.rv_favorite);
        swipeRefreshLayout = getView().findViewById(R.id.swipe_refresh);
        favoritePresenter.getDataListStadium(getContext());
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                favoritePresenter.getDataListStadium(getContext());
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showDataList(List<StadiumData> stadiumDataList) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new StadiumAdapter(getContext(), stadiumDataList));
    }

    @Override
    public void showFailureMEssage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideRefresh() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // unbinder.unbind();
    }

}
