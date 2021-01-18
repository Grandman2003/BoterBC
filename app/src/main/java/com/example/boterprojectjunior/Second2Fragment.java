package com.example.boterprojectjunior;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

public class Second2Fragment extends Fragment {

    ViewPager2 library_lists;
    Library_Adapter library_adapter;
    final String LOGIN_ID="login_id";
    final String PASSWORD_ID="password_id";
    final String TAG="Second2Fragment_Initializing";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second2, container, false);
        library_lists=view.findViewById(R.id.library_pages);
        library_adapter=new Library_Adapter(requireContext());
        library_lists.setAdapter(library_adapter);
        Log.v(TAG,"I have appeared!");
        final SharedPreferences login_us_info= requireContext().getSharedPreferences(LOGIN_ID, Context.MODE_PRIVATE);
        final SharedPreferences password_us_info= requireContext().getSharedPreferences(PASSWORD_ID, Context.MODE_PRIVATE);
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   NavHostFragment.findNavController(Second2Fragment.this)
               //         .navigate(R.id.action_SecondFragment_to_MainActivity);
          //  }
       // });
    }
}