package com.example.coffeapplication.mvvm.repositories;

import android.content.Context;
import android.view.View;

import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.models.MenuItem;

import java.util.ArrayList;

public class MenuFavoriteRepository {

    public ArrayList<MenuItem> getFavoriteFromDB() {
        // Simulate fetching data from a database or data source
        ArrayList<MenuItem> items = new ArrayList<>();
        // Sample data
        items.add(new MenuItem("Latte", R.drawable.latte,4.99));
        items.add(new MenuItem("Cappuccino",R.drawable.cappuccino, 5.49));
        return items;
    }
}
