package com.example.boterprojectjunior;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class Library_Adapter extends RecyclerView.Adapter<Library_ViewHolder> {
    Context context;
    final String TAG="Library_Adapter";

    public Library_Adapter(@NonNull Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public Library_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder= (LayoutInflater.from(parent.getContext()))
                .inflate(R.layout.library_sector_layout,
                        parent,false);
        Log.v(TAG,"I ghave added Viewpager, dude!");
        return new Library_ViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull Library_ViewHolder holder, int  position) {
        //We need data class
        holder.onBindModel();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
