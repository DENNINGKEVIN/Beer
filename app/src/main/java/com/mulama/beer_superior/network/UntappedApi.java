package com.mulama.beer_superior.network;

import com.mulama.beer_superior.models.UntappedBeerInfoSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UntappedApi {

    @GET("beer/info/{id}")
    Call<UntappedBeerInfoSearchResponse> getBeerInfo(
            @Path("bid") Integer bid
    );
}
