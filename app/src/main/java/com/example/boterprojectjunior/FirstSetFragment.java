package com.example.boterprojectjunior;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boterprojectjunior.service.BotItemsFragment;

public class FirstSetFragment extends Fragment {
    RecyclerView recycles;
    RecyclerView.LayoutManager layoutManager;
    BotItemsFragment fragment;

    public FirstSetFragment(BotItemsFragment fragment){
        this.fragment=fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.start_set_fragment,container,false);
        recycles=view.findViewById(R.id.add_list);
        layoutManager=new LinearLayoutManager(getContext());
        Function_List_Adapter adapter=new Function_List_Adapter(requireContext(),fragment);
        recycles.setAdapter(adapter);
        recycles.setLayoutManager(layoutManager);
        return view;
    }
}
