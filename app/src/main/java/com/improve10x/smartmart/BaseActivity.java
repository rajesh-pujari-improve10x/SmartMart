package com.improve10x.smartmart;

import android.os.Bundle;
import android.widget.Toast;

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

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
