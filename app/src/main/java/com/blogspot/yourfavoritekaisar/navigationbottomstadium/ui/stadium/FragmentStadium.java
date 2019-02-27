package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium;


import android.app.ProgressDialog;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.R;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStadium extends Fragment implements StadiumContract.view {


    @BindView(R.id.rv_teams)
    RecyclerView rvTeams;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.btnSearch)
    ImageButton btnSearch;
    private ProgressDialog progressDialog;
    private StadiumPresenter presenter = new StadiumPresenter(this);


    public FragmentStadium() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stadium, container, false);
        unbinder = ButterKnife.bind(this, view);
        rvTeams = view.findViewById(R.id.rv_teams);
        presenter.getDataListItem();
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getDataListItem();
            }
        });

        setUpUIListener();
        return view;
    }

    private void setUpUIListener() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = edtSearch.getText().toString().toLowerCase();
                presenter.getSearchStadium(searchText);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvTeams = view.findViewById(R.id.rv_teams);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();


    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataList(List<StadiumData> stadiumDataList) {
        rvTeams.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTeams.setAdapter(new StadiumAdapter(getContext(), stadiumDataList));
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
