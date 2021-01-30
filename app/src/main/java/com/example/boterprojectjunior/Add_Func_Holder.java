package com.example.boterprojectjunior;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Add_Func_Holder extends RecyclerView.ViewHolder {
    TextView name;
    public Add_Func_Holder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.addy_element);
    }
}
