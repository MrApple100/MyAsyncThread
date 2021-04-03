package com.example.myasyncthread;

import java.util.ArrayList;
import java.util.Arrays;

public  class  Good {
    String Name;
    int value;
    int count;
   static ArrayList<String> goods = new ArrayList<String>(Arrays.asList(new String[]{"ColaCoca", "Hepsi", "Sright", "Panta", "Wrorter", "AlpenSilver", "Merkury", "Seekers", "Trinx", "MilkyDay"}));

    public Good(String name, int value, int count) {
        Name = name;
        this.value = value;
        this.count = count;
    }

}
