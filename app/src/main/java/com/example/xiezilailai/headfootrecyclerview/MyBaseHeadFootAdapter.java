package com.example.xiezilailai.headfootrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 19459 on 2016/9/21.
 */

public class MyBaseHeadFootAdapter extends BaseHeadFootAdapter {

    private Context context;
    private List<Data>list;

    public MyBaseHeadFootAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    protected void onBindHeaderView(View headerView) {
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"head was clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onBindFooterView(View footerView) {
//        footerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,"foot was clicked",Toast.LENGTH_SHORT).show();
//            }
//        });
    }



    @Override
    protected int getItemNum() {
        return list.size();
    }



    @Override
    protected void onBindView(RecyclerView.ViewHolder holder, final int position) {
        MyViewholder viewholder= (MyViewholder) holder;
        viewholder.bigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"big text "+position+"was clicked",Toast.LENGTH_SHORT).show();
            }
        });
        viewholder.bigText.setText(list.get(position).getBigText());
        viewholder.smallText.setText(list.get(position).getSmallText());
    }

    @Override
    public MyViewholder onCreateHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null);
        return new MyViewholder(view);
    }
}
