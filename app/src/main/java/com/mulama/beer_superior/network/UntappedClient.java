package com.mulama.beer_superior.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.mulama.beer_superior.Constants.UNTAPPED_BASE_URL;

public class UntappedClient {
    private static Retrofit retrofit = null;

    public static UntappedApi getClient() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(UNTAPPED_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(UntappedApi.class);
    }
}
