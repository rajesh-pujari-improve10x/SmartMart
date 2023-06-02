package com.improve10x.smartmart.categories;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.CategoryItemBinding;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<String> categories;
    private OnItemActionListener onItemActionListener;

    void setData(List<String> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(binding);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.binding.categoryName.setText(category);
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClick(category);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
