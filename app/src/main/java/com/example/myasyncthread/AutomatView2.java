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

public class AutomatView2 extends Fragment {

    static String State = "Разогрев";
    static String KolQ = "подождите";
    static String Who = "подождите";
    static String What = "подождите";
    int Num = 2;
    ArrayList<Good> goodsAutomat2 = new ArrayList<>(Arrays.asList(new Good(Good.goods.get(5), 50, 4), new Good(Good.goods.get(6), 25, 4), new Good(Good.goods.get(7), 25, 4), new Good(Good.goods.get(8), 25, 4)));


    static TextView State2;

    static TextView What2;

    static TextView Who2;

    static TextView KolQ2;

    static RecyclerView Goodlist2;
    public static void  setAutomatView2(String state, String kolQ, String who, String what) {
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
        View view = inflater.inflate(R.layout.automatholder2, container, false);

        State2 = (TextView) view.findViewById(R.id.State2);

        What2 = (TextView) view.findViewById(R.id.What2);

        Who2 = (TextView) view.findViewById(R.id.Who2);

        KolQ2 = (TextView) view.findViewById(R.id.QueryKol2);

        Goodlist2 = (RecyclerView) view.findViewById(R.id.Goodlist2);
        GoodAdapter goodAdapter2 = new GoodAdapter(view.getContext(), goodsAutomat2);
        Goodlist2.setAdapter(goodAdapter2);
        return view;


    }

    public static void update(){
        System.out.println(State);
        State2.setText(State);
        KolQ2.setText(KolQ);
        Who2.setText(Who);
        What2.setText(What);

        for(int i=0;i<Goodlist2.getChildCount();i++){
            if(((GoodAdapter.ViewHolder)(Goodlist2.getChildViewHolder(Goodlist2.getChildAt(i)))).NameGood.getText().toString().compareTo(What)==0){
                int lastkol=Integer.parseInt(((GoodAdapter.ViewHolder)(Goodlist2.getChildViewHolder(Goodlist2.getChildAt(i)))).KolGood.getText()+"");
                if(lastkol!=0) {
                    ((GoodAdapter.ViewHolder) (Goodlist2.getChildViewHolder(Goodlist2.getChildAt(i)))).KolGood.setText((lastkol - 1)+"");
                }
            }

        }
    }
}
