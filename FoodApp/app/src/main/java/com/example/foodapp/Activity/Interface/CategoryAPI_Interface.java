package com.example.foodapp.Activity.Interface;

import com.example.foodapp.Activity.Adapter.CategoryListResponse;


import retrofit.Callback;
import retrofit.http.GET;

public interface CategoryAPI_Interface {
    @GET("/getdata") public void getUsersList(
            Callback<CategoryListResponse> callback);
}
