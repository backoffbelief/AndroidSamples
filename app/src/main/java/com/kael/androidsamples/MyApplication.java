package com.kael.androidsamples;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hanyuanliang on 16/5/9.
 */
public class MyApplication extends Application {
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(this);
    }

    public static <T> void add2Queue(Object tag, Request<T> request){
        request.setTag(tag);
        queue.add(request);
    }
}
