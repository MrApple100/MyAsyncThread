package com.example.myasyncthread;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.ViewHolder>{
    private int staticTag=0;
    private Context context;
    private  final LayoutInflater inflater;
    private ArrayList<Good> goods;



    GoodAdapter(Context context, ArrayList<Good> goods) {
        this.context=context;
        this.goods=goods;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public GoodAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.onegoodelement, parent, false) ;
        view.setTag(staticTag);
        staticTag++;

        return new GoodAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( GoodAdapter.ViewHolder holder, int position) {
        Good good = goods.get(position);
        holder.NameGood.setText(good.Name);
        holder.ValGood.setText(good.value+"");
        holder.KolGood.setText(good.count+"");


    }


    @Override
    public int getItemCount() {
        return goods.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView NameGood, ValGood, KolGood;

        ViewHolder(View view){
            super(view);
            NameGood = (TextView) view.findViewById(R.id.NameGood);
            ValGood = (TextView) view.findViewById(R.id.ValGood);
            KolGood = (TextView) view.findViewById(R.id.KolGood);


        }
    }
}

