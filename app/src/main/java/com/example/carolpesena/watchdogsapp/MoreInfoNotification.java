package com.example.carolpesena.watchdogsapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by PPGEB on 24/06/2017.
 */

public class MoreInfoNotification extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d("MoreInfoNotification", "not");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_info_notification);
    }


}
