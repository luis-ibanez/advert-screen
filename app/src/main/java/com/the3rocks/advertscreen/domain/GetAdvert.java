package com.the3rocks.advertscreen.domain;

import android.support.annotation.NonNull;

import com.the3rocks.advertscreen.executor.PostExecutionThread;
import com.the3rocks.advertscreen.executor.ThreadExecutor;
import com.the3rocks.advertscreen.repository.AdvertRepository;

import javax.inject.Inject;

import rx.Observable;

import static dagger.internal.Preconditions.checkNotNull;

public class GetAdvert extends InteractorRX<GetAdvert.RequestValues>{

    private final AdvertRepository advertRepository;

    @Inject
    public GetAdvert(ThreadExecutor threadExecutor,
                     PostExecutionThread postExecutionThread,
                     @NonNull AdvertRepository advertRepository) {
        super(threadExecutor, postExecutionThread);
        this.advertRepository = checkNotNull(advertRepository, "advertRepository cannot be null!");
    }

    @Override
    public Observable buildUseCaseObservable(final GetAdvert.RequestValues requestValues) {
        if (requestValues.isForceUpdate()) {
            advertRepository.refreshAdvert();
        }

        return Observable.just(advertRepository.getAdvert());
    }

    public static final class RequestValues extends InteractorRX.RequestValues {
        private boolean forceUpdate;

        public RequestValues(boolean mForceUpdate) {
            this.forceUpdate = mForceUpdate;
        }

        public boolean isForceUpdate() {
            return forceUpdate;
        }
    }
}
