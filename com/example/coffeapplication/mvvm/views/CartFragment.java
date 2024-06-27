package com.example.coffeapplication.mvvm.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.adapters.CartAdapter;
import com.example.coffeapplication.mvvm.models.Cart;
import com.example.coffeapplication.mvvm.viewModels.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {

    private CartAdapter adapter;
    private CartViewModel cartViewModel;
    private RecyclerView recyclerView;
    private Button exitButton, payButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart, container, false);

        cartViewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity()).get(CartViewModel.class);
        recyclerView = view.findViewById(R.id.cartRec);
        exitButton = view.findViewById(R.id.cartClose);
        payButton = view.findViewById(R.id.payBtn);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        cartViewModel.getCartItems().observe(getViewLifecycleOwner(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> cartItems) {
                adapter = new CartAdapter((ArrayList<Cart>) cartItems, requireContext());
                recyclerView.setAdapter(adapter);
            }
        });

        exitButton.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_news, new MenuFragment()).commit());

        payButton.setOnClickListener(v -> {
            cartViewModel.placeOrder();
            Toast.makeText(getActivity().getApplication(), "Order placed", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_news, new MenuFragment()).commit();
        });

        return view;
    }
}
