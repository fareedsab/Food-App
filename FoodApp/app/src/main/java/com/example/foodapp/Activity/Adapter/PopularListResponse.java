package com.example.foodapp.Activity.Adapter;

import com.example.foodapp.Activity.Domain.CategoryDomain;
import com.example.foodapp.Activity.Domain.PopularDomain;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PopularListResponse {
    @SerializedName("data")
    public List<PopularDomain> data = new ArrayList<>();
}
