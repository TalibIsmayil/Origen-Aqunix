package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;


public class TestActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;

    private final String API_KEY = "3adc53da07c4451a87130afb5a734ade";
    private final String API_LINK = "https://yeich.cognitiveservices.azure.com/vision/v1.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        imageView = findViewById(R.id.visionImage);
        textView = findViewById(R.id.txt_result);
        button = findViewById(R.id.btn_process);

        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.zczx);
        imageView.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
