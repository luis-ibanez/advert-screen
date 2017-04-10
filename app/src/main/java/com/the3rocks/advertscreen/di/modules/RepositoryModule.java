package com.the3rocks.advertscreen.di.modules;

import com.the3rocks.advertscreen.repository.AdvertRepository;
import com.the3rocks.advertscreen.repository.AdvertRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public AdvertRepository providesAdvertRepository(AdvertRepositoryImpl advertRepository) {
        return advertRepository;
    }
}
