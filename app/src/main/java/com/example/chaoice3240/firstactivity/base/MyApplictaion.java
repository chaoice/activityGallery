package com.example.chaoice3240.firstactivity.base;

import android.app.Application;
import android.content.Context;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by Admin on 2018/3/22.
 */


public class MyApplictaion extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Iconify.with(new FontAwesomeModule());
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
