package com.example.lenovo.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecycleAdapter extends RecyclerView.Adapter {

    private int [] arrDataList = new int[30];
    private Context context = null;

    public RecycleAdapter(Context ctx){
        context = ctx;
        for (int i= 0 ; i< 30; i ++){
            arrDataList[i] = i;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder)holder).textView.setText("test--" + position);
        ((MyViewHolder)holder).cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了" + position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrDataList.length;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView = null;
        public CardView cardView = null;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.card_view_text);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
