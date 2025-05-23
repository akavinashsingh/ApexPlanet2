package com.apexplanet.internshipapp.auth;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

public class AuthenticationManager {
    private static final String PREF_NAME = "ApexPlanetAuth";
    private static final String KEY_USER_TOKEN = "user_token";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    private SharedPreferences sharedPreferences;
    private static AuthenticationManager instance;

    private AuthenticationManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized AuthenticationManager getInstance(Context context) {
        if (instance == null) {
            instance = new AuthenticationManager(context.getApplicationContext());
        }
        return instance;
    }

    public boolean login(String username, String password) {
        if (username.equals("intern") && password.equals("apexplanet123")) {
            String token = generateToken();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USER_TOKEN, token);
            editor.putString(KEY_USER_ID, username);
            editor.putBoolean(KEY_IS_LOGGED_IN, true);
            editor.apply();
            return true;
        }
        return false;
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public String getUserToken() {
        return sharedPreferences.getString(KEY_USER_TOKEN, null);
    }

    public String getUserId() {
        return sharedPreferences.getString(KEY_USER_ID, null);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}