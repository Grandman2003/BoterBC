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

import com.google.android.material.tabs.TabLayout;

public class Second2Fragment extends Fragment {

    ViewPager2 library_lists;
    Library_Adapter library_adapter;
    TabLayout library_tabs;
    private Second2Fragment fragment;
    final String LOGIN_ID="login_id";
    final String PASSWORD_ID="password_id";
    final String TAG="Second2Fragment_Initializing";

    private static Second2Fragment newInstance(){
        return new Second2Fragment();
    }

    public Second2Fragment getInstance(){
        if (fragment!=null){
            return fragment;
        }else{
            this.fragment=Second2Fragment.newInstance();
            return fragment;
        }
    }


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second2, container, false);
        library_lists=view.findViewById(R.id.library_pages);
        library_tabs=view.findViewById(R.id.library_tabs);
        library_adapter=new Library_Adapter(requireContext());
        library_lists.setAdapter(library_adapter);
        Log.v(TAG,"I have appeared!");
        final SharedPreferences login_us_info= requireContext().getSharedPreferences(LOGIN_ID, Context.MODE_PRIVATE);
        final SharedPreferences password_us_info= requireContext().getSharedPreferences(PASSWORD_ID, Context.MODE_PRIVATE);
        return view;
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        library_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                library_lists.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        library_lists.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                library_tabs.selectTab(library_tabs.getTabAt(library_lists.getCurrentItem()));
            }
        });





       // view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
             //   NavHostFragment.findNavController(Second2Fragment.this)
               //         .navigate(R.id.action_SecondFragment_to_MainActivity);
          //  }
       // });
    }
}