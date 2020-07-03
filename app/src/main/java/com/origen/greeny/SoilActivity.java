package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SoilActivity extends AppCompatActivity {

    private ImageView anlyzeImage;
    private TextView anlyzeImageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil);

        anlyzeImage = findViewById(R.id.anlyzeImage);
        anlyzeImageText = findViewById(R.id.anlyzeImageName);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        anlyzeImage.setImageBitmap(bmp);
    }
}
