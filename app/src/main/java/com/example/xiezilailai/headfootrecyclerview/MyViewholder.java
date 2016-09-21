package com.example.xiezilailai.headfootrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 19459 on 2016/9/21.
 */

public class MyViewholder extends RecyclerView.ViewHolder {

    public TextView bigText;
    public TextView smallText;
    public MyViewholder(View itemView) {
        super(itemView);
        bigText= (TextView) itemView.findViewById(R.id.big_text);
        smallText= (TextView) itemView.findViewById(R.id.small_text);
    }
}
