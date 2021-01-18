package com.example.boterprojectjunior;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Library_List_Element_ViewHolder extends RecyclerView.ViewHolder{
    TextView Bot_name;
    ImageView Bot_profile;
    TableLayout Info_layout;
    TextView first_name;
    TextView second_name;
    TextView third_name;
    TextView first_data;
    TextView second_data;
    TextView third_data;
    ImageView dots;
    String TAG = "BOT_DATA_LIST_ELEMENT";
    View itemView;

    public Library_List_Element_ViewHolder(@NonNull View itemView) {
        super(itemView);
        Bot_name=itemView.findViewById(R.id.bot_name);
        Bot_profile=itemView.findViewById(R.id.bot_photo_profile);
        Info_layout=itemView.findViewById(R.id.info_short_data);
        first_name=itemView.findViewById(R.id.first_info_name);
        second_name=itemView.findViewById(R.id.second_info_name);
        third_name=itemView.findViewById(R.id.third_info_name);
        first_data=itemView.findViewById(R.id.first_info_data);
        second_data=itemView.findViewById(R.id.second_info_data);
        third_data=itemView.findViewById(R.id.third_info_data);
        dots=itemView.findViewById(R.id.more_dots);
        this.itemView=itemView;
    }
    public void onBindModel (final Bot_Info info)
            throws NullPointerException {
        Bot_name.setText(info.bot_name);
        try{
        first_name.setText(info.short_data.get("first_field_name"));
        second_name.setText(info.short_data.get("second_field_name"));
        third_name.setText(info.short_data.get("third_field_name"));
        first_data.setText(info.short_data.get("first_field_data"));
        second_data.setText(info.short_data.get("second_field_data"));
        third_data.setText(info.short_data.get("third_field_data"));
        Log.v(TAG,"I have inserted info to element! ");
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
            Log.d(TAG,"Something wrong with bot element");
        }
    }

}
