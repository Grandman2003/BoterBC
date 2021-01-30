package com.example.boterprojectjunior;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.boterprojectjunior.domains.BotSkeleton;
import com.example.boterprojectjunior.domains.User;
import com.example.boterprojectjunior.service.BotItemsFragment;
import com.example.boterprojectjunior.service.UserService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeneratorActivity extends AppCompatActivity {
    FragmentManager manager;
    BotItemsFragment list_fragment;
    FirstSetFragment setFragment;
    FloatingActionButton button;
    ProgressBar loadingbar;
    EditText botname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        manager=getSupportFragmentManager();
        botname=findViewById(R.id.namibot);
        loadingbar=findViewById(R.id.loading_bar);
        button=findViewById(R.id.send_bot_button);
        SharedPreferences preferences=getSharedPreferences("BOTDATA",MODE_PRIVATE);
        String bot_name=preferences.getString("BOTNAME",null);
        botname.setText(bot_name);
        list_fragment=BotItemsFragment.newInstance(1);
        setFragment=new FirstSetFragment(list_fragment);
        manager.beginTransaction().add(R.id.list_bot,list_fragment,"..BotFuncList")
                                    .add(R.id.setting_field,setFragment).commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingbar.setVisibility(View.VISIBLE);
                Retrofit retrofit = new Retrofit.Builder().
                        baseUrl("http://192.168.137.1:6782").
                        addConverterFactory(GsonConverterFactory.create()).
                        build();
                UserService service = retrofit.create(UserService.class);
                try {
                    Call<BotSkeleton> caller=service.addBot(
                            new BotSkeleton(
                                    getSharedPreferences("BOTDATA",MODE_PRIVATE)
                                            .getString("BOTTOKEN","you are wrong"),botname.getText().toString(),""));
                    caller.enqueue(new Callback<BotSkeleton>() {
                        @Override
                        public void onResponse(Call<BotSkeleton> call, Response<BotSkeleton> response) {
                            loadingbar.setVisibility(View.INVISIBLE);
                            Log.v("SERVER_CODE",String.valueOf(response.code()));
                            if (response.code()/100==2){
                            findViewById(R.id.line_view).setVisibility(View.INVISIBLE);
                            button.setVisibility(View.INVISIBLE);
                            getSupportFragmentManager().beginTransaction()
                                    .remove(list_fragment)
                                    .remove(setFragment)
                                    .add(R.id.success_frame,new SuccessFrag()).commit();
                        }else{
                                Toast.makeText(getApplicationContext(),
                                        "Возникла проблема",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<BotSkeleton> call, Throwable t) {
                            loadingbar.setVisibility(View.INVISIBLE);
                            findViewById(R.id.line_view).setVisibility(View.INVISIBLE);
                            button.setVisibility(View.INVISIBLE);
                            getSupportFragmentManager().beginTransaction()
                                    .remove(list_fragment)
                                    .remove(setFragment)
                                    .add(R.id.success_frame,new SuccessFrag()).commit();
                            //Toast.makeText(getApplicationContext(),
                                 //   "Возникла проблема",Toast.LENGTH_LONG).show();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });

    }


}