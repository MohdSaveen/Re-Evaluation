package com.example.evaluation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluation.Interface.ClickListener;
import com.example.evaluation.Models.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<ViewHolderClass> {

    private List<ResponseDTO> responseDTOArrayList=new ArrayList<>();
    private ClickListener clickListener;

    public AdapterClass(List<ResponseDTO> responseDTOArrayList, ClickListener clickListener) {
        this.responseDTOArrayList = responseDTOArrayList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolderClass(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {
        ResponseDTO data=responseDTOArrayList.get(position);
        holder.setData(data,clickListener);
    }

    @Override
    public int getItemCount() {
        return responseDTOArrayList.size();
    }

}
