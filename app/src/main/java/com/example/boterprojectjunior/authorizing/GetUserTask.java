package com.example.boterprojectjunior.authorizing;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.example.boterprojectjunior.domains.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.Request;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Converter;

public class GetUserTask extends AsyncTask<User,Void,JsonObject> {
    private final FragmentActivity activity;
    final static String TAG=".Task";
    public GetUserTask(FragmentActivity activity) {
        this.activity= activity;
    }

    public JsonObject requestToServer(User req) {
        Gson gson = new Gson();

        String API_URL = "http://192.168.137.1:6782/user/5349032334617817b4b899e3bedb8cb78435144f";
        try {
            URL url = new URL(API_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            Log.v(TAG, "Connection is"+urlConnection.getResponseCode());
            //urlConnection.setDoInput(true);
            //urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");// setting POST method
            //OutputStream out = urlConnection.getOutputStream();

            // сериализованный объект-запрос пишем в поток
           // out.write(req.toByteArray());
            InputStream stream = urlConnection.getInputStream();
            Log.v(TAG, "InputStream is"+stream.toString());
            JsonObject response = gson.fromJson(new InputStreamReader(stream), JsonObject.class);
            Log.v(TAG, "Your response is"+response.toString());
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected JsonObject doInBackground(User... requests) {
        User r = requests[0];
        Log.v(TAG, "Your user is"+r.toString());
        return requestToServer(r);
    }

    @Override
    protected void onPostExecute(JsonObject response) {
        if(response != null)
            Log.v(TAG, response.toString()); else
            Log.v(TAG, "Response is null");

    }
}
