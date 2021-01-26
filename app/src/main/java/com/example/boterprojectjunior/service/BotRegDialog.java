package com.example.boterprojectjunior.service;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

import com.example.boterprojectjunior.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BotRegDialog extends BottomSheetDialogFragment {
    private EditText bot_token;
    private EditText bot_name;
    private Button regist;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CardView view = (CardView) inflater.
                inflate(R.layout.alert_bot_register, container,false);
        bot_token=view.findViewById(R.id.bot_token);
        bot_name=view.findViewById(R.id.bot_name);
        regist=view.findViewById(R.id.register);
        view.setCardElevation(1);
        view.setRadius(20);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BotRegDialog.this.dismiss();
            }
        });
    }

    /*  @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        view.setForegroundGravity(Gravity.BOTTOM);
        view.setBottom(0);
        builder.setView(view).
                setCancelable(true);
        bot_token=view.findViewById(R.id.bot_token);
        bot_name=view.findViewById(R.id.bot_name);

        return builder.create();
        re
    } */
}
