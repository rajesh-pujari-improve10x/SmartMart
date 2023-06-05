package com.improve10x.smartmart.cart;

import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.CartItemBinding;

public class CartViewHolder extends RecyclerView.ViewHolder {

    CartItemBinding binding;

    public CartViewHolder(CartItemBinding cartItemBinding) {
        super(cartItemBinding.getRoot());
        binding = cartItemBinding;
    }
}
