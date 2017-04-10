package com.the3rocks.advertscreen.di.components;


import android.app.Activity;

import com.the3rocks.advertscreen.di.modules.ActivityModule;
import com.the3rocks.advertscreen.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface AbstractActivityComponent {
    /**
     * Expose the activity to sub-graphs.
     */
    Activity activityContext();
}
