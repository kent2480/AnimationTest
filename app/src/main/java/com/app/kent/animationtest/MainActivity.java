package com.app.kent.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DisplayMetrics dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getActionBar().hide();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        initView();
        //getDeviceInfo();

    }

    private void getDeviceInfo() {



        // method 1
        int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

        Log.e(TAG, "1:  screenWidth =" + screenWidth + ", screenHeight =" +
                screenHeight);


        // method 2
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();

        float density  = dm.density;
        int densityDPI = dm.densityDpi;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        Log.e(TAG, "2: xdpi = " + xdpi + ", ydpi = " + ydpi);
        Log.e(TAG, "2:  density = " + density + ", densityDPI = " + densityDPI);

        screenWidth  = dm.widthPixels;
        screenHeight = dm.heightPixels;

        Log.e(TAG, "2: screenWidth = " + screenWidth + ", screenHeight = " + screenHeight);

        // method 3
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        density  = dm.density;
        densityDPI = dm.densityDpi;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;

        Log.e(TAG, "3:  xdpi = " + xdpi + ", ydpi = " + ydpi);
        Log.e(TAG, "3:  density = " + density + ", densityDPI = " + densityDPI);

        int screenWidthDip = dm.widthPixels;
        int screenHeightDip = dm.heightPixels;

        Log.e(TAG, "3: screenWidthDip = " + screenWidthDip + ", screenHeightDip = " +
                screenHeightDip);

        screenWidth  = (int)(dm.widthPixels * density + 0.5f);
        screenHeight = (int)(dm.heightPixels * density + 0.5f);

        Log.e(TAG, "3: screenWidth = " + screenWidth + ", screenHeight = " + screenHeight);

    }

    private ImageView blue;
    private void initView() {
        blue = (ImageView) findViewById(R.id.square_blue);
    }
}
