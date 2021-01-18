package com.example.boterprojectjunior;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Library_Element_Adapter extends RecyclerView.Adapter<Library_List_Element_ViewHolder> {
    Context context;
    private List<Bot_Info> mItems;
    final String TAG="ELEMENT_ADAPTER";

    public Library_Element_Adapter(List<Bot_Info> mItems,Context context) {
        this.context = context;
        this.mItems=mItems;
    }

    @NonNull
    @Override
    public Library_List_Element_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View library_listic= (LayoutInflater.from(parent.getContext())).inflate(R.layout.library_list_element,
                parent,false);
        Log.v(TAG,"It is list_element creating initializing, hey! ");
        return new Library_List_Element_ViewHolder(library_listic);
    }

    @Override
    public void onBindViewHolder(@NonNull Library_List_Element_ViewHolder holder, int position) {
        holder.onBindModel(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
