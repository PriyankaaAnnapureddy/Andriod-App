package com.example.coffeapplication.mvvm.views;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.adapters.MenuAdapter;
import com.example.coffeapplication.mvvm.models.MenuItem;
import com.example.coffeapplication.mvvm.viewModels.MenuBakeViewModel;
import java.util.ArrayList;

public class MenuBakeFragment extends Fragment implements MenuAdapter.OnAddToCartListener {
    MenuAdapter adapter;
    MenuBakeViewModel menuViewModel;
    RecyclerView rcv;
    ArrayList<MenuItem> cartItems = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_bake, container, false);
        menuViewModel = new ViewModelProvider(this).get(MenuBakeViewModel.class);
        rcv = view.findViewById(R.id.bakeRecycler);

        final Observer<ArrayList<MenuItem>> nameObserver = new Observer<ArrayList<MenuItem>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<MenuItem> menu) {
                adapter = new MenuAdapter(menu, requireContext(), MenuBakeFragment.this);
                rcv.setAdapter(adapter);
            }
        };

        menuViewModel.getCurrentMenu().observe(getViewLifecycleOwner(), nameObserver);
        rcv.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return view;
    }

    @Override
    public void onAddToCart(MenuItem menuItem) {
        cartItems.add(menuItem);
        Toast.makeText(getContext(), menuItem.getName() + " added to cart", Toast.LENGTH_SHORT).show();
    }
}
