package com.example.boterprojectjunior;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import com.example.boterprojectjunior.service.BotItemsFragment;

public class GeneratorActivity extends AppCompatActivity {
    FragmentManager manager;
    BotItemsFragment list_fragment;
    FirstSetFragment setFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        manager=getSupportFragmentManager();
        setFragment=new FirstSetFragment();
        list_fragment=BotItemsFragment.newInstance(1);
        manager.beginTransaction().add(R.id.list_bot,list_fragment,"..BotFuncList")
                                    .add(R.id.setting_field,setFragment).commit();

    }

}