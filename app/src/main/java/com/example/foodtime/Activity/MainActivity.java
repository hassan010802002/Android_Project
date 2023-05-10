package com.example.foodtime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.foodtime.Domain.CategoryDomain;
import com.example.foodtime.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter1,adapter2;
    private RecyclerView recyclerViewcategorylist,recyclerViewpopularlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        racyclerviewcategory();
    }

    private void racyclerviewcategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewcategorylist = findViewById(R.id.view1);
        recyclerViewcategorylist.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotdog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Donut","cat_5"));
    }
}