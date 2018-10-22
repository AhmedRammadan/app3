package com.example.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView title,descrpition;
    ImageView image;
    ItemClickListener itemClickListener;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title=itemView.findViewById(R.id.title);
        this.descrpition=itemView.findViewById(R.id.descrpition);
        this.image=itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(this);
    }


    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
}
