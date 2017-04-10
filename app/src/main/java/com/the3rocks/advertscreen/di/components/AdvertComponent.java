package com.the3rocks.advertscreen.di.components;


import com.the3rocks.advertscreen.di.modules.ActivityModule;
import com.the3rocks.advertscreen.di.scopes.ActivityScope;
import com.the3rocks.advertscreen.ui.advert.AdvertActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class
        })
public interface AdvertComponent extends AbstractActivityComponent {
    void inject(AdvertActivity advertActivity);
}
