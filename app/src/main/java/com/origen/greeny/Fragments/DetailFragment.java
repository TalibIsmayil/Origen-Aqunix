package com.origen.greeny.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.origen.greeny.Model.DetailModel;
import com.origen.greeny.Networking.BASE_URL;
import com.origen.greeny.R;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private Button add;

    private TextView common_statistics_title,common_statistics_subTitle;


    public DetailFragment() {
        //DetailFragment detailFragment = new DetailFragment();
        //Bundle.
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String index) {
        DetailFragment f = new DetailFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("index", index);
        f.setArguments(args);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        add = view.findViewById(R.id.add);
        common_statistics_title = view.findViewById(R.id.common_statistics_title);
        common_statistics_subTitle = view.findViewById(R.id.common_statistics_subTitle);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        Bundle args = getArguments();
        String index = args.getString("index");
        Call<DetailModel> call = BASE_URL.authServices.detail(index);
        call.enqueue(new Callback<DetailModel>() {
            @Override
            public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {
                if (response.isSuccessful()){
                    common_statistics_title.setText(response.body().getPlantTitle());
                    common_statistics_title.setText(response.body().getPlantDescription());
                    //Glide.with(getActivity()).load(response.body().getPlantPhoto()).into()
                }
            }

            @Override
            public void onFailure(Call<DetailModel> call, Throwable t) {

            }
        });

    }
}
