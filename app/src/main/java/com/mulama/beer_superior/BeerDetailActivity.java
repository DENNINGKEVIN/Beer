package com.mulama.beer_superior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcel;
import android.widget.Button;

import com.mulama.beer_superior.adapters.BeerAdapter;
import com.mulama.beer_superior.adapters.BeerPagerAdapter;
import com.mulama.beer_superior.models.Beer;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeerDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager) ViewPager mViewPager;
    private BeerPagerAdapter beerPagerAdapter;
    List<Beer> mBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_detail);
        ButterKnife.bind(this);

        mBeer = Parcels.unwrap(getIntent().getParcelableExtra("beers"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        beerPagerAdapter = new BeerPagerAdapter(getSupportFragmentManager(), mBeer);
        mViewPager.setAdapter(beerPagerAdapter);
        mViewPager.setCurrentItem(startingPosition);
    }
}
