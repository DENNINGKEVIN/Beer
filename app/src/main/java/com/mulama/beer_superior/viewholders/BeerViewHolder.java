package com.mulama.beer_superior.viewholders;

import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.beer_superior.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.pombeText)
    public TextView pombeText;

    @BindView(R.id.pombeImage)
    public ImageView pombeImage;
    public BeerViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
