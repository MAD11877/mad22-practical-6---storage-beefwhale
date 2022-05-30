package com.example.madpractical;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    /**
     * Create references to the views in viewholder
     */
    TextView name;
    TextView desc;
    ImageView img;
    ImageView bigimg;
    View viewItem;
    public ListViewHolder(View item){
        super(item);
        viewItem = item;
        name = item.findViewById(R.id.name);
        desc = item.findViewById(R.id.desc);
        img = item.findViewById(R.id.img);
        bigimg = item.findViewById(R.id.bigimg);

    }

}
