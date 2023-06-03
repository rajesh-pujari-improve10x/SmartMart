package com.improve10x.smartmart.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.smartmart.databinding.ProductsItemBinding;
import com.improve10x.smartmart.models.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder>{

    private List<Product> products;

    private OnItemActionListener onItemActionListener;

    void setData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductsItemBinding productsItemBinding = ProductsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ProductViewHolder productViewHolder = new ProductViewHolder(productsItemBinding);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.binding.setProduct(product);
        holder.binding.productRating.setRating(product.rating.getRate());
        holder.binding.getRoot().setOnClickListener(v -> {
            onItemActionListener.onClick(product.getId());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
