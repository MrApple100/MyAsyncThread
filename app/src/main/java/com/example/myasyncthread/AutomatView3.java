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

public class AutomatView3 extends Fragment {
    static String State = "Разогрев";
    static String KolQ = "подождите";
    static String Who = "подождите";
    static String What = "подождите";
    int Num = 3;

    ArrayList<Good> goodsAutomat3 = new ArrayList<>(Arrays.asList(new Good(Good.goods.get(9), 25, 4), new Good(Good.goods.get(0), 50, 4), new Good(Good.goods.get(1), 50, 4), new Good(Good.goods.get(2), 50, 4)));

    static TextView State3;

    static TextView What3;

    static TextView Who3;

    static TextView KolQ3;

    static RecyclerView Goodlist3;

    public static void  setAutomatView3(String state, String kolQ, String who, String what) {
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

        View view = inflater.inflate(R.layout.automatholder3, container, false);
        State3 = (TextView) view.findViewById(R.id.State3);

        What3 = (TextView) view.findViewById(R.id.What3);

        Who3 = (TextView) view.findViewById(R.id.Who3);

        KolQ3 = (TextView) view.findViewById(R.id.QueryKol3);

        Goodlist3 = (RecyclerView) view.findViewById(R.id.Goodlist3);

        GoodAdapter goodAdapter3 = new GoodAdapter(view.getContext(), goodsAutomat3);
        Goodlist3.setAdapter(goodAdapter3);
        return view;

    }

    public static void update() {
        System.out.println(State);
        State3.setText(State);
        KolQ3.setText(KolQ);
        Who3.setText(Who);
        What3.setText(What);

        for (int i = 0; i < Goodlist3.getChildCount(); i++) {
            if (((GoodAdapter.ViewHolder) (Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).NameGood.getText().toString().compareTo(What) == 0) {
                int lastkol = Integer.parseInt(((GoodAdapter.ViewHolder) (Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).KolGood.getText() + "");
                if (lastkol != 0) {
                    ((GoodAdapter.ViewHolder) (Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).KolGood.setText((lastkol - 1) + "");
                }
            }
        }
    }
}
