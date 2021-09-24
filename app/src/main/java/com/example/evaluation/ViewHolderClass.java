package com.example.evaluation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evaluation.Fragments.SneakerFragment;
import com.example.evaluation.Interface.ClickListener;
import com.example.evaluation.Models.ResponseDTO;

public class ViewHolderClass extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView mTvName;
    private TextView mTvPrice;
    private ClickListener clickListener;

    public ViewHolderClass(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
        initViews(itemView);

    }

    private void initViews(View itemView) {
        mTvName=itemView.findViewById(R.id.item_name);
        mTvPrice=itemView.findViewById(R.id.item_Price);
        imageView=itemView.findViewById(R.id.item_Image);
    }

    public void setData(ResponseDTO responseDTO,ClickListener clickListener){
        mTvName.setText(responseDTO.getName());
        mTvPrice.setText("$"+responseDTO.getRetailPrice()+" ");
        Glide.with(imageView).load(responseDTO.getMedia().getImageUrl()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClicked(responseDTO,getAdapterPosition());
            }
        });
    }
}
