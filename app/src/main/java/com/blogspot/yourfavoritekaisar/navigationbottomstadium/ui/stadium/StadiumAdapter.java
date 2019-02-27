package com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.stadium;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.yourfavoritekaisar.navigationbottomstadium.R;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.model.StadiumData;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.ui.detail.DetailActivity;
import com.blogspot.yourfavoritekaisar.navigationbottomstadium.utils.Constant;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StadiumAdapter extends RecyclerView.Adapter<StadiumAdapter.ViewHolder> {

    private final Context context;
    private final List<StadiumData> stadiumDataList;


    public StadiumAdapter(Context context, List<StadiumData> stadiumDataList) {
        this.context = context;
        this.stadiumDataList = stadiumDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final StadiumData stadiumData = stadiumDataList.get(i);

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_error_black_24dp);
        Glide.with(context).load(stadiumData.getStrStadiumThumb()).apply(options).into(viewHolder.imgLogoTeam);
        viewHolder.txtNameTeam.setText(stadiumData.getStrStadium());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, DetailActivity.class).putExtra(Constant.KEY_DATA, stadiumData));
            }
        });
    }

    @Override
    public int getItemCount() {
        return stadiumDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_logo_team)
        ImageView imgLogoTeam;
        @BindView(R.id.txt_name_team)
        TextView txtNameTeam;
        @BindView(R.id.card_view)
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
