package com.example.chaoice3240.firstactivity.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chaoice3240.firstactivity.R;

import org.w3c.dom.Text;

/**
 * Created by Admin on 2018/3/7.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] datas;
    public MyAdapter(String[] datas) {
        this.datas=datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView v= (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_cardview,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((TextView)holder.cardView.getChildAt(0)).setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView=cardView;
        }
    }

}
