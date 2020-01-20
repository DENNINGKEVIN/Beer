package com.mulama.beer_superior.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mulama.beer_superior.BeerDetailFragment;
import com.mulama.beer_superior.models.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerPagerAdapter extends FragmentPagerAdapter {
    private List<Beer> mBeers;

    public BeerPagerAdapter(FragmentManager fm, List<Beer> beers) {
        super(fm);
        mBeers = beers;
    }

    @Override
    public Fragment getItem(int position) {
        return BeerDetailFragment.newInstance( mBeers,position);
    }

    @Override
    public int getCount() {
        return mBeers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBeers.get(position).getBeerName();
    }
}
