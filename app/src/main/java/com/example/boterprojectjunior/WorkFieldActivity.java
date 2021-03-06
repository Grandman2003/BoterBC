package com.example.boterprojectjunior;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.boterprojectjunior.service.BotRegDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkFieldActivity extends AppCompatActivity {
    FloatingActionButton add_new_bot;
    Second2Fragment second2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_field);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        second2Fragment=new Second2Fragment();
        add_new_bot = findViewById(R.id.fab);
        add_new_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                openRegDialog();
            }
        });

        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().add(second2Fragment,".SecondFragment").commit();
    }


    private void openRegDialog() {
        BotRegDialog dialog= new BotRegDialog(getSupportFragmentManager().findFragmentByTag(".SecondFragment"));
        dialog.setCancelable(true);
        dialog.show(getSupportFragmentManager(),"bot_reg_dialog");
    }
}