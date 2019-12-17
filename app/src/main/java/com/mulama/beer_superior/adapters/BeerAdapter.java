package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.BeerModel;
import com.mulama.beer_superior.viewholders.BeerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {
    Context mContext;
    ArrayList<BeerModel> beerModelArrayList;

    public BeerAdapter(Context mContext, ArrayList<BeerModel> beerModelArrayList) {
        this.mContext = mContext;
        this.beerModelArrayList = beerModelArrayList;
    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view= LayoutInflater.from(mContext).inflate(R.layout.pombe_item,parent,false);
        return new BeerViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder holder, int position) {
        BeerModel beerModel=beerModelArrayList.get(position);
        Picasso.get()
                .load(beerModel.getPombeImage())
                .into(holder.pombeImage);
        holder.pombeText.setText(beerModel.getPombeText());

    }

    @Override
    public int getItemCount() {
        return beerModelArrayList.size();
    }
}
