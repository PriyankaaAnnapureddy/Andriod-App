package com.example.coffeapplication.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.models.MenuItem;
import com.example.coffeapplication.mvvm.viewModels.CartViewModel;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;
    private Context context;
    private OnAddToCartListener addToCartListener;
    private CartViewModel cartViewModel;  // Injected ViewModel for managing cart


    public MenuAdapter(List<MenuItem> menuItems, Context context, OnAddToCartListener addToCartListener) {
        this.menuItems = menuItems;
        this.context = context;
        this.addToCartListener = addToCartListener;
        this.cartViewModel = cartViewModel;  // Assign the injected ViewModel

    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem menuItem = menuItems.get(position);
        holder.name.setText(menuItem.getName());
        holder.cost.setText(String.format("$%.2f", menuItem.getPrice()));
        holder.image.setImageResource(menuItem.getImageResource());
        holder.addToCartButton.setOnClickListener(v -> addToCartListener.onAddToCart(menuItem));
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        notifyDataSetChanged();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView name, cost;
        ImageView image;
        Button addToCartButton;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.menu_item_name);
            cost = itemView.findViewById(R.id.menu_item_price);
            image = itemView.findViewById(R.id.menu_item_image);
            addToCartButton = itemView.findViewById(R.id.add_to_cart_button);
        }
    }

    public interface OnAddToCartListener {
        void onAddToCart(MenuItem menuItem);
    }
}
