package com.example.boterprojectjunior.service;

import com.example.boterprojectjunior.domains.User;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit.http.Query;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("/user/add")
    Call<User> addUser(@Body User object);

    @DELETE("user/delete")
    Call <User> deleteUser(@Body User object);

    @GET("/user")
    Call<ArrayList<User>> getAllUsers();

    @GET("/user/{id}")
    Call<Gson> getUser(@Path("id")int id);

    @GET("/user/{token}")
    Call <User> getUser(@Path("token") String token);


}
