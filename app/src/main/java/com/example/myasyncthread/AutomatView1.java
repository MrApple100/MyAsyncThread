package com.example.myasyncthread;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowContentFrameStats;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class AutomatView1 extends Fragment {

    static String State;
    static String KolQ;
    static String Who;
    static String What;
    int Num = 1;
    ArrayList<Good> goodsAutomat1 = new ArrayList<>(Arrays.asList(new Good(Good.goods.get(1), 50, 4), new Good(Good.goods.get(2), 50, 4), new Good(Good.goods.get(3), 50, 4), new Good(Good.goods.get(4), 50, 4)));


    static TextView State1;

    static TextView What1;

    static TextView Who1;

    static TextView KolQ1;

    static RecyclerView Goodlist1;
    public static void  setAutomatView1(String state, String kolQ, String who, String what) {
        State = state;
        KolQ = kolQ;
        Who = who;
        What = what;
    }
    private static AutomatView1 instance;

    public static AutomatView1 getInstance() {
        if (instance == null) {
            instance = new AutomatView1();
        }
        return instance;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.automat, container, false);
        System.out.println("View: "+view);
        State1 = (TextView) view.findViewById(R.id.State1);

        What1 = (TextView) view.findViewById(R.id.What1);

        Who1 = (TextView) view.findViewById(R.id.Who1);

        KolQ1 = (TextView) view.findViewById(R.id.QueryKol1);

        Goodlist1 = (RecyclerView) view.findViewById(R.id.Goodlist1);
        GoodAdapter goodAdapter1 = new GoodAdapter(view.getContext(), goodsAutomat1);
        Goodlist1.setAdapter(goodAdapter1);
        update();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                AutomatView1 automatView =(AutomatView1) fm.findFragmentById(R.id.automat1holder);
                //ft.setCustomAnimations(R.anim.animout,R.anim.animin);
                ft.remove(automatView);
                ft.remove(AutomatView2.getInstance());
                ft.remove(AutomatView3.getInstance());
                ft.remove(AutomatView4.getInstance());
                ft.commit();
                fm.executePendingTransactions();

                ft = fm.beginTransaction();
                BackButton.automat=automatView;
                ft.add(R.id.Framelayout,automatView);
                ft.add(R.id.Framelayout,new BackButton());
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static void update(){
        State1.setText(State);
        KolQ1.setText(KolQ);
        Who1.setText(Who);
        What1.setText(What);

        for(int i=0;i<Goodlist1.getChildCount();i++){
            if(((GoodAdapter.ViewHolder)(Goodlist1.getChildViewHolder(Goodlist1.getChildAt(i)))).NameGood.getText().toString().compareTo(What)==0){
                int lastkol=Integer.parseInt(((GoodAdapter.ViewHolder)(Goodlist1.getChildViewHolder(Goodlist1.getChildAt(i)))).KolGood.getText()+"");
                if(lastkol!=0) {
                    ((GoodAdapter.ViewHolder) (Goodlist1.getChildViewHolder(Goodlist1.getChildAt(i)))).KolGood.setText((lastkol - 1)+"");
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
