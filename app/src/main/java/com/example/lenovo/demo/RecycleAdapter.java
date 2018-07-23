package com.example.lenovo.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecycleAdapter extends RecyclerView.Adapter {

    private List<String> imageUrlList;
    private Context context;

    RecycleAdapter(Context ctx, List<String> imageUrlList){
        context = ctx;
        this.imageUrlList = imageUrlList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(String.format(Locale.CHINA, "image %d", holder.getAdapterPosition()) );
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了" + holder.getAdapterPosition(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .centerInside()
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(context).load(imageUrlList.get(position)).apply(options).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageUrlList.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private CardView cardView;
        private ImageView imageView;

        private MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.card_view_text);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.card_view_image);
        }
    }
}
