package com.example.coffeapplication.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeapplication.mvvm.adapters.NewsAdapter;
import com.example.coffeapplication.R;
import com.example.coffeapplication.mvvm.models.News;
import com.example.coffeapplication.mvvm.viewModels.NewsViewModel;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    NewsAdapter adapter;
    NewsViewModel newsViewModel;
    RecyclerView rcv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the NewsViewModel
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        rcv = view.findViewById(R.id.newsRecycler);

        // Observer to update the RecyclerView when data changes
        final Observer<ArrayList<News>> nameObserver = new Observer<ArrayList<News>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<News> news) {
                // Initialize the adapter with the retrieved data and context
                adapter = new NewsAdapter(news, requireActivity().getApplicationContext());
                rcv.setAdapter(adapter);
            }
        };

        // Attach the observer to the ViewModel
        newsViewModel.getCurrentName().observe(getViewLifecycleOwner(), nameObserver);

        // Set up the RecyclerView with a GridLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        rcv.setLayoutManager(gridLayoutManager);

        return view;
    }
}
