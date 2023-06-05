package com.improve10x.smartmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.improve10x.smartmart.cart.CartProductsActivity;
import com.improve10x.smartmart.databinding.ActivityProductDetailsBinding;
import com.improve10x.smartmart.models.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity {

    private ActivityProductDetailsBinding binding;

    private int productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Product Details");
        if (getIntent().hasExtra(Constants.KEY_PRODUCT)) {
            productId = getIntent().getIntExtra(Constants.KEY_PRODUCT, productId);
        }
        fetchProductDetails();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.cart) {
            Intent intent = new Intent(ProductDetailsActivity.this, CartProductsActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void fetchProductDetails() {
        showProgressBar();
        Call<Product> call = fakeAPiServices.fetchProductDetails(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                hideProgressBar();
                Product product = response.body();
                binding.setProduct(product);
                binding.productDetailsRating.setRating(product.rating.getRate());            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to Load the Data");
            }
        });
    }

    private void hideProgressBar() {
        binding.detailsProgressBar.setVisibility(View.GONE);
    }

    private void showProgressBar() {
        binding.detailsProgressBar.setVisibility(View.VISIBLE);
    }
}