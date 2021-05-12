package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class GroceryItemAdapter extends RecyclerView.Adapter<GroceryItemAdapter.ViewHolder> {
    Context context;
    ArrayList<GroceryItem> arrayList = new ArrayList<>();

    public GroceryItemAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.price.setText(""+arrayList.get(position).getPrice());
        Glide.with(context)
                .asBitmap()
                .load(arrayList.get(position).getImageUrl())
                .into(holder.image);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent in = new Intent(context,GroceryDetailsActivity.class);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,price;
        ImageView image;
        MaterialCardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_product_name);
            price = itemView.findViewById(R.id.tv_price);
            image = itemView.findViewById(R.id.iv_image);
            parent = itemView.findViewById(R.id.cv_grocery_item);
        }
    }

    public void setArrayList(ArrayList<GroceryItem> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
}
