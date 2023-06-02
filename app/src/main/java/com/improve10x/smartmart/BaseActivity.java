package com.improve10x.smartmart;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.improve10x.smartmart.network.FakeAPiServices;
import com.improve10x.smartmart.network.FakeApi;

public class BaseActivity extends AppCompatActivity {

    protected FakeAPiServices fakeAPiServices;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupApiService();
    }

    private void setupApiService() {
        FakeApi fakeApi = new FakeApi();
        fakeAPiServices = fakeApi.createFakeApiServices();
    }
}
