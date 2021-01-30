package com.example.boterprojectjunior;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boterprojectjunior.service.BotItemsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Function_List_Adapter extends RecyclerView.Adapter<Function_Holder> {
   String[] names;
   private Context context;
   BotItemsFragment fragment;

   public Function_List_Adapter(Context context, BotItemsFragment fragment){
       names= context.getResources().getStringArray(R.array.functions);
       this.context=context;
       this.fragment=fragment;
       Log.v("LISTCHECKER", names.toString());
   }

    @NonNull
    @Override
    public Function_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.function_item,parent,false);
        return new Function_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Function_Holder holder, int position) {
        holder.main_element.setText(names[position]);
        holder.main_element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] list= holder.itemview.getContext()
                        .getResources()
                        .getStringArray(Function_Holder.getID(position));
               holder.listView.setAdapter(new Add_Func_Adapter(list,context,fragment));
               holder.listView.setLayoutManager(new LinearLayoutManager(context));
              //  Log.v("LISTCHECKER", String.valueOf(adapter.getCount()));
            }
        });
    }

    private HashMap<String,Object> addMap(String el){
       HashMap<String,Object> map=new HashMap<>();
       map.put("ELEMENT",el);
       return map;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
