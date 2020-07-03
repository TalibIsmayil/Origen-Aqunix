package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.origen.greeny.Adapter.HomeAdapter;
import com.origen.greeny.Adapter.IotAdapter;
import com.origen.greeny.Model.HomeModel;
import com.origen.greeny.Model.IotModel;
import com.origen.greeny.Networking.BASE_URL;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IotActivity extends AppCompatActivity {

    private Switch aSwitch;
    private TextView ggdfg,onoff;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private IotAdapter adapter;
    private List<IotModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot);
        aSwitch = findViewById(R.id.searchIot);
        ggdfg = findViewById(R.id.ggdfg);
        onoff = findViewById(R.id.onoff);
        recyclerView = findViewById(R.id.iot_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.iot_progres);
        progressBar.setVisibility(View.INVISIBLE);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()){
                    onoff.setText("ON");
                    ggdfg.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    Call<List<IotModel>> call = BASE_URL.authServices.getMyIots();
                    call.enqueue(new Callback<List<IotModel>>() {
                        @Override
                        public void onResponse(Call<List<IotModel>> call, Response<List<IotModel>> response) {
                            if(response.isSuccessful()){
                                list = response.body();
                                adapter = new IotAdapter(IotActivity.this,list);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.GONE);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<IotModel>> call, Throwable t) {

                        }
                    });
                }else {
                    recyclerView.setVisibility(View.GONE);
                    onoff.setText("OFF");
                    ggdfg.setVisibility(View.VISIBLE);
                }
            }
        });



    }
}
