package com.origen.greeny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.origen.greeny.Fragments.HomeFragment;
import com.origen.greeny.Fragments.MoreFragment;
import com.origen.greeny.Fragments.MyGardenFragment;
import com.origen.greeny.Fragments.ScanFragment;
import com.origen.greeny.Fragments.SearchFragment;
import com.origen.greeny.Utils.CheckInternet;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener{

    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new SearchFragment();
    //final Fragment fragment3 = new ScanFragment();
    final Fragment fragment4 = new MyGardenFragment();
    final Fragment fragment5 = new MoreFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottomNavigation);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.home, R.drawable.ic_home_black_24dp, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.search, R.drawable.ic_search_black_24dp, R.color.colorPrimary);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.my_garden, R.drawable.ic_spa_black_24dp, R.color.colorPrimary);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(R.string.settings, R.drawable.ic_format_list_bulleted_black_24dp, R.color.colorPrimary);


        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        //bottomNavigation.setColored(true);

        bottomNavigation.setAccentColor(Color.parseColor("#12218f"));


        //bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setTranslucentNavigationEnabled(true);
        bottomNavigation.setOnTabSelectedListener(this);
        fm.beginTransaction().add(R.id.mainFrame, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.mainFrame, fragment4, "4").hide(fragment4).commit();
        //fm.beginTransaction().add(R.id.mainFrame, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.mainFrame, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.mainFrame,fragment1, "1").commit();



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check for null
        if (result != null) {

            if (result.getContents() == null) {

            } else {
                if (CheckInternet.isOnline(this)){
                    Intent intent = new Intent(MainActivity.this, SoilActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("qrCode",result.getContents());
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"İnternet bağlantısı yoxdur!",Toast.LENGTH_SHORT).show();
                }
            }
        } else {

            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (position == 0){
            fm.beginTransaction().hide(active).show(fragment1).commit();
            active = fragment1;
        }else if (position == 1){
            fm.beginTransaction().hide(active).show(fragment2).commit();
            active = fragment2;
        }else if (position == 2){
            fm.beginTransaction().hide(active).show(fragment4).commit();
            active = fragment4;
        }else if (position == 3){
            fm.beginTransaction().hide(active).show(fragment5).commit();
            active = fragment5;
        }
        return true;
    }
}
