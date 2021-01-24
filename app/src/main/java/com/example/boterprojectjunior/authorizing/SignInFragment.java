package com.example.boterprojectjunior.authorizing;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.boterprojectjunior.MainActivity;
import com.example.boterprojectjunior.R;
import com.example.boterprojectjunior.domains.User;
import com.example.boterprojectjunior.service.UserService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInFragment extends Fragment {
    private EditText login_field;
    private EditText password_field;
    private String login;
    private String password;
    private ProgressBar progressBar;
    private static final String TAG=".SignInFragment";
    final String LOGIN_ID="login_id";
    final String PASSWORD_ID="password_id";
    private Button signer;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        login="";
        password="";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_sign_in, container, false);
        login_field=view.findViewById(R.id.login);
        login_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                login=login_field.getText().toString().trim();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login=login_field.getText().toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {

                login=login_field.getText().toString().trim();
            }
        });
        password_field=view.findViewById(R.id.passworder);
        password_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                password=password_field.getText().toString().trim();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password=password_field.getText().toString().trim();
            }

            @Override
            public void afterTextChanged(Editable s) {
                password=password_field.getText().toString().trim();
            }
        });
        progressBar=view.findViewById(R.id.progressBar);
        return view;
    }

    public void onViewCreated(@NonNull View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //final SharedPreferences login_us_info= requireContext().getSharedPreferences(LOGIN_ID, Context.MODE_PRIVATE);
        //final SharedPreferences password_us_info= requireContext().getSharedPreferences(PASSWORD_ID, Context.MODE_PRIVATE);
            view.findViewById(R.id.sign_in).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // SharedPreferences.Editor editor=login_us_info.edit();
                   // editor.putString(LOGIN_ID,login).apply();
                   // SharedPreferences.Editor editor1=password_us_info.edit();
                   // editor1.putString(PASSWORD_ID,login).apply();
                   // NavHostFragment.findNavController(SignInFragment.this)
                   //         .navigate(R.id.action_FirstFragment_to_SecondFragment);
                    userLogin();
                }
            });
            view.findViewById(R.id.regist_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavHostFragment.findNavController(SignInFragment.this)
                            .navigate(R.id.action_SignInFragment_to_RegistrationFragment);
                }
            });

    }

    private void userLogin(){
        if (login.isEmpty()){
            login_field.setError(requireContext().getString(R.string.email_error));
            login_field.requestFocus();
            return;
        }
        if (password.isEmpty()){
            password_field.setError(requireContext().getString(R.string.password_error));
            password_field.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(login).matches()){
            login_field.setError(requireContext().getString(R.string.email_matches_error));
            login_field.requestFocus();
            return;
        }
        if (password.length()< 7){
            password_field.setError(requireContext().getString(R.string.pass_leng_error));
            password_field.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(login,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    final FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    assert user != null;
                    if(user.isEmailVerified()){
                        progressBar.setVisibility(View.INVISIBLE);
                        FirebaseDatabase.getInstance().getReference("Users").get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                            @Override
                            public void onSuccess(DataSnapshot dataSnapshot) {
                                HashMap<String, String> data=(HashMap<String, String>)
                                        dataSnapshot.child(user.getUid()).getValue();
                                data.put("token",user.getUid());
                                User app_user =new User(data);
                                Log.v(TAG,"IDshnik"+user.getUid());
                                 Log.v(TAG, app_user.first_name);
                                 //initUser(app_user);
                                initUser(app_user);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.v(TAG, "Operation to get data has failed");
                                e.printStackTrace();
                            }
                        });
                      //  initUser(app_user[0]);

                        NavHostFragment.findNavController(SignInFragment.this)
                                .navigate(R.id.action_SignInFragment_to_WorkField);
                    }else{
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(requireContext(),requireContext().getString(R.string.email_not_verified),Toast.LENGTH_LONG).show();
                    }
                    }else{
                    Toast.makeText(requireContext(),
                            requireContext().getString(R.string.login_failure),
                            Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }


    private void initilize_user(User app_user){
        GetUserTask task = new GetUserTask(getActivity());
        task.execute(app_user);
    }

    private void initUser(User app_user) {
        if (app_user != null) {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl("http://192.168.137.1:6782").
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            UserService service = retrofit.create(UserService.class);
            try {
                Gson gson=new Gson();
                Call<User> caller=service.addUser(app_user);
                Log.v(TAG,caller.request().url().toString());
                Log.v(TAG, Objects.requireNonNull(caller.request().body().toString()));
                caller.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.v(TAG, response.message());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.v(TAG,"IT IS FAILED,MAN");
                    }
                });
            } catch (NullPointerException e) {
                e.printStackTrace();
            }


        }
    }
}