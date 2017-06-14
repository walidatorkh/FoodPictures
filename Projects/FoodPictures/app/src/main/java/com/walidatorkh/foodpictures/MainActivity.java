package com.walidatorkh.foodpictures;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewFood;
    private ArrayList<Food> food = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewFood = (ListView)findViewById(R.id.listViewFood);

        food.add(new Food("Chicken", R.drawable.chicken));
        food.add(new Food("Hamburgers", R.drawable.hamburgers));
        food.add(new Food("Meatballs", R.drawable.meatballs));
        food.add(new Food("Pasta", R.drawable.pasta));
        food.add(new Food("Pizza", R.drawable.pizza));

        FoodAdapter foodAdapter = new FoodAdapter(this, food);

        listViewFood.setAdapter(foodAdapter);

    }
}
