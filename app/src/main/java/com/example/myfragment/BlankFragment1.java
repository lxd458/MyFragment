package com.example.myfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BlankFragment1 extends Fragment {
    private   View view;
    private TextView textView;//
    private Button button;//


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
           textView = view.findViewById(R.id.tv);//
            button = view.findViewById(R.id.btn);

        //通按钮触发
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("Yes,I ok");

            }
        });


        return  view;//

    }
}