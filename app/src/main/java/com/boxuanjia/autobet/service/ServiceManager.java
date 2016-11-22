package com.boxuanjia.autobet.service;

import com.boxuanjia.autobet.model.login.LoginItem;
import com.boxuanjia.autobet.model.login.ResultItem;
import com.squareup.moshi.Moshi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by slomka.jin on 2016/11/22.
 */

public class ServiceManager {
    private static ServiceManager serviceManager;
    private Retrofit retrofit;
    private GaoService gaoService;

    public static ServiceManager instance(){
        if(serviceManager==null){
            serviceManager=new ServiceManager();
        }
        return serviceManager;
    }
    private ServiceManager(){
        Moshi moshi=new Moshi.Builder()
                .build();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging);
        retrofit=new Retrofit.Builder().baseUrl(WebApi.GAO_WEBSITE)
                .client(httpClient.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        gaoService=retrofit.create(GaoService.class);
    }

    public GaoService getApi(){
        return gaoService;
    }

}
