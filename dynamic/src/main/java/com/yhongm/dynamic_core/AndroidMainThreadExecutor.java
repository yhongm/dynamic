package com.yhongm.dynamic_core;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;

/**
 * Created by yhongm on 2017/03/09.
 */

public class AndroidMainThreadExecutor {
    public Executor getExecutor() {
        return new MainThreadExecutor();
    }

    static class MainThreadExecutor implements Executor {
        Handler handler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable command) {
            handler.post(command);
        }
    }
}
