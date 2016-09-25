package com.example.boombz.myapplication.Service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by boombz on 23/09/16.
 */
public class ServiceGenerator {

    //private static final String BASE_URL = "http://192.168.1.90:3000/api/";
    private static final String IP_ADDRESS = "192.168.1.3";
    private static final String BASE_URL = "http://"+IP_ADDRESS+":3000/api/";

    private static OkHttpClient httpClient = new OkHttpClient();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                            .create()));




    /**
     * Method to create a service based on a serviceClass
     * @param serviceClass
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }

    /**
     * Method to create a service based on a serviceClass and an Access Token
     * @param serviceClass
     * @param accessToken
     * @param <S>
     * @return
     */
    public static <S> S createService(Class<S> serviceClass, final String accessToken) {
        if( accessToken != null ) {
            httpClient.interceptors().clear();
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Authorization", accessToken)
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });
        }

        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }




}
