package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.origen.greeny.Model.DetailModel;
import com.origen.greeny.Model.SearchModel;
import com.origen.greeny.Networking.BASE_URL;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ImageView detail_image;
    private Toolbar detail_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),getIntent().getStringExtra("check"));
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        if (getIntent() != null){
            String id = getIntent().getStringExtra("check");
            Log.d("fsfsdfsdfsd",id);
            Call<DetailModel> call = BASE_URL.authServices.detail(id);
            call.enqueue(new Callback<DetailModel>() {
                @Override
                public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {
                    if (response.isSuccessful()){
                        Log.d("dasdasdas",response.body().toString());
                        DetailModel d = response.body();
                        Log.d("dadasd",d.toString());

                    }
                }

                @Override
                public void onFailure(Call<DetailModel> call, Throwable t) {

                }
            });

        }


    }
}
