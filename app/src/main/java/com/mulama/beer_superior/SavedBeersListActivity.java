package com.mulama.beer_superior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mulama.beer_superior.adapters.FireBaseBeerViewHolder;
import com.mulama.beer_superior.models.Beer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedBeersListActivity extends AppCompatActivity {
    private DatabaseReference mBeerReference;
    private FirebaseRecyclerAdapter<Beer, FireBaseBeerViewHolder> mFirebaseAdapter;

    @BindView(R.id.beerRecyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mBeerReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_BEERS)
                .child(uid);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Beer> options =
                new FirebaseRecyclerOptions.Builder<Beer>()
                        .setQuery(mBeerReference, Beer.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Beer, FireBaseBeerViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FireBaseBeerViewHolder firebaseBeerViewHolder, int position, @NonNull Beer beer) {
                firebaseBeerViewHolder.bindBeer(beer);
            }

            @NonNull
            @Override
            public FireBaseBeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pombe_item, parent, false);
                return new FireBaseBeerViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}
