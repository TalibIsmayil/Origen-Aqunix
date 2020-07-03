package com.origen.greeny;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
    private static String TAG = "Common";

    public static String getDeviceName() {

        Log.e(TAG, "getDeviceName: " + Build.MANUFACTURER +" "+ Build.MODEL);

        return Build.MANUFACTURER +" "+ Build.MODEL;
    }


    public static String getDeviceId(Activity activity) {

        String androidId = Settings.Secure.getString(activity.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.e(TAG, "getDeviceId: " + androidId);

        return androidId;
    }


    //email regex-----------------------------------------------------------------------------------
    public static boolean isEmailValid(Activity activity, TextInputLayout til) {
        String text = til.getEditText().getText().toString();

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if(text.length()==0){
            til.setError("email not found");
            return false;
        }else if(!matcher.matches()) {
            til.setError("fail email");
            return false;
        }
        til.setErrorEnabled(false);
        til.setError(null);
        return true;
    }
    //----------------------------------------------------------------------------------------------

    //email regex-----------------------------------------------------------------------------------
    public static boolean isEtLength(Activity activity,TextInputLayout til, int length) {
        String text = til.getEditText().getText().toString();

        if(text.length()==0){
            til.setError("pin not found");
            return false;
        }else if(text.trim().length()!=length ) {
            til.setError("4 number");
            return false;
        }
        til.setErrorEnabled(false);
        til.setError(null);
        return true;
    }
    //----------------------------------------------------------------------------------------------

    //dp convert pixsel-----------------------------------------------------------------------------
    public static int convertDpToPixel(int dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        int px = (int) (dp * (metrics.densityDpi / 160f));
        return Math.round(px);
    }
    //----------------------------------------------------------------------------------------------

    //Check empty-----------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------


    //et ChangeListener-----------------------------------------------------------------------------
    public static boolean etIsSetable(TextInputLayout til){
        int maxLength = til.getCounterMaxLength();
        String text = til.getEditText().getText().toString();
        if(text.trim().length()>2 && text.length()<=maxLength)return true;

        return false;
    }

    public static void etSetError(TextInputLayout til){
        int maxLength = til.getCounterMaxLength();
        String text = til.getEditText().getText().toString();

        if (text.trim().length() == 0){
            til.setError("This field empty");
        }else if(text.trim().length()>2 && text.length()<=maxLength){
            til.setErrorEnabled(false);
            til.setError(null);
        }
    }

    public static void etChangeListener(Activity activity, final TextInputLayout til){
        final int maxLength = til.getCounterMaxLength();

        til.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()>0 && s.toString().trim().length()<=2){
//                    til.setError(activity.getString(R.string.not_define));
                    til.setError("more 2");
                }else if(s.length()>maxLength) {
//                    til.setError(activity.getString(R.string.not_define));
                    til.setError("less "+maxLength);
                }else{
                    til.setErrorEnabled(false);
                    til.setError(null);
                }
            }
        });

    }
    //----------------------------------------------------------------------------------------------


    //-jide keyboard--------------------------------------------------------------------------------
    public static void hideKeyboard(Activity activity, EditText et) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    public static void showKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }
    public static boolean keyboardIsShow(View contentView){
        Rect r = new Rect();
        contentView.getWindowVisibleDisplayFrame(r);
        int screenHeight = contentView.getRootView().getHeight();
        int keypadHeight = screenHeight - r.bottom;


        if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is perhaps enough to determine keypad height.
            return true;

        } else {
            // keyboard is closed
            return false;
        }
    }
}
