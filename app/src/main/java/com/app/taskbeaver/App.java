package com.app.taskbeaver;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ProcessLifecycleOwner;

import com.app.taskbeaver.managers.ActivityLifecycle;
import com.app.taskbeaver.managers.BackgroundListener;

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplication();
        ActivityLifecycle.init(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new BackgroundListener());
    }

    public static App getInstance(){
        return instance;
    }

    private void initApplication(){
        instance = this;
    }

    public static Context getAppContext(){
        return instance.getApplicationContext();
    }

}
