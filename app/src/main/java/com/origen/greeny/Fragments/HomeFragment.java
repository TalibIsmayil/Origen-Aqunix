package com.origen.greeny.Fragments;


import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.origen.greeny.Adapter.HomeAdapter;
import com.origen.greeny.Model.HomeModel;
import com.origen.greeny.Model.WeatherModel;
import com.origen.greeny.Networking.BASE_URL;
import com.origen.greeny.R;
import com.origen.greeny.SnackbarApp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<HomeModel> list = new ArrayList<>();
    private ProgressBar progressBar;

    private ImageView cloud;
    private TextView temp,humidity;

    private RelativeLayout weather;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        weather = view.findViewById(R.id.weather);
        cloud = view.findViewById(R.id.cloud);
        temp = view.findViewById(R.id.temp);
        humidity = view.findViewById(R.id.humidity);
        recyclerView = view.findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        progressBar = view.findViewById(R.id.common_statistics_progress);
//        HomeModel homeModel = new HomeModel("Tural Sufanzadə",
//                "https://images.freeimages.com/images/premium/previews/2274/22745971-farmer-picking-vegetables.jpg",
//                "https://extension.msstate.edu/sites/default/files/styles/flexslider_full/public/slideshow/IMG_3542.JPG?itok=KMe-9JU-",
//                "2 gün əvvəl",false,true,"Bu şərait pambıqda kök çürümə xəstəliyinin əmələ gəlməsini sürətləndirir.");
//        HomeModel homeModel2 = new HomeModel("Azər Abışov",
//                "https://dam.farmjournal.com/m/c645271f06ffc66/webimage-313510B2-3DB1-489A-8DDD9ABCCD4279D3.jpg",
//                "https://www.gardentech.com/-/media/Images/GardenTech-NA/US/blog/Keep-Your-Garden-Free-From-Fungal-Disease/Keep_Garden-Header.jpg",
//                "3 gün əvvəl",false,false,"Bu şərait pambıqda kök çürümə xəstəliyinin əmələ gəlməsini sürətləndirir.");
//        HomeModel homeModel3 = new HomeModel("Hüseyn Bağırov",
//                "https://non-gmoreport.com/wp-content/uploads/2019/02/farmer-field.jpg",
//                "https://www.thespruce.com/thmb/UDmqpou8xXJ6sXHTQ4hKGRQJD6M=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/SprucePlantSeries-307-fff49515547142019e91755bf0fc10ee.jpg",
//                "1 gün əvvəl",false,true,"Bu şərait pambıqda kök çürümə xəstəliyinin əmələ gəlməsini sürətləndirir.");
//        HomeModel homeModel4 = new HomeModel("Aytən Bağırova",
//                "https://media2.s-nbcnews.com/j/newscms/2019_43/3070091/191025-ariana-de-lena-asian-america-farms_e3e638462e1a4209480c3784aa270eed.fit-760w.jpg",
//                "https://cdn.britannica.com/03/147303-050-61055AF1/castor-oil-plant-cotyledons-leaves.jpg",
//                "5 gün əvvəl",true,false,"Bu şərait pambıqda kök çürümə xəstəliyinin əmələ gəlməsini sürətləndirir.");
//        HomeModel homeModel5 = new HomeModel("Talıb İsmayılzadə",
//                "https://www.yourdictionary.com/images/definitions/lg/4320.farmer.jpg",
//                "https://static01.nyt.com/images/2020/02/26/science/00SCI-METALFARM1/00SCI-METALFARM1-articleLarge.jpg?quality=75&auto=webp&disable=upscale",
//                "6 gün əvvəl",true,false,"Bu şərait pambıqda kök çürümə xəstəliyinin əmələ gəlməsini sürətləndirir.");
//        list.add(homeModel);
//        list.add(homeModel2);
//        list.add(homeModel3);
//        list.add(homeModel4);
//        list.add(homeModel5);
        Call<List<HomeModel>> call = BASE_URL.authServices.getMainList();
        call.enqueue(new Callback<List<HomeModel>>() {
            @Override
            public void onResponse(Call<List<HomeModel>> call, Response<List<HomeModel>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    Call<WeatherModel> s = BASE_URL.authServices.getWeather();
                    s.enqueue(new Callback<WeatherModel>() {
                        @Override
                        public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                            if (response.isSuccessful()) {
                                Glide.with(getActivity()).load(response.body().getImagelink()).into(cloud);
                                temp.setText(response.body().getTemp() +"°" + " " + response.body().getName() + ",AZ");
                                humidity.setText(response.body().getHumidity()+"%");

                                adapter = new HomeAdapter(getActivity(),list);
                                recyclerView.setAdapter(adapter);
                                progressBar.setVisibility(View.GONE);
                                weather.setVisibility(View.VISIBLE);
                                //SnackbarApp.error(getActivity(),getActivity().getString(R.string.app_name));
                            }
                            }

                        @Override
                        public void onFailure(Call<WeatherModel> call, Throwable t) {

                        }
                    });
                    //Data data = response.body().getData();
                    //fillArray(data);


                }else {
                    //fail();
                }
            }

            @Override
            public void onFailure(Call<List<HomeModel>> call, Throwable t) {

            }
        });

    }
}
