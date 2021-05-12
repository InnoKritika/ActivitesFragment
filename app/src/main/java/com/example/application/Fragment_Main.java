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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_Main extends Fragment {
    BottomNavigationView bottomNavigationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        initView(view);
        initBottomView();
        return view;


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
    }
}
