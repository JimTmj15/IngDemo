package com.example.jimmy_pc.ingdemo.Utils.Network;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public class RetrofitClient {

    private static final String SERVER_URL = "https://api.myjson.com";
    private static final int CONN_TIMEOUT = 10;
    private Context context;

    public RetrofitClient(Context context){
        this.context = context;
    }

    /**
     *
     * This method is to create a retrofit client and
     * configure necessary params such as gson converter factory,
     * rx java adapter factory, server url etc
     *
     * @see ApiService
     * @return Return an observable
     */
    public ApiService apiServiceCall() {

        //Logging interceptor is created to intercept the network info
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        httpClient.connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS);


        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        ApiService service = retrofit.create(ApiService.class);

        return service;
    }
}
