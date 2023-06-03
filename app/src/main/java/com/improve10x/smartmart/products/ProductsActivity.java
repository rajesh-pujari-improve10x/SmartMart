package com.improve10x.smartmart.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.improve10x.smartmart.BaseActivity;
import com.improve10x.smartmart.Constants;
import com.improve10x.smartmart.ProductDetailsActivity;
import com.improve10x.smartmart.R;
import com.improve10x.smartmart.databinding.ActivityProductsBinding;
import com.improve10x.smartmart.models.Product;
import com.improve10x.smartmart.network.FakeAPiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsActivity extends BaseActivity {

    private ActivityProductsBinding binding;

    private ProductsAdapter productsAdapter;

    private ArrayList<Product> products = new ArrayList<>();

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Products");
        if (getIntent().hasExtra(Constants.KEY_CATEGORY)) {
            category = getIntent().getStringExtra(Constants.KEY_CATEGORY);
        }
        setupProductAdapter();
        setupProductsRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchProductCategory();
    }

    private void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    private void fetchProductCategory() {
        showProgressBar();
        Call<List<Product>> call = fakeAPiServices.fetchProducts(category);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                hideProgressBar();
                List<Product> products = response.body();
                productsAdapter.setData(products);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductsActivity.this, "Failed to Load Product Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupProductsRv() {
        binding.productsRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productsRv.setAdapter(productsAdapter);
    }

    private void setupProductAdapter() {
        productsAdapter = new ProductsAdapter();
        productsAdapter.setData(products);
        productsAdapter.setOnItemActionListener(productId -> {
            Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
            intent.putExtra(Constants.KEY_PRODUCT, productId);
            startActivity(intent);
        });
    }
}