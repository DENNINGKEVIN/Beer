package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mulama.beer_superior.BeerDetailActivity;
import com.mulama.beer_superior.Constants;
import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.Beer;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

public class FireBaseBeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;
    public ImageView mBeerImageView;


    public FireBaseBeerViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindBeer(Beer beer) {
        mBeerImageView = (ImageView) mView.findViewById(R.id.pombeImage);
        ImageView pombeimage=(ImageView) mView.findViewById(R.id.pombeImage);
        TextView pombetext=(TextView) mView.findViewById(R.id.pombeText);

        Picasso.get().load(beer.getBeerLabel()).into(pombeimage);
        Picasso.get().load(beer.getBeerLabel()).into(mBeerImageView);

        pombetext.setText(beer.getBeerName());

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Beer> beerArrayList = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEERS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    beerArrayList.add(snapshot.getValue(Beer.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, BeerDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("beers", Parcels.wrap(beerArrayList));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
