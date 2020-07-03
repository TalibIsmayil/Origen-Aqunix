package com.origen.greeny.Fragments;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.origen.greeny.Adapter.HomeAdapter;
import com.origen.greeny.Adapter.SearchAdapter;
import com.origen.greeny.Model.HomeModel;
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
public class SearchFragment extends Fragment implements MaterialSearchBar.OnSearchActionListener {

    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<SearchModel> list = new ArrayList<>();

    private MaterialSearchBar searchBar;

    private ProgressBar progressBar;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchBar = (MaterialSearchBar) view.findViewById(R.id.searchBar);
        progressBar = view.findViewById(R.id.prog);
        searchBar.setHint("Axtar");
        searchBar.setSpeechMode(false);
        //enable searchbar callbacks
        searchBar.setOnSearchActionListener(this);
        //restore last queries from disk
        //Inflate menu and setup OnMenuItemCl
        recyclerView = view.findViewById(R.id.searchPlantRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        SearchModel searchModel = new SearchModel("Pomidor",
//                "Fatmayı",
//                "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1557255932-the-sill-potted-plant-calathea-medallion-prospect-black-7-1500x-progressive-1557255913.jpg?crop=1.00xw:0.774xh;0,0.174xh&resize=480:*");
//        SearchModel searchModel2 = new SearchModel("Xiyar",
//                "Fatmayı",
//                "https://media.treehugger.com/assets/images/2019/12/bloomscape_peopleplants_red-prayer-plant-845x1024.jpg.860x0_q70_crop-smart.jpg");
//        SearchModel searchModel3 = new SearchModel("Pomidor",
//                "Fatmayı",
//                "https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red.png");
//        SearchModel searchModel4 = new SearchModel("Pomidor",
//                "Fatmayı",
//                "https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-5inch-in-Anna-ceramic-fuschia.png");
//        SearchModel searchModel5 = new SearchModel("Pomidor",
//                "Fatmayı",
//                "https://interiorplants.ca/wp-content/uploads/2018/01/maranta-red-6inch-HB-leaf-and-flowers-300x300.png");

        Call<List<SearchModel>> call = BASE_URL.authServices.search("");
        call.enqueue(new Callback<List<SearchModel>>() {
            @Override
            public void onResponse(Call<List<SearchModel>> call, Response<List<SearchModel>> response) {
                if (response.isSuccessful()) {
                    //Data data = response.body().getData();
                    //fillArray(data);
                    list = response.body();
                    adapter = new SearchAdapter(getActivity(),list);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                }else {
                    //fail();
                }
            }

            @Override
            public void onFailure(Call<List<SearchModel>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onSearchStateChanged(boolean enabled) {
        Call<List<SearchModel>> call = BASE_URL.authServices.search(searchBar.getText());
        call.enqueue(new Callback<List<SearchModel>>() {
            @Override
            public void onResponse(Call<List<SearchModel>> call, Response<List<SearchModel>> response) {
                if (response.isSuccessful()) {
                    //Data data = response.body().getData();
                    //fillArray(data);
                    list = response.body();
                    adapter = new SearchAdapter(getActivity(),list);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                    hideKeyboard(getActivity());

                }else {
                    //fail();
                }
            }

            @Override
            public void onFailure(Call<List<SearchModel>> call, Throwable t) {

            }
        });    }

    @Override
    public void onSearchConfirmed(CharSequence text) {
        hideKeyboard(getActivity()         );
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onButtonClicked(int buttonCode) {
    }
}
