package com.keller.xmlapp_zhule.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by keller on 2016/9/23.
 */
public class ToastUtils {
    /**
     * 可以在子线程中显示toast
     * @param context
     * @param text
     */
    public static void showToastSafe(final Context context, final String text){
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
