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

public class AutomatView4 extends Fragment {
    static String State = "Разогрев";
    static String KolQ = "подождите";
    static String Who = "подождите";
    static String What = "подождите";
    int Num = 4;

    ArrayList<Good> goodsAutomat4 = new ArrayList<>(Arrays.asList(new Good(Good.goods.get(2), 50, 4), new Good(Good.goods.get(6), 25, 4), new Good(Good.goods.get(8), 25, 4), new Good(Good.goods.get(3), 50, 4)));

    static TextView State4;

    static TextView What4;

    static TextView Who4;

    static TextView KolQ4;

    static RecyclerView Goodlist4;

    public static void  setAutomatView4(String state, String kolQ, String who, String what) {
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
        View view = inflater.inflate(R.layout.auotomatholder4, container, false);

        State4 = (TextView) view.findViewById(R.id.State4);

        What4 = (TextView) view.findViewById(R.id.What4);

        Who4 = (TextView) view.findViewById(R.id.Who4);

        KolQ4 = (TextView) view.findViewById(R.id.QueryKol4);

        Goodlist4 = (RecyclerView) view.findViewById(R.id.Goodlist4);

        GoodAdapter goodAdapter4 = new GoodAdapter(view.getContext(), goodsAutomat4);
        Goodlist4.setAdapter(goodAdapter4);

        return view;

    }

   public static void update(){
       System.out.println(State4);
       State4.setText(State);
       KolQ4.setText(KolQ);
       Who4.setText(Who);
       What4.setText(What);

       for(int i=0;i<Goodlist4.getChildCount();i++){
           if(((GoodAdapter.ViewHolder)(Goodlist4.getChildViewHolder(Goodlist4.getChildAt(i)))).NameGood.getText().toString().compareTo(What)==0){
               int lastkol=Integer.parseInt(((GoodAdapter.ViewHolder)(Goodlist4.getChildViewHolder(Goodlist4.getChildAt(i)))).KolGood.getText()+"");
               if(lastkol!=0) {
                   ((GoodAdapter.ViewHolder) (Goodlist4.getChildViewHolder(Goodlist4.getChildAt(i)))).KolGood.setText((lastkol - 1)+"");
               }

           }
       }
   }
}
