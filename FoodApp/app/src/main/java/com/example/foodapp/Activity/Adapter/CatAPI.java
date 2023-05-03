package com.example.foodapp.Activity.Adapter;

import com.example.foodapp.Activity.Interface.CategoryAPI_Interface;

import retrofit.RestAdapter;

public class CatAPI {

    public static CategoryAPI_Interface getClient()
    {
        String remoteHost = "https://f7b2-2407-aa80-15-f20f-743d-cf37-6f51-59a8.ngrok-free.app";

        String localHost = "http://192.168.3.102:5000";
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(remoteHost) .build();
        CategoryAPI_Interface api = adapter.create(CategoryAPI_Interface.class);
        return api; // return the APIInterface object
    }
}