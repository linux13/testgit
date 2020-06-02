package com.example.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class AdapterC extends RecyclerView.Adapter<AdapterC.Categori_Viewholder> {

    private String[] mCategoriName;
    private TypedArray mCategoriImagePath;
    private Context mContext;

    public AdapterC(String[] mCategoriName, TypedArray mCategoriImagePath, Context mContext) {
        this.mCategoriName = mCategoriName;
        this.mCategoriImagePath = mCategoriImagePath;
        this.mContext = mContext;
    }


    @Override
    public Categori_Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview, parent, false);

        Categori_Viewholder categori_viewholder = new Categori_Viewholder(view);

        return categori_viewholder;
    }

    @Override
    public void onBindViewHolder(Categori_Viewholder holder, int position) {

//        holder.card_imageview.setImageResource( mCategoriImagePath.getResourceId( position , -1 ) );
        Glide.with(mContext).load(mCategoriImagePath.getResourceId(position, -1))
                .into(holder.card_imageview);
        holder.card_text_view.setText(mCategoriName[position]);

    }

    @Override
    public int getItemCount() {
        return mCategoriName.length;
    }

    public class Categori_Viewholder extends RecyclerView.ViewHolder {

        public ImageView card_imageview;
        public TextView card_text_view;

        public Categori_Viewholder(@NonNull View itemView) {
            super(itemView);

            card_imageview = itemView.findViewById(R.id.category_image_id);
            card_text_view = itemView.findViewById(R.id.category_title_id);

        }

    }

    void helloworld(){

        
    }
}
