package com.improve10x.smartmart.network;

import com.improve10x.smartmart.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeApi {

    public FakeAPiServices createFakeApiServices() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FakeAPiServices fakeAPiServices = retrofit.create(FakeAPiServices.class);
        return fakeAPiServices;
    }
}
