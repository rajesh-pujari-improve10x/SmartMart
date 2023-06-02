package com.improve10x.smartmart.categories;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.smartmart.BaseActivity;
import com.improve10x.smartmart.products.ProductsActivity;
import com.improve10x.smartmart.databinding.ActivityCategoriesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends BaseActivity {

    ActivityCategoriesBinding binding;
    CategoriesAdapter categoriesAdapter;
    ArrayList<String> categories = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Categories");
        fetchCategories();
        setupCategoriesAdapter();
        setupCategoriesRv();
    }

    private void fetchCategories() {
        Call<List<String>> call = fakeAPiServices.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> categories = response.body();
                categoriesAdapter.setData(categories);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(CategoriesActivity.this, "Failed to Add Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupCategoriesRv() {
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
        binding.categoriesRv.setAdapter(categoriesAdapter);
    }

    private void setupCategoriesAdapter() {
        categoriesAdapter = new CategoriesAdapter();
        categoriesAdapter.setData(categories);
        categoriesAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(String categoryName) {
                Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                intent.putExtra("category", categoryName);
                startActivity(intent);
            }
        });
    }
}