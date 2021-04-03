package com.example.myasyncthread;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class AutomatView1 extends Fragment {
    static String State = "Разогрев";
    static String KolQ = "подождите";
    static String Who = "подождите";
    static String What = "подождите";
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
        return view;

    }


    public static void update(){
        System.out.println(State1);
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
}
