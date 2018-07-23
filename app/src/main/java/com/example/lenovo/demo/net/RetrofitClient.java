package com.example.lenovo.demo.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private RetrofitClient(){ }

    private Retrofit init(){
        return new Retrofit.Builder()
                .baseUrl("www.postprint.com.cn")
                .client(new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.MILLISECONDS).build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void request(){
        RetrofitApi api = init().create(RetrofitApi.class);
        Call call = api.getFontList();
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
