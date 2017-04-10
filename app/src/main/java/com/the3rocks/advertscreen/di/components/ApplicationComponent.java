package com.the3rocks.advertscreen.di.components;


import android.app.Application;
import android.content.Context;

import com.the3rocks.advertscreen.AdvertApplication;
import com.the3rocks.advertscreen.di.modules.ApplicationModule;
import com.the3rocks.advertscreen.di.modules.RepositoryModule;
import com.the3rocks.advertscreen.executor.PostExecutionThread;
import com.the3rocks.advertscreen.executor.ThreadExecutor;
import com.the3rocks.advertscreen.repository.AdvertRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                RepositoryModule.class
        })
public interface ApplicationComponent {

    /**
     * Injections for the dependencies
     */
    void inject(AdvertApplication app);

    void inject(Context context);

    /**
     * Used in child components
     */
    Application application();

    /**
     * Direct contact to UI thread
     */
    PostExecutionThread postExecutionThread();

    /**
     * Direct contact to Background thread
     */
    ThreadExecutor threadExecutor();

    /**
     * Direct contact to repo
     */
    AdvertRepository advertRepository();
}

