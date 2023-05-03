package com.example.foodapp.Activity.Adapter;

import com.example.foodapp.Activity.Domain.CategoryDomain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryListResponse {
    @SerializedName("data")
    public List<CategoryDomain> data = new ArrayList<>();
}
