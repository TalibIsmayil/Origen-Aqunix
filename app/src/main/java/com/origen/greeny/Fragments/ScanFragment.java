package com.origen.greeny.Fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.origen.greeny.R;
import com.origen.greeny.ScanActivity;
import com.origen.greeny.SoilActivity;
import com.origen.greeny.TestActivity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment implements View.OnClickListener{

    private TextView tap_to_capture;
    private Button capture;

    private final String API_KEY = "3adc53da07c4451a87130afb5a734ade";
    private final String API_LINK = "https://yeich.cognitiveservices.azure.com/vision/v1.0";


    public ScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //tap_to_capture = view.findViewById(R.id.tap_to_capture);
        capture = view.findViewById(R.id.switch_flashlight);
        tap_to_capture = view.findViewById(R.id.tap_to_capture);

        //Typeface big_river = Typeface.createFromAsset(Objects.requireNonNull(getActivity()).getAssets(),"fonts/GothamBold.otf");
        //tap_to_capture.setTypeface(big_river);

        //tap_to_capture.setOnClickListener(this);
        //capture.setOnClickListener(this);
        //capture.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        //new IntentIntegrator(getActivity()).setCaptureActivity(ScanActivity.class).initiateScan();
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
