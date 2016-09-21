package com.example.xiezilailai.headfootrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyBaseHeadFootAdapter adapter;
    private List<Data>list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View headView= LayoutInflater.from(this).inflate(R.layout.layout_head,null);
        View footView= LayoutInflater.from(this).inflate(R.layout.layout_foot,null);


        ListView listView;

        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        for(int i=0;i<20;i++){
            list.add(new Data("big text "+i,"small text "+i));
        }
        adapter=new MyBaseHeadFootAdapter(this,list);
        adapter.addHeaderView(headView);
        adapter.addFooterView(footView);
        recyclerView.setAdapter(adapter);

    }


}
