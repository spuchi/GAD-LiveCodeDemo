package com.example.gad.livedemoapp;

import android.app.Application;
import android.content.Context;

import com.example.gad.livedemoapp.domain.service.TaskService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskApplication extends Application
{
    private final static String TAG = "TODO_APP";
    private static TaskService mServiceClient;
    private static Context  mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppContext = getApplicationContext();
    }

    public static TaskService getServiceClient() {
        if (mServiceClient == null) {
            String base_url = getConfigValue(R.string.com_example_demoapp_config_remote_SERVICE_BASE_URL);

            mServiceClient = new Retrofit.Builder()
                                .baseUrl(base_url)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                                .create(TaskService.class);
        }

        return mServiceClient;
    }

    public static String getConfigValue(int key) {
        return mAppContext.getResources().getString(key);
    }

}
