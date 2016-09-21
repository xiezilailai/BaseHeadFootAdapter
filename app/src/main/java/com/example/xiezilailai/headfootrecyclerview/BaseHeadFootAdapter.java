package com.example.xiezilailai.headfootrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 19459 on 2016/9/21.
 */

/**
 * 如果你想让你的RecyclerView可以像listView一样
 *
 * 可以addHeaderView、addFooterView
 *
 * 直接将你的Adapter继承这个类即可
 */
public abstract class BaseHeadFootAdapter extends RecyclerView.Adapter {

    /**
     * Head布局的type值
     */
    private static final int HEAD_TYPE=-100;
    /**
     * Foot布局的type值
     */
    private static final int FOOT_TYPE=-101;
    /**
     * headerView
     */
    private View headerView;
    /**
     * footerView
     */
    private View footerView;


    /**
     * 将头部布局返回到用户继承之后的子类中，
     *
     * 用户可以这个方法里得到headerVIew，对其进行操作
     *
     * 比如说headerView中的各种点击事件以及headerView中各种控件的获取
     *
     *
     * @param headerView
     */
    protected abstract void onBindHeaderView(View headerView);

    /**
     * 将尾部布局返回到用户继承之后的子类中，
     *
     * 用户可以这个方法里得到footerVIew，对其进行操作
     *
     * 比如说headerView中的各种点击事件以及headerView中各种控件的获取
     *
     *
     * @param footerView
     */
    protected abstract void onBindFooterView(View footerView);

    /**
     * 获取子类中item的个数
     * @return
     */
    protected abstract int getItemNum();

    /**
     * 子类需继承的方法之一，和onBindViewHolder方法是一样的
     *
     * 在这里我进行了封装
     *
     *
     * @param holder
     * @param position
     */
    protected abstract void onBindView(RecyclerView.ViewHolder holder, int position);


    /**
     * 子类需继承的方法之一，和onCreateViewHolder一样
     *
     * 这里只是进行了封装
     *
     *
     * @param parent
     * @param viewType
     * @return
     */
    protected abstract RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType);
    /**
     * 添加HeaderVIew
     * @param view
     */
    public void addHeaderView(View view){
        headerView=view;
    }

    /**
     * 添加FooterView
     * @param view
     */
    public void addFooterView(View view){
        footerView=view;
    }


    /**
     * 实现Adapter中的方法
     *
     * 这里只是做一点封装
     *
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if(viewType==HEAD_TYPE){
           return  new HeadFooterViewHolder(headerView);
       }else if(viewType==FOOT_TYPE){
           return new HeadFooterViewHolder(footerView);
       }else //如果不是头布局和尾部局，那么就使用子类中的onCreateHolder方法中指定的ViewHolder
           return onCreateHolder(parent, viewType);
    }


    /**
     * 如果你使用的item有多种type，
     *
     * 那么你就需要继承这个方法，
     *
     * 并指明某个position是那种type，但不要使用-100和-101（已经被占用）
     *
     *
     * @param position
     * @return
     */
    protected  int getViewType(int position){
        return 0;
    };


    /**
     * item总数由头部布局和尾部布局和子类中item个数三者决定
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return getItemNum()+(headerView==null?0:1)+(footerView==null?0:1);
    }


    /**
     * 如果设置了头布局，那么position为0的时候type就是HEAD_TYPE
     *
     *
     * 此时要记得相对于子类中position差1
     *
     *
     * 设置了尾布局，那么position为最后一个时type就是FOOT_TYPE
     *
     *
     * 其他情况就取决于子类中的getVIewType（position）
     *
     *
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if(headerView!=null&&footerView==null){
            if(position==0)return HEAD_TYPE;
            else return getViewType(position-1);
        }else if(footerView!=null&&headerView==null){
            if(position==getItemCount()-1)return FOOT_TYPE;
            else return getViewType(position);
        }else if(footerView!=null&&headerView!=null){
            if(position==0)return HEAD_TYPE;
            else if(position==getItemCount()-1)return FOOT_TYPE;
            else return getViewType(position-1);
        }else{
            return getViewType(position);
        }
    }

    /**
     * 和getItemViewType一样
     *
     * 如果设置了头布局，那么position为0的时候onBindHeaderView
     *
     *
     * 设置了尾布局，那么position为最后一个时onBindFooterView
     *
     * 其他情况就取决于子类中的getVIewType（position）
     *
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //用户只加了headerView
        if(headerView!=null&&footerView==null){
            if(position==0){
                onBindHeaderView(headerView);
            }else{
                onBindView(holder,position-1);
            }
        }else if(headerView==null&&footerView!=null){
            if(position==getItemCount()-1){
                onBindFooterView(footerView);
            }else{
                onBindView(holder, position);
            }
        }else if(headerView!=null&&footerView!=null){
            if(position==0){
                onBindHeaderView(headerView);
            }else if(position==getItemCount()-1){
                onBindFooterView(footerView);
            }else{
                onBindView(holder,position-1);
            }
        }else{
            onBindView(holder, position);
        }
    }

    /**
     * 专门用来封装headerView和FooterView的viewHolder
     *
     *
     */
    private class HeadFooterViewHolder extends RecyclerView.ViewHolder{
         HeadFooterViewHolder(View itemView) {
            super(itemView);
        }
    }





}
