package com.example.boterprojectjunior;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Function_Holder extends RecyclerView.ViewHolder {
    View itemview;
    RecyclerView listView;
    Button main_element;

    public Function_Holder(@NonNull View itemView) {
        super(itemView);
        this.itemview=itemView;
        this.listView=itemView.findViewById(R.id.elements);
        this.main_element=itemView.findViewById(R.id.main_element);
    }

    public void onBindModel(int position,String button_name){
    }
    public static int getID(int position){
        switch (position){
            case 0:
                return R.array.first;
            case 1:
                return R.array.second;
            case 2:
                return R.array.third;
        }
        return 0;
    }
}
