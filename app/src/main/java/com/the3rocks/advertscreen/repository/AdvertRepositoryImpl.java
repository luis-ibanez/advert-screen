package com.the3rocks.advertscreen.repository;


import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.the3rocks.advertscreen.datasource.local.LocalAdvertProvider;
import com.the3rocks.advertscreen.domain.model.Advert;

import javax.inject.Inject;

import static dagger.internal.Preconditions.checkNotNull;

public class AdvertRepositoryImpl implements AdvertRepository{

    private final LocalAdvertProvider advertLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Advert cachedAdvert;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean cacheIsDirty = false;

    @Inject
    public AdvertRepositoryImpl(@NonNull LocalAdvertProvider advertLocalDataSource) {
        this.advertLocalDataSource = checkNotNull(advertLocalDataSource);
    }
    /**
     * Gets advert from cache or local data source , whichever is available first.
     * <p>
     */
    public Advert getAdvert() {

        // Respond immediately with cache if available and not dirty
        if (cachedAdvert != null && !cacheIsDirty) {
            return cachedAdvert;
        } else {
            return advertLocalDataSource.getAdvert();
        }
    }

    /**
     * Gets adverts from local data source.
     * <p>
     */
    public Advert getAdvert(@NonNull final String advertId) {
        checkNotNull(advertId);

        Advert cachedAdvert = getAdvert(advertId);
        // Respond immediately with cache if available
        if (cachedAdvert != null) {
            return cachedAdvert;
        }

        return advertLocalDataSource.getAdvert();
    }

    public void refreshAdvert() {
        cacheIsDirty = true;
    }

    @VisibleForTesting
    private void refreshCache(Advert advert) {
        cachedAdvert = advert;
        cacheIsDirty = false;
    }
}
