package com.improve10x.smartmart.cart;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.improve10x.smartmart.BaseActivity;
import com.improve10x.smartmart.databinding.ActivityCartProductsBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartProductsActivity extends BaseActivity {

    private ActivityCartProductsBinding binding;

    private CartProductsAdapter cartProductsAdapter;

    private ArrayList<CartProduct> cartProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartProductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Cart Details");
        fetchCartProducts();
        setupCartProductsAdapter();
        setupCartProductsRv();
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.messages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent intent = new Intent(this, AddMessageActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    */


    private void fetchCartProducts() {
        showProgressBar();
        Call<Cart> call = fakeAPiServices.fetchCartProducts();
        call.enqueue(new Callback<Cart>() {
            @Override
            public void onResponse(Call<Cart> call, Response<Cart> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    Cart cart = response.body();
                    cartProductsAdapter.setData(cart.getProducts());
                }
            }

            @Override
            public void onFailure(Call<Cart> call, Throwable t) {
                hideProgressBar();
                showToast("Failed to Load Data");
            }
        });
    }

    private void setupCartProductsRv() {
        binding.cartProductsRv.setLayoutManager(new LinearLayoutManager(this));
        binding.cartProductsRv.setAdapter(cartProductsAdapter);
    }

    private void setupCartProductsAdapter() {
        cartProductsAdapter = new CartProductsAdapter();
        cartProductsAdapter.setData(cartProducts);
    }

    private void showProgressBar() {
        binding.cartProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        binding.cartProgressBar.setVisibility(View.GONE);
    }
}