package com.example.myasyncthread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    class MessagetoAsync {
        public ArrayList<Integer> studentsNum;
        public int NumAutomat;

        public MessagetoAsync(ArrayList<Integer> students, int numAutomat) {
            this.studentsNum = students;
            NumAutomat = numAutomat;
        }
    }

    TextView State1;
    TextView State2;
    TextView State3;
    TextView State4;

    TextView What1;
    TextView What2;
    TextView What3;
    TextView What4;

    TextView Who1;
    TextView Who2;
    TextView Who3;
    TextView Who4;

    TextView KolQ1;
    TextView KolQ2;
    TextView KolQ3;
    TextView KolQ4;

    RecyclerView Goodlist1;
    RecyclerView Goodlist2;
    RecyclerView Goodlist3;
    RecyclerView Goodlist4;

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> goods = new ArrayList<String>(Arrays.asList(new String[]{"ColaCoca", "Hepsi", "Sright", "Panta", "Wrorter", "AlpenSilver", "Merkury", "Seekers", "Trinx", "MilkyDay"}));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        State1 = (TextView) findViewById(R.id.State1);
        State2 = (TextView) findViewById(R.id.State2);
        State3 = (TextView) findViewById(R.id.State3);
        State4 = (TextView) findViewById(R.id.State4);

        What1 = (TextView) findViewById(R.id.What1);
        What2 = (TextView) findViewById(R.id.What2);
        What3 = (TextView) findViewById(R.id.What3);
        What4 = (TextView) findViewById(R.id.What4);

        Who1 = (TextView) findViewById(R.id.Who1);
        Who2 = (TextView) findViewById(R.id.Who2);
        Who3 = (TextView) findViewById(R.id.Who3);
        Who4 = (TextView) findViewById(R.id.Who4);

        KolQ1 = (TextView) findViewById(R.id.QueryKol1);
        KolQ2 = (TextView) findViewById(R.id.QueryKol2);
        KolQ3 = (TextView) findViewById(R.id.QueryKol3);
        KolQ4 = (TextView) findViewById(R.id.QueryKol4);

        Goodlist1 = (RecyclerView) findViewById(R.id.Goodlist1);
        Goodlist2 = (RecyclerView) findViewById(R.id.Goodlist2);
        Goodlist3 = (RecyclerView) findViewById(R.id.Goodlist3);
        Goodlist4 = (RecyclerView) findViewById(R.id.Goodlist4);

        for (int i = 0; i < 20; i++) {
            Random random = new Random(i);
            int r1 = random.nextInt(10);
            int r2 = 0;
            do {
                r2 = random.nextInt(10);
            } while (r2 == r1);
            int r3 = 0;
            do {
                r3 = random.nextInt(10);
            } while (r3 == r2 || r3 == r1);
            int speedtime = random.nextInt(5) + 1;
            students.add(new Student(Student.Names.get(i), r1, r2, r3, speedtime));
        }

        ArrayList<Good> goodsAutomat1 = new ArrayList<>(Arrays.asList(new Good(goods.get(1), 50, 4), new Good(goods.get(2), 50, 4), new Good(goods.get(3), 50, 4), new Good(goods.get(4), 50, 4)));
        ArrayList<Good> goodsAutomat2 = new ArrayList<>(Arrays.asList(new Good(goods.get(5), 50, 4), new Good(goods.get(6), 25, 4), new Good(goods.get(7), 25, 4), new Good(goods.get(8), 25, 4)));
        ArrayList<Good> goodsAutomat3 = new ArrayList<>(Arrays.asList(new Good(goods.get(9), 25, 4), new Good(goods.get(0), 50, 4), new Good(goods.get(1), 50, 4), new Good(goods.get(2), 50, 4)));
        ArrayList<Good> goodsAutomat4 = new ArrayList<>(Arrays.asList(new Good(goods.get(2), 50, 4), new Good(goods.get(6), 25, 4), new Good(goods.get(8), 25, 4), new Good(goods.get(3), 50, 4)));
        GoodAdapter goodAdapter1 = new GoodAdapter(this, goodsAutomat1);
        Goodlist1.setAdapter(goodAdapter1);
        GoodAdapter goodAdapter2 = new GoodAdapter(this, goodsAutomat2);
        Goodlist2.setAdapter(goodAdapter2);
        GoodAdapter goodAdapter3 = new GoodAdapter(this, goodsAutomat3);
        Goodlist3.setAdapter(goodAdapter3);
        GoodAdapter goodAdapter4 = new GoodAdapter(this, goodsAutomat4);
        Goodlist4.setAdapter(goodAdapter4);
        ArrayList<Integer> queue = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            queue.add(j);
        }
        new MyAutomatAsync().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MessagetoAsync(queue, 1));
        queue = new ArrayList<>();
        for (int j = 5; j < 10; j++) {
            queue.add(j % 5, j);
            System.out.println(j % 5);
        }
        new MyAutomatAsync().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MessagetoAsync(queue, 2));
        queue = new ArrayList<>();
        for (int j = 10; j < 15; j++) {
            queue.add(j % 5, j);
        }
        new MyAutomatAsync().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MessagetoAsync(queue, 3));
        queue = new ArrayList<>();
        for (int j = 15; j < 20; j++) {
            queue.add(j % 5, j);
        }
        new MyAutomatAsync().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MessagetoAsync(queue, 4));
    }


    @Deprecated
    private class MyAutomatAsync extends AsyncTask<Object, Integer, Integer> {
        class Automat{
            String State;
            String KolQ;
            String Who;
            String What;
            int Num;

            public Automat(String state, String kolQ, String who, String what, int num) {
                State = state;
                KolQ = kolQ;
                Who = who;
                What = what;
                Num = num;
            }
            public void updateView(){
                switch (Num){
                    case 1:
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

                        break;
                    case 2:
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
                        break;
                    case 3:
                        State3.setText(State);
                        KolQ3.setText(KolQ);
                        Who3.setText(Who);
                        What3.setText(What);
                        for(int i=0;i<Goodlist3.getChildCount();i++){
                            if(((GoodAdapter.ViewHolder)(Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).NameGood.getText().toString().compareTo(What)==0){
                                int lastkol=Integer.parseInt(((GoodAdapter.ViewHolder)(Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).KolGood.getText()+"");
                                if(lastkol!=0) {
                                    ((GoodAdapter.ViewHolder) (Goodlist3.getChildViewHolder(Goodlist3.getChildAt(i)))).KolGood.setText((lastkol - 1)+"");
                                }
                            }
                        }
                        break;
                    case 4:
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
                        break;
                }
            }
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Integer doInBackground(Object... queueandnum) {
            Automat automat;
            int kolQ=((MessagetoAsync)queueandnum[0]).studentsNum.size();
            int NumAutomat=((MessagetoAsync)queueandnum[0]).NumAutomat;
            for(int i=0;i<kolQ;i++){
                System.out.println(i+" "+NumAutomat);
                System.out.println(((MessagetoAsync)queueandnum[0]).studentsNum.get(i));
                Student student=students.get(((MessagetoAsync)queueandnum[0]).studentsNum.get(i));
                for(int j=0;j<3;j++) {
                    automat = new Automat("Продает", (kolQ - i)+"", student.Name,goods.get(student.goods.get(j)), NumAutomat);
                    automat.updateView();
                    try {
                        Thread.sleep(student.speedtime*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

            return NumAutomat;
        }

        @Override
        protected void onPostExecute(Integer num) {
            super.onPostExecute(num);

            Automat automat = new Automat("Прохлаждается", "нет никого", "пусто"," ", num.intValue());
            automat.updateView();
        }
    }
}