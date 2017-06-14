package com.walidatorkh.foodpictures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jbt on 14/06/2017.
 */

public class FoodAdapter extends ArrayAdapter<Food> {
    private LayoutInflater inflater;
    public FoodAdapter (Context context, ArrayList<Food>food){
        super(context, 0, food);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout linearLayoutRoot = (LinearLayout)inflater.inflate(R.layout.food_item, null);
        ImageView imageViewFood = (ImageView)linearLayoutRoot.findViewById(R.id.imageViewFood);
        TextView textViewName = (TextView)linearLayoutRoot.findViewById(R.id.textViewName);

        Food food = getItem(position);
        imageViewFood.setImageResource(food.getImageID());
        textViewName.setText(food.getName());
        return linearLayoutRoot;

    }
}
