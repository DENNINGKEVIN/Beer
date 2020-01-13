package com.mulama.beer_superior;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mulama.beer_superior.models.*;
import com.mulama.beer_superior.models.Brewery;
import com.mulama.beer_superior.models.Contact;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class BeerDetailFragment extends Fragment implements View.OnClickListener{
   @BindView(R.id.beerImageView) ImageView mBeerImage;
    @BindView(R.id.beerNameTextView) TextView mBeername;
    @BindView(R.id.beerSlugTextView) TextView mBeerSlug;
    @BindView(R.id.bidTextView) TextView mBid;
    @BindView(R.id.beerStyleTextView) TextView mBeerStyle;
    @BindView(R.id.createdAtTextView) TextView mCreatedAt;
    @BindView(R.id.descriptionTextView) TextView mDescription;
    @BindView(R.id.saveBeerButton) Button mSaveBeer;

    private Beer mBeer;


    public BeerDetailFragment(){

    }

 public static BeerDetailFragment newInstance(Beer beer) {
  BeerDetailFragment beerDetailFragment = new BeerDetailFragment();
  Bundle args = new Bundle();
  args.putParcelable("beer", Parcels.wrap(beer));
  beerDetailFragment.setArguments(args);
  return beerDetailFragment;
 }

 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  mBeer = Parcels.unwrap(getArguments().getParcelable("beer"));
 }

 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.fragment_beer_detail, container, false);
  ButterKnife.bind(this, view);

  Picasso.get().load(mBeer.getBeerLabel()).into(mBeerImage);
  mBeername.setText(mBeer.getBeerName());
  mDescription.setText(mBeer.getBeerDescription());
  mBeerStyle.setText("Style  => " + mBeer.getBeerStyle());
  mBeerSlug.setText(mBeer.getBeerSlug());
  mCreatedAt.setText("Created => " + mBeer.getCreatedAt());
  mBid.setText(mBeer.getBid().toString());

  mSaveBeer.setOnClickListener(this);
  return view;
 }

 @Override
 public void onClick(View v) {
  if(v == mSaveBeer){
   FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
   String uid = user.getUid();

   DatabaseReference restaurantRef = FirebaseDatabase
           .getInstance()
           .getReference(Constants.FIREBASE_CHILD_BEERS)
           .child(uid);

   DatabaseReference pushRef = restaurantRef.push();
   String pushId = pushRef.getKey();
   mBeer.setPushId(pushId);
   pushRef.setValue(mBeer);
   Toast.makeText(getContext(),"Added to Favourites", Toast.LENGTH_SHORT).show();
  }
 }
}
