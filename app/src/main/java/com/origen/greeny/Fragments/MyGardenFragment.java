package com.origen.greeny.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.origen.greeny.Adapter.HomeAdapter;
import com.origen.greeny.Adapter.MyGardenAdapter;
import com.origen.greeny.Adapter.SearchAdapter;
import com.origen.greeny.Model.HomeModel;
import com.origen.greeny.Model.MyGardenModel;
import com.origen.greeny.Model.SearchModel;
import com.origen.greeny.Networking.BASE_URL;
import com.origen.greeny.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGardenFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyGardenAdapter adapter;
    private List<MyGardenModel> list = new ArrayList<>();

    private ProgressBar dgdfgd;


    public MyGardenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_garden, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.my_garden_recycler);
        dgdfgd = view.findViewById(R.id.dgdfgd);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        MyGardenModel myGardenModel = new MyGardenModel("https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png",
//                "Pomidor","Yubiley-60",1,1,1,1);
//        MyGardenModel myGardenModel2 = new MyGardenModel("https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png",
//                "Yemiş","Veteran",1,1,1,1);
//        MyGardenModel myGardenModel3 = new MyGardenModel("https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png",
//                "Qarpız","Mərcan",1,1,1,1);
//        MyGardenModel myGardenModel4 = new MyGardenModel("https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png",
//                "Yerkökü","Abşeronskaya",1,1,1,1);
//        MyGardenModel myGardenModel5 = new MyGardenModel("https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png",
//                "Pomidor","Yubiley-60",1,1,1,1);

        Call<List<MyGardenModel>> call = BASE_URL.authServices.getMyGarden();
        call.enqueue(new Callback<List<MyGardenModel>>() {
            @Override
            public void onResponse(Call<List<MyGardenModel>> call, Response<List<MyGardenModel>> response) {
                if (response.isSuccessful()) {
                    //Data data = response.body().getData();
                    //fillArray(data);
                    list = response.body();
                    adapter = new MyGardenAdapter(getActivity(),list);
                    recyclerView.setAdapter(adapter);
                    dgdfgd.setVisibility(View.GONE);

                }else {
                    //fail();
                }
            }

            @Override
            public void onFailure(Call<List<MyGardenModel>> call, Throwable t) {

            }
        });

    }
}
