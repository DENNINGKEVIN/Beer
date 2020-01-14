package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.mulama.beer_superior.adapters.BeerAdapter;
import com.mulama.beer_superior.models.Beer;
import com.mulama.beer_superior.models.UntappedBeerSearchResponse;
import com.mulama.beer_superior.network.UntappedApi;
import com.mulama.beer_superior.network.UntappedClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "BeerActivity";
    @BindView(R.id.beerTextView) TextView mBeerTextView;
    @BindView(R.id.beerRecyclerView) RecyclerView beerRecyclerView;
    ArrayList<Beer> beerArrayList=new ArrayList<>();
    BeerAdapter beerAdapter;
    @BindView(R.id.favouritesButton) Button mFavouritesButton;




    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mEnteredbeer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        getBeer(name);

        mFavouritesButton.setOnClickListener(this);

//        adding shared preferences
        mSharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        mEnteredbeer=mSharedPreferences.getString(Constants.PREFERENCES_BEER_ENTER_KEY, null);
        if (mEnteredbeer != null){
            getBeer(mEnteredbeer);
        }
//        Log.d("pref beer",mEnteredbeer);

        mBeerTextView.setText("Here are the results for: " + name);
    }
    private void addToSharedPreferences(String beer) {
        mEditor.putString(Constants.PREFERENCES_BEER_ENTER_KEY, beer).apply();
    }

    //adding searchview
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                addToSharedPreferences(query);
                getBeer(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }




    public void getBeer(String beertext){
        UntappedApi client = UntappedClient.getClient();
        Call<UntappedBeerSearchResponse> call = client.getBeerInfo(beertext);
        call.enqueue(new Callback<UntappedBeerSearchResponse>() {
            @Override
            public void onResponse(Call<UntappedBeerSearchResponse> call, Response<UntappedBeerSearchResponse> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getResponse().getBeers().getItems().size(); i++) {
                        beerArrayList.add(response.body().getResponse().getBeers().getItems().get(i).getBeer());
                        BeerAdapter beerAdapter = new BeerAdapter(BeerActivity.this, beerArrayList);
                        beerRecyclerView.setLayoutManager(new GridLayoutManager(BeerActivity.this, 3));
                        beerRecyclerView.setAdapter(beerAdapter);

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

    @Override
    public void onClick(View v) {
        if (v == mFavouritesButton) {
            Intent intent = new Intent(BeerActivity.this, SavedBeersListActivity.class);
            startActivity(intent);
        }
    }
}



