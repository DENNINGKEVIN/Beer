package com.mulama.beer_superior;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.mulama.beer_superior.adapters.BeerAdapter;
import com.mulama.beer_superior.models.Beer;
import com.mulama.beer_superior.models.UntappedBeerSearchResponse;
import com.mulama.beer_superior.network.UntappedApi;
import com.mulama.beer_superior.network.UntappedClient;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class BeerListFragment extends Fragment {

    @BindView(R.id.beerRecyclerView) RecyclerView beerRecyclerView;
    @BindView(R.id.spin_kit) ProgressBar progressBar;


    ArrayList<Beer> beerArrayList=new ArrayList<>();
    BeerAdapter beerAdapter;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mEnteredbeer;
    public int orientation;

    public BeerListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
        mEditor=mSharedPreferences.edit();

        orientation=getResources().getConfiguration().orientation;

        Sprite doubleBounce = new DoubleBounce();
//        progressBar.setIndeterminateDrawable(doubleBounce);


        // Instructs fragment to include menu options:
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_beer_list,container,false);
        ButterKnife.bind(this,view);
        mEnteredbeer=mSharedPreferences.getString(Constants.PREFERENCES_BEER_ENTER_KEY,null);
        if(mEnteredbeer != null){
            getBeer(mEnteredbeer);
        }
        return view;
    }

    public void getBeer(String beertext){
        progressBar.setVisibility(View.VISIBLE);
        UntappedApi client = UntappedClient.getClient();
        Call<UntappedBeerSearchResponse> call = client.getBeerInfo(beertext);
        call.enqueue(new Callback<UntappedBeerSearchResponse>() {
            @Override
            public void onResponse(Call<UntappedBeerSearchResponse> call, Response<UntappedBeerSearchResponse> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getResponse().getBeers().getItems().size(); i++) {
                        beerArrayList.add(response.body().getResponse().getBeers().getItems().get(i).getBeer());
                        BeerAdapter beerAdapter = new BeerAdapter(getActivity(), beerArrayList);
                        if(orientation == Configuration.ORIENTATION_PORTRAIT){
                        beerRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));}
                        else{
                            beerRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 5));
                        }
                        beerRecyclerView.setAdapter(beerAdapter);
                        progressBar.setVisibility(View.GONE);

                    }
                }
                Log.i(TAG, "onResponse: " + Integer.toString(response.code()));
            }

            @Override
            public void onFailure(Call<UntappedBeerSearchResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void addToSharedPreferences(String beertext) {
        mEditor.putString(Constants.PREFERENCES_BEER_ENTER_KEY, beertext).apply();
    }
    @Override
    // Method is now void, menu inflater is now passed in as argument:
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Call super to inherit method from parent:
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent=new Intent(getActivity(),BeerActivity.class);
                intent.putExtra("beertext",query);
                startActivity(intent);
                addToSharedPreferences(query);
                getBeer(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}



