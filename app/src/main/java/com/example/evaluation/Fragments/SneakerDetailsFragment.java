package com.example.evaluation.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluation.R;


public class SneakerDetailsFragment extends Fragment {

    private TextView mTvBrandName;
    private TextView mTvReleaseYear;
    private TextView mTvPrice;
    private TextView mTvName;
    private ImageView mIvDetails;
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
        return inflater.inflate(R.layout.fragment_sneaker_details, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        Bundle bundle=this.getArguments();
        mTvName.setText(bundle.getString("brand"));
        mTvBrandName.setText(bundle.getString("brand"));
        mTvPrice.setText("$"+bundle.getInt("price")+" ");
        mTvReleaseYear.setText(bundle.getInt("year")+" ");
        Glide.with(mIvDetails).load(bundle.getString("image")).into(mIvDetails);
    }
    private void initViews(View view) {
        mIvDetails=view.findViewById(R.id.ivDetail);
        mTvBrandName=view.findViewById(R.id.tvBrandName);
        mTvName=view.findViewById(R.id.tvName);
        mTvPrice=view.findViewById(R.id.tvPrice);
        mTvReleaseYear=view.findViewById(R.id.tvReleaseYear);
    }
}