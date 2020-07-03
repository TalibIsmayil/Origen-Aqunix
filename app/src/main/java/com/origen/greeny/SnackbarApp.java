package com.origen.greeny;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarApp {

    private static Snackbar snack;


    public static void error(Activity activity, String text){

        snack = Snackbar.make(activity.findViewById(android.R.id.content),text, Snackbar.LENGTH_INDEFINITE);
        View view = snack.getView();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM);

        params.setMargins(Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8));
        view.setLayoutParams(params);

        TextView tv = view.findViewById(R.id.snackbar_text);
        tv.setSingleLine(true);

        tv.setTextColor(ContextCompat.getColor(activity, R.color.white));


        snack.getView().setBackground(activity.getDrawable(R.drawable.back_snackbar));
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error_red, 0);
        tv.setCompoundDrawablePadding(Common.convertDpToPixel(8));

        snack.setDuration(2000);
        snack.setActionTextColor(ContextCompat.getColor(activity, R.color.blue_light2));

        snack.show();

    }


    public static void disconnect(Activity activity,String text){

        snack = Snackbar.make(activity.findViewById(android.R.id.content),text, Snackbar.LENGTH_INDEFINITE);
        View view = snack.getView();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.BOTTOM);

        params.setMargins(Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8));
        view.setLayoutParams(params);

        TextView tv = view.findViewById(R.id.snackbar_text);
        tv.setSingleLine(true);

        tv.setTextColor(ContextCompat.getColor(activity, R.color.white));

        snack.getView().setBackground(activity.getDrawable(R.drawable.back_snackbar));
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error_red, 0);
        tv.setCompoundDrawablePadding(Common.convertDpToPixel(8));

        snack.setActionTextColor(ContextCompat.getColor(activity, R.color.blue_light2));

        snack.show();

    }


    public static void error(Activity activity,int textId){

        snack = Snackbar.make(activity.findViewById(android.R.id.content),activity.getString(textId), Snackbar.LENGTH_INDEFINITE);
        View view = snack.getView();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.BOTTOM);

        params.setMargins(Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8));
        view.setLayoutParams(params);

        TextView tv = view.findViewById(R.id.snackbar_text);
        tv.setSingleLine(true);
        tv.setTextColor(ContextCompat.getColor(activity, R.color.white));


        snack.getView().setBackground(activity.getDrawable(R.drawable.back_snackbar));
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error_red, 0);
        tv.setCompoundDrawablePadding(Common.convertDpToPixel(8));

        snack.setDuration(2000);
        snack.setActionTextColor(ContextCompat.getColor(activity, R.color.blue_light2));

        snack.show();

    }




    public static void succes(Activity activity,String text){

        snack = Snackbar.make(activity.findViewById(android.R.id.content),text, Snackbar.LENGTH_INDEFINITE);
        View view = snack.getView();
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.BOTTOM);

        params.setMargins(Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8),Common.convertDpToPixel(8));
        view.setLayoutParams(params);

        TextView tv = view.findViewById(R.id.snackbar_text);
        tv.setSingleLine(true);
        tv.setTextColor(ContextCompat.getColor(activity, R.color.white));


        snack.getView().setBackground(activity.getDrawable(R.drawable.back_snackbar));
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_green, 0);
        tv.setCompoundDrawablePadding(Common.convertDpToPixel(8));

        snack.setDuration(1000);
        snack.setActionTextColor(ContextCompat.getColor(activity, R.color.blue_light2));

        snack.show();

    }
}
