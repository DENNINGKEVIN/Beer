package com.mulama.beer_superior;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.google.firebase.database.Query;
import com.mulama.beer_superior.adapters.FireBaseBeerViewHolder;
import com.mulama.beer_superior.adapters.FirebaseBeerListAdapter;
import com.mulama.beer_superior.models.Beer;
import com.mulama.beer_superior.util.ItemTouchHelperAdapter;
import com.mulama.beer_superior.util.OnStartDragListener;
import com.mulama.beer_superior.util.SimpleItemTouchHelperCallback;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedBeersListActivity extends AppCompatActivity  {
    private DatabaseReference mBeerReference;
    private FirebaseRecyclerAdapter<Beer, FireBaseBeerViewHolder> mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;
    @BindView(R.id.favouriteBeerRecyclerView) RecyclerView mRecyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_beers);
        ButterKnife.bind(this);
//        setUpFirebaseAdapter();

    }
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
//        mItemTouchHelper.startDrag(viewHolder);
//    }
//
//    private void setUpFirebaseAdapter() {
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        Query query = FirebaseDatabase
//                .getInstance()
//                .getReference(Constants.FIREBASE_CHILD_BEERS)
//                .child(uid)
//                .orderByChild(Constants.FIREBASE_QUERY_INDEX);
//
//
//
//
//        FirebaseRecyclerOptions<Beer> options =
//                new FirebaseRecyclerOptions.Builder<Beer>()
//                        .setQuery(query, Beer.class)
//                        .build();
//
//        mFirebaseAdapter = new FirebaseBeerListAdapter(options, query, this, this);
//
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//        mRecyclerView.setHasFixedSize(false);
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback((ItemTouchHelperAdapter) mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mFirebaseAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mFirebaseAdapter!= null) {
//            mFirebaseAdapter.stopListening();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.stopListening();
//    }

}
