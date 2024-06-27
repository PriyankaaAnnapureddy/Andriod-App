package com.example.coffeapplication.mvvm.views;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.adapters.MenuAdapter;
import com.example.coffeapplication.mvvm.models.MenuItem;
import com.example.coffeapplication.mvvm.viewModels.MenuFavoriteViewModel;
import java.util.ArrayList;

public class MenuFavoriteFragment extends Fragment {
    private MenuAdapter adapter;
    private MenuFavoriteViewModel menuViewModel;
    private RecyclerView rcv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_favorite, container, false);

        // Initialize RecyclerView and LayoutManager
        rcv = view.findViewById(R.id.favoriteRecycler);
        rcv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Initialize ViewModel
        menuViewModel = new ViewModelProvider(this).get(MenuFavoriteViewModel.class);

        // Initialize adapter with empty list initially
        adapter = new MenuAdapter(new ArrayList<>(), requireContext(), new MenuAdapter.OnAddToCartListener() {
            @Override
            public void onAddToCart(MenuItem menuItem) {
                // Handle add to cart logic here
                menuViewModel.addToCart(menuItem);
            }
        });
        rcv.setAdapter(adapter);

        // Observe the data from ViewModel and update UI
        menuViewModel.getFavoriteItems().observe(getViewLifecycleOwner(), new Observer<ArrayList<MenuItem>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<MenuItem> menuItems) {
                if (menuItems != null) {
                    adapter.setMenuItems(menuItems);
                }
            }
        });

        return view;
    }
}
