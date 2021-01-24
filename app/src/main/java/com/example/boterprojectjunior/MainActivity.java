package com.example.boterprojectjunior;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.os.Message;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    NetworkInfo info;
    AlertDialog alertDialog;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater li=LayoutInflater.from(this);
        final View warn=li.inflate(R.layout.inter_error,null);
        builder.setView(warn).setCancelable(true);
        alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        handler=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what==1){
                    alertDialog.show();
                }else if(msg.what==2){
                    alertDialog.cancel();
                }
            }
        };
        AsyncTask task=new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] objects) {
                checkConnection();
                Log.v("HI","hi");
                return null;
            }
        }.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
        if (info == null || !info.isConnected() || !info.isAvailable()) {
            handler.sendEmptyMessage(1);
        } else {
            handler.sendEmptyMessage(2);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkConnection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkConnection();

    }

    @Override
    protected void onPause() {
        super.onPause();
        checkConnection();
    }

    @Override
    protected void onStop() {
        super.onStop();
        checkConnection();
    }
}