package com.improve10x.smartmart.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.CartItemBinding;

import java.util.List;

public class CartProductsAdapter extends RecyclerView.Adapter<CartViewHolder> {

    List<CartProduct> cartProducts;

    void setData(List<CartProduct> carts) {
        this.cartProducts = carts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(binding);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartProduct cartProduct =  cartProducts.get(position);
        holder.binding.setCartproduct(cartProduct);
    }

    @Override
    public int getItemCount() {
        return cartProducts.size();
    }
}
