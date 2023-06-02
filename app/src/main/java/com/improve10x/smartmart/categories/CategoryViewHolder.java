package com.improve10x.smartmart.categories;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CategoryItemBinding binding;

    public CategoryViewHolder(CategoryItemBinding categoryItemBinding) {
        super(categoryItemBinding.getRoot());
        binding = categoryItemBinding;
    }
}
