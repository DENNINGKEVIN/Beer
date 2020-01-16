package com.mulama.beer_superior.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.mulama.beer_superior.R;
import com.mulama.beer_superior.models.Beer;
import com.mulama.beer_superior.util.ItemTouchHelperAdapter;
import com.mulama.beer_superior.util.OnStartDragListener;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseBeerListAdapter extends FirebaseRecyclerAdapter<Beer, FireBaseBeerViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    private ChildEventListener mChildEventListener;
    private ArrayList<Beer> mBeer = new ArrayList<>();

    public FirebaseBeerListAdapter(FirebaseRecyclerOptions<Beer> options,
                                   Query query,
                                   OnStartDragListener onStartDragListener,
                                   Context context){
        super(options);
        mRef = query.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mBeer.add(dataSnapshot.getValue(Beer.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void setIndexInFirebase() {
        for (Beer beer : mBeer) {
            int index = mBeer.indexOf(beer);
            DatabaseReference ref = getRef(index);
            beer.setIndex(Integer.toString(index));
            ref.setValue(beer);
        }
    }

    @Override
    protected void onBindViewHolder(@NonNull final FireBaseBeerViewHolder fireBaseBeerViewHolder, int position, @NonNull Beer beer) {
        fireBaseBeerViewHolder.bindBeer(beer);
        fireBaseBeerViewHolder.mBeerImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(fireBaseBeerViewHolder);
                }
                return false;
            }
        });
    }



    @NonNull
    @Override
    public FireBaseBeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pombe_item_drag, parent, false);
        return new FireBaseBeerViewHolder(view);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mBeer, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mBeer.remove(position);
        getRef(position).removeValue();
    }

    @Override
    public void stopListening() {
        super.stopListening();
        mRef.removeEventListener(mChildEventListener);
    }

}
