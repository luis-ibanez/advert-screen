package com.the3rocks.advertscreen.repository;

import com.the3rocks.advertscreen.domain.model.Advert;

public interface AdvertRepository {

    Advert getAdvert();

    Advert getAdvert(String advertId);

    void refreshAdvert();
}

