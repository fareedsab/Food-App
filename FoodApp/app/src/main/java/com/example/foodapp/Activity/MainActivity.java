package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.foodapp.Activity.Adapter.CatAPI;
import com.example.foodapp.Activity.Adapter.CategoryAdapter;
import com.example.foodapp.Activity.Adapter.CategoryListResponse;
import com.example.foodapp.Activity.Adapter.PopularAdapter;
import com.example.foodapp.Activity.Adapter.PopularListResponse;
import com.example.foodapp.Activity.Domain.CategoryDomain;
import com.example.foodapp.Activity.Domain.PopularDomain;
import com.example.foodapp.R;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private ArrayList<CategoryDomain> Categories = new ArrayList<>();
    private RecyclerView catlist,poplist;
    ArrayList<PopularDomain> popular = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerviewCategoryList();
        recyclerviewPopularList();
    }

    private void recyclerviewCategoryList() {
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        catlist = findViewById(R.id.catlist);
        catlist.setLayoutManager(linearLayoutManager);

//        ArrayList<CategoryDomain> category= new ArrayList<>();
//        category.add(new CategoryDomain("Pizza","cat_1"));
//        category.add(new CategoryDomain("Burger","cat_2"));
//        category.add(new CategoryDomain("HotDog","cat_3"));
//        category.add(new CategoryDomain("Drink","cat_4"));
//        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdapter(Categories);
        catlist.setAdapter(adapter);
        CatAPI.getClient().getUsersList(new Callback<CategoryListResponse>() {

            @Override
            public void success(CategoryListResponse categoryListResponse, Response response) {
                Log.d("TAG", "Total Users: " + response.getBody());
                CategoryListResponse categories =  categoryListResponse;
                if (categories != null) {
                    Categories.addAll(categories.data);
                    adapter.notifyDataSetChanged();
                }
            }



            @Override
            public void failure(RetrofitError error) {
             //   Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            Log.d("TAG","Response = "+error.toString());
            }

        });

    }

    public void recyclerviewPopularList()
    {
        LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        poplist=findViewById(R.id.popularlist);
        poplist.setLayoutManager(linearLayoutManager);
        adapter2 = new PopularAdapter(popular);
        poplist.setAdapter(adapter2);
        CatAPI.getClient().getpopularList(new Callback<PopularListResponse>() {
            @Override
            public void success(PopularListResponse popularListResponse, Response response) {
                Log.d("TAG", "Total Users: " + response.getBody());
                PopularListResponse categories =  popularListResponse;
                if (categories != null) {
                   popular.addAll(popularListResponse.data);
                    adapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                //   Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                Log.d("TAG","Response = "+error.toString());
            }

        });






    }

}