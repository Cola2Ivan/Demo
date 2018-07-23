package com.example.lenovo.demo.net;

import com.example.lenovo.demo.Font;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public  interface RetrofitApi {
    @GET("/utils/fontList")
    Call<Map<String,ArrayList<Font>>> getFontList();
}
