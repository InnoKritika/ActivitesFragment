package com.example.application;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static int id = 0;
    private static final String db_name=  "fake_database";
    private static final String all_items_key = "all_items";
    private static Gson gson = new Gson();
    private static Type groceryListType  =  new TypeToken<ArrayList<GroceryItem>>(){}.getType();

    public static void initSharedPreferences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(db_name,Context.MODE_PRIVATE);
        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString(all_items_key,null),groceryListType);
        if (allItems == null){
            initAllItems(context);
        }
    }

    private static void initAllItems(Context context) {
        ArrayList<GroceryItem> allItems = new ArrayList<>();
        GroceryItem milk = new GroceryItem("Milk","It's packed with important nutrients like calcium, phosphorus, B vitamins, potassium and vitamin D. "
                , R.drawable.milk,"drink",55,0);
        allItems.add(milk);

        SharedPreferences sharedPreferences = context.getSharedPreferences(db_name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(all_items_key,gson.toJson(allItems));
        editor.commit();
    }

    public static ArrayList<GroceryItem> getAllItems(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(db_name,Context.MODE_PRIVATE);
        ArrayList<GroceryItem> allItems = gson.fromJson(sharedPreferences.getString(all_items_key,null),groceryListType);
        return allItems;
    }
    public static int getId() {
        id++;
        return id;
    }
}
