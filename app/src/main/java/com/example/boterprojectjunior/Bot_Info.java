package com.example.boterprojectjunior;

import android.graphics.Bitmap;

import java.util.HashMap;

public class Bot_Info {
    String bot_name;
    HashMap<String,String> short_data;
    Bitmap bot_profile;

    public Bot_Info(String bot_name, HashMap<String, String> short_data, Bitmap bot_profile) {
        this.bot_name = bot_name;
        this.short_data = short_data;
        this.bot_profile = bot_profile;
    }

}
