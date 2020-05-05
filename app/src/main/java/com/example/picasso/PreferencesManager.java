package com.example.picasso;

import android.content.SharedPreferences;
import android.net.Uri;

class PreferencesManager {
    private SharedPreferences mSharedPreferences;

    public PreferencesManager() {
        mSharedPreferences= App.getSharedPreferences();
    }
    public void savePhoto(Uri uri) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("PHOTO_KEY", uri.toString());
        editor.apply();
    }
    public Uri loadUserPhoto() {
        return Uri.parse(mSharedPreferences.getString("PHOTO_KEY",
                "android.resource://com.example.user.picasopetrofit/drawable/photo"));
    }

}
