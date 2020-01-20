package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.mulama.beer_superior.BeerDetailActivity;
import com.mulama.beer_superior.BeerDetailFragment;
import com.mulama.beer_superior.Constants;
import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.Beer;
import com.squareup.picasso.Picasso;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerListAdapter extends RecyclerView.Adapter<BeerListAdapter.BeerViewHolder> {
    private List<Beer> mBeers;
    private Context mContext;

    public BeerListAdapter(Context context, List<Beer> beers) {
        mContext = context;
        mBeers = beers;
    }

    @Override
    public BeerListAdapter.BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pombe_item, parent, false);
        BeerViewHolder viewHolder = new BeerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeerListAdapter.BeerViewHolder holder, int position) {
        holder.bindRestaurant(mBeers.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }

    public class BeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.beerImageView) ImageView mBeerImageView;
        @BindView(R.id.beerNameTextView) TextView mNameTextView;
        @BindView(R.id.beerSlugTextView) TextView mBeerSlugTextView;
        @BindView(R.id.bidTextView) TextView mBidTextView;
        private Context mContext;
        private int mOrientation;


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
                intent.putExtra(Constants.EXTRA_KEY_BEERS, Parcels.wrap(mBeers));
                intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                mContext.startActivity(intent);

        }

        public void bindRestaurant(Beer beer) {
            mNameTextView.setText(beer.getBeerName());
            mBeerSlugTextView.setText(beer.getBrewery().getBreweryName());
            mBidTextView.setText("Rating: " + beer.getRatingScore() + "/5");
            Picasso.get().load(beer.getBeerLabelHd()).into(mBeerImageView);
        }
    }
}