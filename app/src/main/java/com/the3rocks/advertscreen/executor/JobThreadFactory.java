package com.the3rocks.advertscreen.executor;


import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

public class JobThreadFactory implements ThreadFactory {
    private static int counter = 0;

    @Override
    public Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable, "android_" + counter++);
    }
}
