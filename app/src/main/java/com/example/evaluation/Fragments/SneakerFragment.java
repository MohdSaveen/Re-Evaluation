package com.example.evaluation.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluation.AdapterClass;
import com.example.evaluation.Interface.ApiServices;
import com.example.evaluation.Interface.ClickListener;
import com.example.evaluation.Models.ResponseDTO;
import com.example.evaluation.Network;
import com.example.evaluation.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SneakerFragment extends Fragment implements ClickListener {

    private List<ResponseDTO> responseDTOArrayList=new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sneaker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        fetchData();
        setRecycler();
    }

    private void setRecycler() {
        LinearLayoutManager linearLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterClass=new AdapterClass(responseDTOArrayList,this::onClicked);
        recyclerView.setAdapter(adapterClass);
    }

    private void initViews(View view) {
        recyclerView=view.findViewById(R.id.recyclerView);
        navController= Navigation.findNavController(view);
    }

    public void fetchData(){
        ApiServices apiServices= Network.getInstance().create(ApiServices.class);
        Call<List<ResponseDTO>> call=apiServices.getData();
        call.enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if (response.body() != null) {
                    responseDTOArrayList.addAll(response.body());
                    adapterClass.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public  void onClicked(ResponseDTO responseDTO,int position) {


        Bundle bundle=new Bundle();
        bundle.putString("brand", responseDTO.getBrand());
        bundle.putString("name",responseDTO.getName());
        bundle.putInt("price",responseDTO.getRetailPrice());
        bundle.putInt("year",responseDTO.getYear());
        bundle.putString("image",responseDTO.getMedia().getImageUrl());
        navController.navigate(R.id.action_sneakerFragment_to_sneakerDetailsFragment,bundle);


    }
}