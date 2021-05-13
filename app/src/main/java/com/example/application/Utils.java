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
                , "https://www.google.com/search?q=milk&rlz=1C1CHBF_enIN927IN927&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj8gPqinMfwAhVHfSsKHWK7DDwQ_AUoAXoECAIQAw#imgrc=LRC_2wfs_X9pWM","drink",55,0);
        allItems.add(milk);

        GroceryItem iceCream = new GroceryItem("Ice - Cream","Ice cream, frozen dairy food made from cream or butterfat, milk, sugar, and flavourings.",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.allrecipes.com%2Frecipe%2F19002%2Ffive-ingredient-ice-cream%2F&psig=AOvVaw1bBhY03qblpfsfXc0Po51J&ust=1621014690567000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPCK77qcx_ACFQAAAAAdAAAAABAD","food",540,15);
        allItems.add(iceCream);

        GroceryItem soda = new GroceryItem("Soda","Carbonated drinks or fizzy drinks are beverages that contain dissolved carbon dioxide",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.indiamart.com%2Fproddetail%2Fkinley-soda-21492065197.html&psig=AOvVaw2CK53kLC4m3VoI4AzfsAHx&ust=1621014712564000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMjKzsScx_ACFQAAAAAdAAAAABAD","drink",120,10);
        allItems.add(soda);

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
