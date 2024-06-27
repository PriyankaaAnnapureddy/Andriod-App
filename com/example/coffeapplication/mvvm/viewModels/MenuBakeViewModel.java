package com.example.coffeapplication.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.coffeapplication.mvvm.models.MenuItem;
import com.example.coffeapplication.mvvm.repositories.MenusRepository;

import java.util.ArrayList;

public class MenuBakeViewModel extends ViewModel {
    private MutableLiveData<ArrayList<MenuItem>> currentMenu;

    public MenuBakeViewModel() {
        MenusRepository menusRepository = new MenusRepository();
        currentMenu = new MutableLiveData<>(menusRepository.getBakeHolder());
    }

    public MutableLiveData<ArrayList<MenuItem>> getCurrentMenu() {
        return currentMenu;
    }
}

