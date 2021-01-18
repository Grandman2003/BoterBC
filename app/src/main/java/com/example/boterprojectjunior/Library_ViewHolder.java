package com.example.boterprojectjunior;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Library_ViewHolder extends RecyclerView.ViewHolder {
    RecyclerView one_library_list;
    Library_Element_Adapter list_adapter;
    RecyclerView.LayoutManager layoutManager;
    final String TAG="Library_ViewHolder";
    static ArrayList<Bot_Info> some_info_example=new ArrayList<Bot_Info>();
    //НИЧЕГО НЕ РАБОТАЕТ
    //С НАСТУПАЮЩИМ НОВЫМ 2021 ГОДОМ!!!!
    //(НЕ ОТОБРАЖАЕТСЯ СПИСОК(ИДЕЯ ВОСПОЛЬЗОВАТЬСЯ ФРАГМЕНТОМ(ЗАПАСНАЯ))
    static {
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("first_field_name","56");
        map.put("second_field_name","54");
        map.put("third_field_name","97");
        map.put("first_field_data","Offers");
        map.put("second_field_data","Somet");
        map.put("third_field_data","Cases");
        some_info_example.add(new Bot_Info("Boutique",map,null));
        some_info_example.add(new Bot_Info("Kaffe",map,null));
        some_info_example.add(new Bot_Info("Tonnic",map,null));
    }

    public Library_ViewHolder(@NonNull View itemView) {
        super(itemView);
        one_library_list=itemView.findViewById(R.id.library_list);
        Log.v(TAG,"It is list initializing, can you believe it! ");
    }
    public void onBindModel(){
        list_adapter=new Library_Element_Adapter(some_info_example,itemView.getContext());
        one_library_list.setAdapter(list_adapter);
        layoutManager=new LinearLayoutManager(itemView.getContext());
        one_library_list.setLayoutManager(layoutManager);
        Log.v(TAG,"And your list is: "+one_library_list.toString());
    }
}
