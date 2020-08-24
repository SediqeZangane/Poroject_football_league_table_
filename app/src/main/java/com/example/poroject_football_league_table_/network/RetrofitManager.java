package com.example.poroject_football_league_table_.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static FootballApi footballApi;

    /**
     * Creates a object from retrofit.
     * Use Ok http as retrofit client so we can add a header to all requests. The header in this requests is
     * user auth for api.
     * Uses Gson converter for converting json to data models.
     * Base urls for this api is `http://api.football-data.org`.
     */
    private static Retrofit getRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @EverythingIsNonNull
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("X-Auth-Token", "d690965a0bb74332b58bd3c99680529b").build();
                return chain.proceed(request);
            }
        });
        return new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    /**
     * Creates on instance from FootballApi interface.
     */
    public static FootballApi getFootballApi() {
        if (footballApi == null) {
            footballApi = getRetrofit().create(FootballApi.class);
        }
        return footballApi;
    }
}
