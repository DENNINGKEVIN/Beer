package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.Beer;
import com.mulama.beer_superior.viewholders.BeerViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {
    Context mContext;
    ArrayList<Beer> beerArrayList;

    public BeerAdapter(Context mContext, ArrayList<Beer> beerModelArrayList) {
        this.mContext = mContext;
        this.beerArrayList = beerModelArrayList;
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
        Beer beer=beerArrayList.get(position);
        Picasso.get()
                .load(beer.getBeerLabel())
                .into(holder.pombeImage);
        holder.pombeText.setText(beer.getBeerName());

    }

    @Override
    public int getItemCount() {
        return beerArrayList.size();
    }
}
