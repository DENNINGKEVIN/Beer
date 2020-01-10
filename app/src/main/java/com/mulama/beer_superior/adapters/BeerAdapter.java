package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.beer_superior.BeerDetailActivity;
import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.Beer;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder> {
    Context mContext;
    ArrayList<Beer> mBeers;

    public BeerAdapter(Context mContext, ArrayList<Beer> beerModelArrayList) {
        this.mContext = mContext;
        this.mBeers = beerModelArrayList;
    }

    @NonNull
    @Override
    public BeerAdapter.BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view= LayoutInflater.from(mContext).inflate(R.layout.pombe_item,parent,false);
        return new BeerViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull BeerAdapter.BeerViewHolder holder, int position) {
        Beer beer=mBeers.get(position);
        holder.bindBeer(beer);

    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }

    class BeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.pombeImage)
        ImageView pombeImage;
        @BindView(R.id.pombeText)
        TextView pombeText;

        private Context mContext;

        public BeerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, BeerDetailActivity.class);
            intent.putExtra("position", itemPosition);

            intent.putExtra("beers", Parcels.wrap(mBeers));
            mContext.startActivity(intent);
        }

        public void bindBeer(Beer beer) {
            pombeText.setText(beer.getBeerName());
            Picasso.get().load(beer.getBeerLabel()).into(pombeImage);
        }
    }

}
