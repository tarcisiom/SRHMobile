package com.example.boombz.myapplication.app;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.example.boombz.myapplication.Models.Temperatura;
import com.example.boombz.myapplication.Models.User;
import com.example.boombz.myapplication.Service.EstradasService;
import com.example.boombz.myapplication.Service.LoginService;
import com.example.boombz.myapplication.Service.ServiceGenerator;
import com.example.boombz.myapplication.Service.TemperaturasService;
import com.example.boombz.myapplication.Service.UserService;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;

/**
 * Created by boombz on 23/09/16.
 */
public class App extends Application {
    private static LoginService loginService;
    private static UserService userService;
    private static EstradasService estradasService;
    private static TemperaturasService temperaturasService;


    public static User currentUser;



    /**
     * Method to perform operations on creation.
     * In this case loginService is generated.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        loginService = ServiceGenerator.createService(LoginService.class);
        estradasService = ServiceGenerator.createService(EstradasService.class);
        temperaturasService = ServiceGenerator.createService(TemperaturasService.class);
    }




    /**
     * Method to get LoginService
     * @return LoginService
     */
    public static LoginService getLoginService() {
        return loginService;
    }


    public static void setUserService(String accessToken) {
        userService = ServiceGenerator.createService(UserService.class, accessToken);
    }


    public static UserService getUserService() {
        return userService;
    }


    public static void setCurrentUser(User guest) {
        currentUser = guest;
    }

    public static EstradasService getEstradasService() {
        return estradasService;
    }

    public static TemperaturasService getTemperaturasService() {
        return temperaturasService;
    }
}
