package com.the3rocks.advertscreen.domain;


import com.the3rocks.advertscreen.executor.PostExecutionThread;
import com.the3rocks.advertscreen.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class InteractorRX<R extends InteractorRX.RequestValues> {

    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();

    protected InteractorRX(ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    /**
     * Builds an {@link rx.Observable} which will be used when executing the current {@link InteractorRX}.
     */
    protected abstract Observable buildUseCaseObservable(R requestValues);

    /**
     * Executes the current use case.
     *
     * @param useCaseSubscriber The guy who will be listen to the observable build
     * with {@link #buildUseCaseObservable(R requestValues)}.
     */
    @SuppressWarnings("unchecked")
    public void execute(R requestValues, Subscriber useCaseSubscriber) {
        this.subscription = this.buildUseCaseObservable(requestValues)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(useCaseSubscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * Data passed to a request.
     */
    public static abstract class RequestValues {
    }
}

