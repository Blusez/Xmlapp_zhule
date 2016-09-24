package com.keller.xmlapp_zhule.util;

import android.os.Handler;

/**
 * Created by keller on 2016/9/23.
 */
public class ThreadUtils {
    /**子线程执行task**/
    public static void runInThread(Runnable task){
        new Thread(task).start();
    }
    /**
     * 主线程里面的一个handler
     */
    public static Handler mHandler = new Handler();
    /**UI线程执行task**/
    public static void runInUIThread(Runnable task){
        mHandler.post(task);
    }
}
