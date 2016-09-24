package com.example.boombz.myapplication.Service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.boombz.myapplication.LoginActivity;

/**
 * Created by boombz on 23/09/16.
 */
public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "GuestPerf";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_ACCESS_TOKEN = "AccessToken";

    /**
     * Base constructor for SessionManager
     * @param context Context
     */
    public SessionManager(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        this.editor = sharedPreferences.edit();
    }

    /**
     * Method that returns if user is logged in
     * @return A boolean representing if the user is logged in or not
     */
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    /**
     * Method that gets the access token for the session
     * @return A string representing the access token
     */
    public String getLoggedAccessToken() {
        return sharedPreferences.getString(KEY_ACCESS_TOKEN, "");
    }

    /**
     * Method that creates a login session
     *
     * @param email The email of the user
     * @param accessToken The access token of the user
     */
    public void createLoginSession(String email, String accessToken) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    /**
     * Method that logouts the user
     */
    public void logoutUser() {
        editor.clear();
        editor.commit();
    }

    /**
     * Method that starts the LoginActivity
     */
    public void startLoginActivity() {
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
