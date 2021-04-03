package com.example.myasyncthread;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

public class MainActivity extends FragmentActivity {


    class MessagetoAsync {
        public ArrayList<Integer> studentsNum;
        public int NumAutomat;

        public MessagetoAsync(ArrayList<Integer> students, int numAutomat) {
            this.studentsNum = students;
            NumAutomat = numAutomat;
        }
    }


    ArrayList<Student> students = new ArrayList<>();


    Handler handlerupdate;
    Handler handlerend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AutomatView1 automatView1=new AutomatView1();
        AutomatView2 automatView2=new AutomatView2();
        AutomatView3 automatView3=new AutomatView3();
        AutomatView4 automatView4=new AutomatView4();
        ft.add(R.id.Framelayout,automatView1);
        ft.add(R.id.Framelayout,automatView2);
        ft.add(R.id.Framelayout,automatView3);
        ft.add(R.id.Framelayout,automatView4);
        ft.commit();

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


        handlerupdate = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Bundle bundle = msg.getData();

                Student student = students.get(bundle.getInt("numofstudent"));
                switch (bundle.getInt("NumAutomat")) {
                    case 1:
                        AutomatView1.setAutomatView1("Продает", bundle.getInt("kolQ") + "", bundle.getString("studentname"), Good.goods.get(student.goods.get(bundle.getInt("j"))));
                        AutomatView1.update();
                        break;
                    case 2:
                        AutomatView2.setAutomatView2("Продает", bundle.getInt("kolQ") + "", bundle.getString("studentname"), Good.goods.get(student.goods.get(bundle.getInt("j"))));
                        AutomatView2.update();
                        break;
                    case 3:
                        AutomatView3.setAutomatView3("Продает", bundle.getInt("kolQ") + "", bundle.getString("studentname"), Good.goods.get(student.goods.get(bundle.getInt("j"))));
                        AutomatView3.update();
                        break;
                    case 4:
                        AutomatView4.setAutomatView4("Продает", bundle.getInt("kolQ") + "", bundle.getString("studentname"), Good.goods.get(student.goods.get(bundle.getInt("j"))));
                        AutomatView4.update();
                        break;
                }

                System.out.println("END");
            }

        };
            handlerend=new Handler() {
                @Override
                public void handleMessage (@NonNull Message msg){
                    super.handleMessage(msg);
                    System.out.println(msg.what);
                            switch (msg.what) {
                                case 1:
                                    AutomatView1.setAutomatView1("Прохлаждается", "нет никого", "пусто", " ");
                                    AutomatView1.update();
                                    break;
                                case 2:
                                    AutomatView2.setAutomatView2("Прохлаждается", "нет никого", "пусто", " ");
                                    AutomatView2.update();
                                    break;
                                case 3:
                                    AutomatView3.setAutomatView3("Прохлаждается", "нет никого", "пусто", " ");
                                    AutomatView3.update();
                                    break;
                                case 4:
                                    AutomatView4.setAutomatView4("Прохлаждается", "нет никого", "пусто", " ");
                                    AutomatView4.update();
                                    break;
                            }
                    System.out.println("END");
                }
            };

            ArrayList<Integer> queue = new ArrayList<>();
        for(
            int j = 0;
            j< 5;j++)

            {
                queue.add(j);
            }

            MyAutomatAsync myAutomatAsync1 = new MyAutomatAsync(new MessagetoAsync(queue, 1));
        myAutomatAsync1.start();
            queue =new ArrayList<>();
        for(
            int j = 5;
            j< 10;j++)

            {
                queue.add(j % 5, j);
            }

            MyAutomatAsync myAutomatAsync2 = new MyAutomatAsync(new MessagetoAsync(queue, 2));
        myAutomatAsync2.start();
            queue =new ArrayList<>();
        for(
            int j = 10;
            j< 15;j++)

            {
                queue.add(j % 5, j);
            }

            MyAutomatAsync myAutomatAsync3 = new MyAutomatAsync(new MessagetoAsync(queue, 3));
        myAutomatAsync3.start();
            queue =new ArrayList<>();
        for(
            int j = 15;
            j< 20;j++)

            {
                queue.add(j % 5, j);
            }

            MyAutomatAsync myAutomatAsync4 = new MyAutomatAsync(new MessagetoAsync(queue, 4));
        myAutomatAsync4.start();


        }


        @Deprecated
        private class MyAutomatAsync extends Thread {
            MessagetoAsync queueandnum;

            public MyAutomatAsync(MessagetoAsync queueandnum) {
                this.queueandnum = queueandnum;
            }

            @Override
            public void run() {
                int kolQ = queueandnum.studentsNum.size();
                int NumAutomat = queueandnum.NumAutomat;
                for (int i = 0; i < kolQ; i++) {
                    Student student = students.get(queueandnum.studentsNum.get(i));
                    for (int j = 0; j < 3; j++) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("numofsrudent", queueandnum.studentsNum.get(i));
                        bundle.putInt("kolQ", (kolQ - i));
                        bundle.putString("studentname", student.Name);
                        bundle.putInt("j", j);
                        bundle.putInt("NumAutomat", NumAutomat);
                        Message message = new Message();
                        message.setData(bundle);
                        handlerupdate.sendMessage(message);
                        //симулируем задержку
                        try {
                            Thread.sleep(student.speedtime * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                handlerend.sendEmptyMessage(NumAutomat);
            }

        }
}