package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Fragment_Main extends Fragment {
    BottomNavigationView bottomNavigationView;
    RecyclerView newItems, popularItems, suggestedItems;
    GroceryItemAdapter newItemAdapter, popularItemAdapter, suggestedItemAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        initView(view);
        initBottomView();
        initRecyclerView();
        return view;


    }

    private void initRecyclerView() {
        newItemAdapter = new GroceryItemAdapter(getActivity());
        newItems.setAdapter(newItemAdapter);
        newItems.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        popularItemAdapter = new GroceryItemAdapter(getActivity());
        popularItems.setAdapter(popularItemAdapter);
        popularItems.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        suggestedItemAdapter = new GroceryItemAdapter(getActivity());
        suggestedItems.setAdapter(suggestedItemAdapter);
        suggestedItems.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        ArrayList<GroceryItem> allItems = Utils.getAllItems(getActivity());
        if (allItems != null){
            newItemAdapter.setArrayList(allItems);
        }
    }

    private void initBottomView() {
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(getActivity(), "Home Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_cart:
                        Toast.makeText(getActivity(), "Cart Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(getActivity(), "Search Selected", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initView(View view){
        bottomNavigationView = view.findViewById(R.id.bottom_navigation_view);
        newItems = view.findViewById(R.id.rv_new_items);
        popularItems = view.findViewById(R.id.rv_popular_items);
        suggestedItems = view.findViewById(R.id.rv_suggested_items);
    }
}
