package com.example.boterprojectjunior.service;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.boterprojectjunior.R;
import com.example.boterprojectjunior.service.dummy.BotListItem;


import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class BotItemsFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private final ArrayList<BotListItem> items;
    private RecyclerView recyclerView;
    //static {
      //  items.add(new BotListItem(1,"echo answer",null));
       // items.add(new BotListItem(2,"ask and answer",null));
       // items.add(new BotListItem(3,"poll request",null));
       // items.add(new BotListItem(4,"statistics",null));
   // }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BotItemsFragment() {
        this.items=new ArrayList<BotListItem>();
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BotItemsFragment newInstance(int columnCount) {
        BotItemsFragment fragment = new BotItemsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    public void addItem(String name){
        items.add(new BotListItem(items.size(),name,null));
        MyItemRecyclerViewAdapter adapter= (MyItemRecyclerViewAdapter) recyclerView.getAdapter();
        assert adapter != null;
        adapter.setmValues(items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bot_items_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(items));
        }
        return view;
    }
}