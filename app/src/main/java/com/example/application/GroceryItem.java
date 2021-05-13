package com.example.application;

import java.util.ArrayList;

public class GroceryItem {
    int id;
    String name;
    String description;
    String imageUrl;
    String category;
    double price;
    int availableAmount;
    int rate;
    int userPoints;
    int popularityPoints;
    ArrayList<Review> reviewArrayList;

    public GroceryItem( String name, String description, String imageUrl, String category, double price, int availableAmount) {
        this.id = Utils.getId();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.price = price;
        this.availableAmount = availableAmount;
        this.rate = 0;
        this.userPoints = 0;
        this.popularityPoints = 0;
        reviewArrayList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    public int getPopularityPoints() {
        return popularityPoints;
    }

    public void setPopularityPoints(int popularityPoints) {
        this.popularityPoints = popularityPoints;
    }

    public ArrayList<Review> getReviewArrayList() {
        return reviewArrayList;
    }

    public void setReviewArrayList(ArrayList<Review> reviewArrayList) {
        this.reviewArrayList = reviewArrayList;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", availableAmount=" + availableAmount +
                ", rate=" + rate +
                ", userPoints=" + userPoints +
                ", popularityPoints=" + popularityPoints +
                ", reviewArrayList=" + reviewArrayList +
                '}';
    }
}
