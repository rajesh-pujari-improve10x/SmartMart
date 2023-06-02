package com.improve10x.smartmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        getSupportActionBar().setTitle("Products");
    }
}