package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        Utils.initSharedPreferences(this);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.cart:
                        Intent intent = new Intent(MainActivity.this,Activity.class);
                        startActivity(intent);
                        break;
                    case R.id.categories:
                        Toast.makeText(MainActivity.this, "Categories", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.aboutUs:
                        Toast.makeText(MainActivity.this, "About Us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.terms:
                        Toast.makeText(MainActivity.this, "Terms", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new Fragment_Main());
        transaction.commit();
    }
    private void initView(){
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationDrawer);
        toolbar = findViewById(R.id.toolbar);
    }
}