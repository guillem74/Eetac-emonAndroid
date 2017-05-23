package com.example.aleix.myapplication;

import com.example.aleix.myapplication.Entity.Eetakemon;
import com.example.aleix.myapplication.Entity.User;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by aleix on 23/05/2017.
 */

interface Service {

    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();



    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8081/EetakemonGo/")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build();

    @GET("/Eetakemon/{tipo}")
    Call<Eetakemon> eetak(@Path("tipo") String tipo);

    @POST("/User")
    Call<User> Login(@Path("tipo") User tipo); //CAMBIAR EL PATH
}
