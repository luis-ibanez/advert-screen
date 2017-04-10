package com.the3rocks.advertscreen.executor;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
