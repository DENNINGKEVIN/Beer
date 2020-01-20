package com.mulama.beer_superior.util;

import com.mulama.beer_superior.models.Beer;

import java.util.ArrayList;

public interface OnBeerSelectedListener {
    public void onRestaurantSelected(Integer position, ArrayList<Beer> beers, String source);
}
