package com.example.myasyncthread;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BackButton extends Fragment {
   static Fragment automat;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.backbut,container,false);
        ((Button)view.findViewById(R.id.backbut)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
                fm.executePendingTransactions();
                FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.automat1holder,AutomatView1.getInstance());
                ft.add(R.id.automat2holder,AutomatView2.getInstance());
                ft.add(R.id.automat3holder,AutomatView3.getInstance());
                ft.add(R.id.automat4holder,AutomatView4.getInstance());
                ft.commit();
                fm.executePendingTransactions();
                //FragmentTransaction ft = fm.beginTransaction();
                //ft.commit();
            }
        });
        return view;
    }
}
