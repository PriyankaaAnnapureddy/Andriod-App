package com.example.coffeapplication.mvvm.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeapplication.mvvm.models.MenuItem;
import com.example.coffeapplication.mvvm.repositories.MenuFavoriteRepository;

import java.util.ArrayList;

public class MenuFavoriteViewModel extends ViewModel {
    private final MenuFavoriteRepository menuFavoriteRepository;
    private final MutableLiveData<ArrayList<MenuItem>> favoriteItems;
    private final MutableLiveData<ArrayList<MenuItem>> cartItems;

    public MenuFavoriteViewModel() {
        menuFavoriteRepository = new MenuFavoriteRepository();
        favoriteItems = new MutableLiveData<>();
        cartItems = new MutableLiveData<>(new ArrayList<>());
        fetchFavoriteItems();
    }

    public LiveData<ArrayList<MenuItem>> getFavoriteItems() {
        return favoriteItems;
    }

    public LiveData<ArrayList<MenuItem>> getCartItems() {
        return cartItems;
    }

    private void fetchFavoriteItems() {
        ArrayList<MenuItem> items = menuFavoriteRepository.getFavoriteFromDB();
        favoriteItems.postValue(items);
    }

    public void addToCart(MenuItem menuItem) {
        ArrayList<MenuItem> currentCart = cartItems.getValue();
        if (currentCart != null) {
            currentCart.add(menuItem);
            cartItems.postValue(currentCart);
        }
    }
}
