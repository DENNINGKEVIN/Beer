package com.mulama.beer_superior.network;

import com.mulama.beer_superior.models.UntappedBeerInfoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UntappedClient {

    @GET("beer_info/search")
    Call<UntappedBeerInfoSearchResponse> getRestaurants(
            @Query("location") String location,
            @Query("term") String term
    );
}
