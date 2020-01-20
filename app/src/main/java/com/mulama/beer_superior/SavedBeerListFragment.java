package com.mulama.beer_superior;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class SavedBeerListFragment extends Fragment implements OnStartDragListener {
    private FirebaseRecyclerAdapter<Beer, FireBaseBeerViewHolder> mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @BindView(R.id.favouriteBeerRecyclerView) RecyclerView mRecyclerView;





    public SavedBeerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_saved_beer_list,container,false);
        ButterKnife.bind(this,view);
        setUpFirebaseAdapter();
        return view;
    }
    private void setUpFirebaseAdapter() {


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_BEERS)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);




        FirebaseRecyclerOptions<Beer> options =
                new FirebaseRecyclerOptions.Builder<Beer>()
                        .setQuery(query, Beer.class)
                        .build();

        mFirebaseAdapter = new FirebaseBeerListAdapter(options, query, this, getActivity());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        mFirebaseAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                mFirebaseAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView.setHasFixedSize(false);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback((ItemTouchHelperAdapter) mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);


    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
        @Override
    public void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    @Override
    //method is now public
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.stopListening();
    }

}
