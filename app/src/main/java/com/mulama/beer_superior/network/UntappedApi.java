package com.mulama.beer_superior.network;

import com.mulama.beer_superior.models.UntappedBeerSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UntappedApi {

    @GET("search/beer?client_id=400AAA59FFD6D82431AEC4E6BFB4B78AD257DC52&client_secret=7DC0FF2D47CA5074076CB5B5FA52A7E28D7AEEBA")
    Call<UntappedBeerSearchResponse> getBeerInfo(
            @Query("q") String query
    );
}
