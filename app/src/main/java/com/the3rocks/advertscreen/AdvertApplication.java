package com.the3rocks.advertscreen;


import android.app.Application;

import com.the3rocks.advertscreen.di.components.ApplicationComponent;
import com.the3rocks.advertscreen.di.components.DaggerApplicationComponent;
import com.the3rocks.advertscreen.di.modules.ApplicationModule;

public class AdvertApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
