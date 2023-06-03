package com.improve10x.smartmart.products;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.ProductsItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ProductsItemBinding binding;

    public ProductViewHolder(ProductsItemBinding productsItemBinding) {
        super(productsItemBinding.getRoot());
        binding = productsItemBinding;
    }
}
