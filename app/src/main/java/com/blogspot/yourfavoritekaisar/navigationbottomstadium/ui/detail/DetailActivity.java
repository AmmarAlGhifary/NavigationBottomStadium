package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.detail;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.R;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailStadiumContract.View {

    @BindView(R.id.img_logo_detail)
    ImageView imgLogoDetail;
    @BindView(R.id.txt_name_team_detail)
    TextView txtNameTeamDetail;
    @BindView(R.id.txt_desc)
    TextView txtDesc;
    @BindView(R.id.card_view_detail)
    CardView cardViewDetail;
    @BindView(R.id.sv_detail)
    ScrollView svDetail;

    private Menu menu;
    private StadiumData stadiumData;

    private DetailStadiumPresenter detailStadiumPresenter = new DetailStadiumPresenter(this);
    private Boolean isFavorite = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("DetailStadium");

        Bundle bundle = getIntent().getExtras();
        detailStadiumPresenter.getDetailTeam(bundle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;

        getMenuInflater().inflate(R.menu.favorites, menu);
        setFavorite();
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_favorite:
                if (isFavorite) {
                    detailStadiumPresenter.removeFavorite(this, stadiumData);
                } else {
                    detailStadiumPresenter.addToFavorite(this, stadiumData);
                }
                isFavorite = detailStadiumPresenter.checkFavorite(this, stadiumData);
                setFavorite();
                break;
            case R.id.home:
                finish();
                overridePendingTransition((android.R.anim.slide_in_left), android.R.anim.slide_out_right);
                break;
        }
        return true;
    }

    private void setFavorite() {
        if (isFavorite) {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_black_24dp));
        } else {
            menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
    }


    @Override
    public void showDetailStadium(StadiumData stadiumData) {
        this.stadiumData = stadiumData;
        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_error_black_24dp);
        Glide.with(this).load(stadiumData.getStrStadiumThumb()).apply(options).into(imgLogoDetail);
        txtNameTeamDetail.setText(stadiumData.getStrStadium());
        txtDesc.setText(stadiumData.getStrStadiumDescription());

        isFavorite = detailStadiumPresenter.checkFavorite(this, stadiumData);

    }

    @Override
    public void showFailureMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();

    }

    @Override
    public void showSuccessMessage(String msg) {
        Snackbar.make(svDetail, msg, Snackbar.LENGTH_SHORT).show();
    }
}
