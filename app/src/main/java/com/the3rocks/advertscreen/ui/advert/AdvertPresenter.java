package com.the3rocks.advertscreen.ui.advert;

import android.support.annotation.NonNull;
import android.util.Log;

import com.the3rocks.advertscreen.R;
import com.the3rocks.advertscreen.domain.GetAdvert;
import com.the3rocks.advertscreen.domain.model.Attribute;
import com.the3rocks.advertscreen.domain.model.Advert;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

import static com.the3rocks.advertscreen.util.StringUtils.isNullOrEmpty;
import static dagger.internal.Preconditions.checkNotNull;

public class AdvertPresenter {

    private final GetAdvert getAdvert;
    private  View advertView;

    @Inject
    public AdvertPresenter(
            @NonNull GetAdvert getAdvert) {
        this.getAdvert = checkNotNull(getAdvert, "getAdvert cannot be null!");
    }

    public void start() {
        openAdvert();
    }

    public void onDestroyView() {
        getAdvert.unsubscribe();
    }

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("The view should be instantiated");
        }
        this.advertView = view;
    }

    private void openAdvert() {
        advertView.showLoading();
        GetAdvert.RequestValues requestValues = new GetAdvert.RequestValues(true);

        getAdvert.execute(requestValues,new Subscriber<Advert>() {
            @Override
            public void onCompleted() {
                advertView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                // The view may not be able to handle UI updates anymore
                if (!advertView.isReady()) {
                    return;
                }
                advertView.hideLoading();
                advertView.showError(R.string.error_loading_advert);
                Log.e(AdvertPresenter.class.getName(),e.getMessage());
            }

            @Override
            public void onNext(Advert advert) {
                if(advertView.isReady()){
                    advertView.hideLoading();
                    showAdvert(advert);
                }
            }
        });

    }

    private void showAdvert(@NonNull Advert advert) {
        String title = advert.getTitle();

        if (isNullOrEmpty(title)) {
            advertView.hideTitle();
        } else {
            advertView.showTitle(title);
        }

        List<String> images = advert.getPictures();

        if (images == null || images.size() == 0 ) {
            advertView.hideImages();
        } else {
            advertView.showImages(images);
        }

        List<Attribute> attributes = advert.getAttributes();

        if (attributes == null || attributes.size() == 0 ) {
            advertView.hideAttributes();
        } else {
            advertView.showAttributes(attributes);
        }

        String description = advert.getDescription();

        if (isNullOrEmpty(description)) {
            advertView.hideDescription();
        } else {
            advertView.showDescription(description);
        }

        String address = advert.getAddress();
        String price = advert.getPrice();

        if (isNullOrEmpty(address) && isNullOrEmpty(price)) {
            advertView.hideAddressLine();
        } else {
            advertView.showAddressLine(address, price);
        }

        String phone = advert.getPhone();
        String sms = advert.getSms();

        if(isNullOrEmpty(phone) && isNullOrEmpty(sms)){
            advertView.hideContact();
        }else{
            advertView.showContact(phone, sms);
        }

        boolean showMap = advert.isLocated();

        if(showMap){
            advertView.showMap(advert.getMapImageUrl());
        }else{
            advertView.hideMap();
        }

        advertView.showAdvertRef(advert.getId());

        advertView.setAdvertUrl(advert.getUrl());

        advertView.setContact(advert.getName());

        advertView.setPostingSince(advert.getPostingSince());

        advertView.showIsFavourite(advert.isFavourite());
    }


    public void changeFavourite() {
        //TODO: Not implemented
    }

    /**
     * View interface created to abstract the view
     * implementation used in this presenter.
     */
    public interface View {

        void hideLoading();

        void showLoading();

        void showError(int error);

        boolean isReady();

        void hideTitle();

        void showTitle(String title);

        void hideImages();

        void showImages(List<String> images);

        void hideAttributes();

        void showAttributes(List<Attribute> atributtes);

        void hideDescription();

        void showDescription(String description);

        void hideAddressLine();

        void showAddressLine(String address, String price);

        void hideContact();

        void showContact(String phone, String sms);

        void hideMap();

        void showMap(String mapImageUrl);

        void showIsFavourite(boolean isFavourite);

        void showAdvertRef(long advertId);

        void setAdvertUrl(String advertUrl);

        void setContact(String name);

        void setPostingSince(String postingSince);
    }
}
