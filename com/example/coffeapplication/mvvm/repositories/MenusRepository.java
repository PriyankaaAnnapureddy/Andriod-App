package com.example.coffeapplication.mvvm.repositories;

import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.models.MenuItem;

import java.util.ArrayList;

public class MenusRepository {

    public ArrayList<MenuItem> getBakeHolder() {
        ArrayList<MenuItem> bakeMenu = new ArrayList<>();
        bakeMenu.add(new MenuItem("Baked Coffee Cake", R.drawable.baked_coffee_cake, 5.99));
        bakeMenu.add(new MenuItem("Baked Cheesecake", R.drawable.baked_cheesecake, 6.99));
        bakeMenu.add(new MenuItem("Baked Donuts", R.drawable.baked_donuts, 4.49));
        bakeMenu.add(new MenuItem("Baked Muffins", R.drawable.baked_muffins, 3.99));
        bakeMenu.add(new MenuItem("Baked Scones", R.drawable.baked_scones, 4.99));
        bakeMenu.add(new MenuItem("Baked Brownies", R.drawable.baked_brownies, 4.49));
        return bakeMenu;
    }

    public ArrayList<MenuItem> getSeasonHolder() {
        ArrayList<MenuItem> seasonMenu = new ArrayList<>();
        seasonMenu.add(new MenuItem("Seasonal Pumpkin Latte", R.drawable.pumpkin_latte, 4.99));
        seasonMenu.add(new MenuItem("Seasonal Apple Pie", R.drawable.apple_pie, 3.99));
        seasonMenu.add(new MenuItem("Seasonal Cranberry Muffin", R.drawable.cranberry_muffin, 3.49));
        seasonMenu.add(new MenuItem("Seasonal Peppermint Mocha", R.drawable.peppermint_mocha, 5.49));
        seasonMenu.add(new MenuItem("Seasonal Gingerbread Cookie", R.drawable.gingerbread_cookie, 2.99));
        seasonMenu.add(new MenuItem("Seasonal Eggnog Latte", R.drawable.eggnog_latte, 4.99));
        return seasonMenu;
    }

    public ArrayList<MenuItem> getStandartHolder() {
        ArrayList<MenuItem> standartMenu = new ArrayList<>();
        standartMenu.add(new MenuItem("Classic Black Coffee", R.drawable.black_coffee, 2.99));
        standartMenu.add(new MenuItem("Classic Latte", R.drawable.latte, 3.99));
        standartMenu.add(new MenuItem("Classic Cappuccino", R.drawable.cappuccino, 4.49));
        standartMenu.add(new MenuItem("Classic Espresso", R.drawable.espresso, 2.49));
        standartMenu.add(new MenuItem("Classic Americano", R.drawable.americano, 3.49));
        standartMenu.add(new MenuItem("Classic Mocha", R.drawable.mocha, 4.99));
        return standartMenu;
    }
}
