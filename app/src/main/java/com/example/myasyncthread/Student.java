package com.example.myasyncthread;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    public static ArrayList<String> Names=new ArrayList<String>(Arrays.asList(new String[]{"Зоригто", "Батэрдэнэ", "Зарина", "Бэлигтэ", "Намто", "Буянта", "Байрта", "Кишиктя", "Олзятя", "Дугарма", "Арюнгэрэл", "Бадмагуро", "Дул", "Дара", "Султан", "Айдар", "Дондок", "Донир", "Доржожаб", "Аюша"}));
    String Name;
    int speedtime;
    ArrayList<Integer> goods=new ArrayList<>();

    public Student(String name, int good1, int good2, int good3,int speedtime) {
        Name = name;
        this.goods.add(good1);
        this.goods.add(good2);
        this.goods.add(good3);
        this.speedtime = speedtime;
    }

}
