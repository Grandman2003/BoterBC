package com.example.boterprojectjunior.domains;

import java.util.ArrayList;
import java.util.HashMap;

public class Bot_Functions {
    String func_name;
    String SendType;
    HashMap<String,String> fields;

    public Bot_Functions(String func_name, String sendType) {
        this.func_name = func_name;
        SendType = sendType;
        fields=new HashMap<>();
    }
}
