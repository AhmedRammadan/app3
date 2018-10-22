package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {

    Context mcontext;
    ArrayList<Modle> modles,filterList;
    CustomFilter filter;

    Adapter(Context mcontext, ArrayList<Modle> modles) {
        this.mcontext = mcontext;
        this.modles = modles;
        this.filterList = modles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.modle,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.title.setText(modles.get(position).getTitle());
        holder.descrpition.setText(modles.get(position).getDescrpition());
        holder.image.setImageResource(modles.get(position).getImage());

        Animation animation = AnimationUtils.loadAnimation(mcontext, android.R.anim.slide_in_left);
        holder.itemView.setAnimation(animation);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String title =modles.get(position).getTitle();
                String desc =modles.get(position).getDescrpition();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.image.getDrawable();
                Bitmap bitmap =bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100, stream);
                byte[] bytes =stream.toByteArray();

                Intent intent =new Intent(mcontext,Details.class);
                intent.putExtra("iTitle",title);
                intent.putExtra("iDesc",desc);
                intent.putExtra("iImage",bytes);
                mcontext.startActivity(intent);
            }
        });

        /*holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (modles.get(position).getTitle().equals("Osama Abuzid")){
                    Toast.makeText(mcontext, "Osama Abuzid", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return modles.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter = new CustomFilter(filterList,this);
        }
        return filter;
    }

}
