package com.example.shoppingmanagementapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final ArrayList<Product> productList;

    public ProductAdapter(ArrayList<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productNameTextView.setText(product.getName());
        holder.productQuantityTextView.setText("Quantity: " + product.getQuantity());
        holder.productCheckBox.setChecked(product.isSelected());

        holder.productCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> product.setSelected(isChecked));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productNameTextView, productQuantityTextView;
        CheckBox productCheckBox;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.product_name_text);
            productQuantityTextView = itemView.findViewById(R.id.product_quantity_text);
            productCheckBox = itemView.findViewById(R.id.product_checkbox);
        }
    }
}
