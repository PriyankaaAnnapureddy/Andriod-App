package com.example.coffeapplication.mvvm.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeapplication.mvvm.models.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel extends ViewModel {

    private MutableLiveData<List<Cart>> cartItems;

    public CartViewModel() {
        cartItems = new MutableLiveData<>(new ArrayList<>());
        loadCartItems();
    }

    public LiveData<List<Cart>> getCartItems() {
        return cartItems;
    }

    private void loadCartItems() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Cart> cartList = new ArrayList<>();
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Cart cart = ds.getValue(Cart.class);
                    if (cart != null) {
                        cartList.add(cart);
                    }
                }
                cartItems.setValue(cartList);  // Update LiveData with the retrieved cart items
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle potential errors here
            }
        });
    }

    public void addToCart(Cart cartItem) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.push().setValue(cartItem);
    }

    public void placeOrder() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Cart");
        databaseReference.removeValue();  // Clear cart after placing an order
    }
}
