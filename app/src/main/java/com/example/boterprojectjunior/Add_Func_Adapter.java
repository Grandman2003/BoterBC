package com.example.boterprojectjunior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boterprojectjunior.service.BotItemsFragment;

public class Add_Func_Adapter extends RecyclerView.Adapter<Add_Func_Holder> {
    Context context;
    String[] list;
    BotItemsFragment fragment;

    public  Add_Func_Adapter(String[] list, Context context, BotItemsFragment fragment){
        this.list=list;
        this.context=context;
        this.fragment=fragment;
    }
    @NonNull
    @Override
    public Add_Func_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_from_list_layout_item,parent,false);
        return new Add_Func_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Add_Func_Holder holder, int position) {
        holder.name.setText(list[position]);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.addItem(String.valueOf(holder.name.getText()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
