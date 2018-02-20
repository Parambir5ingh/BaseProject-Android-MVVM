package com.prm.base_mvvm.ProjectUtils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SharedPrefHelper
{

    public static final String PREF_NAME = "lectureVerbPref";
    private final String IS_REGISTERED = "is_registered";

    SharedPreferences.Editor edit;
    SharedPreferences sharedPreferences;
    private String USERNAME = "UserName";
    private String USERID = "UserId";
    private String EMAIL = "Email";
    private String IS_VERIFIED = "Verified";
    private String PROFILEPIC = "profilepic";
    private String BIO = "bio";
    private String WEBSITE = "website";
    private String LOCATION = "location";
    private String PROFILEPICCover = "coverProfilePic";
    private String INTERESTS = "INTERESTS";
    private String APP_ID = "APP_ID";
    private String UNREAD_COUNT = "UNREAD_COUNT";
    private String IS_NEW_NOTIFICATION = "IS_NEW_NOTIFICATION";
    private String IS_NEW_MESSAGE = "IS_NEW_MESSAGE";
    private String USER_TYPE = "USER_TYPE";
    private String myLongitude;

    public SharedPrefHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();
    }

    public void setIsNewNotification(boolean isNewNotification) {
        edit.putBoolean(IS_NEW_NOTIFICATION, isNewNotification);
        edit.apply();
    }

    public boolean isNewNotification() {
        return sharedPreferences.getBoolean(IS_NEW_NOTIFICATION, false);
    }


    public void setIsNewMessage(boolean isNewMessage) {
        edit.putBoolean(IS_NEW_MESSAGE, isNewMessage);
        edit.apply();
    }

    public boolean isNewMessage() {
        return sharedPreferences.getBoolean(IS_NEW_MESSAGE, false);
    }


    public void setIsRegistered(boolean isRegisterd) {
        edit.putBoolean(IS_REGISTERED, isRegisterd);
        edit.apply();
    }

    public boolean isRegistered() {
        return sharedPreferences.getBoolean(IS_REGISTERED, false);
    }

    public void setIsVerified(boolean isVerified) {
        edit.putBoolean(IS_VERIFIED, isVerified);
        edit.apply();
    }

    public boolean isVerified() {
        return sharedPreferences.getBoolean(IS_VERIFIED, false);
    }

    /*public void setUserData(UserDataModel.UserData userData) {
        setUserName(userData.getFull_name());
        setUserId(userData.getUser_id());
        setEmail(userData.getEmail().equals("no@email.com") ? "" : userData.getEmail());
        setProfilePic(userData.getProfile_pic());
        setCoverProfilePic(userData.getCover_pic());
        setBio(userData.getBio());
        setWebsite(userData.getWebsite());
        setLocation(userData.getLocation());
    }*/

    public void setLocation(String Location) {
        edit.putString(LOCATION, Location);
        edit.apply();
    }

    public String getMyInterests() {
        return sharedPreferences.getString(INTERESTS, "");
    }

    public void setMyInterests(String interests) {
        edit.putString(INTERESTS, interests);
        edit.apply();
    }

    public String getLocation() {
        return sharedPreferences.getString(LOCATION, "");
    }

    public void setWebsite(String Website) {
        edit.putString(WEBSITE, Website);
        edit.apply();
    }

    public String getWebsite() {
        return sharedPreferences.getString(WEBSITE, "");
    }

    public void setBio(String bio) {
        edit.putString(BIO, bio);
        edit.apply();
    }

    public String getBio() {
        return sharedPreferences.getString(BIO, "");
    }

    public void setEmail(String Email) {
        edit.putString(EMAIL, Email);
        edit.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString(EMAIL, "");
    }

    public void setUnreadCount(int count) {
        edit.putInt(UNREAD_COUNT, count);
        edit.apply();
    }

    public int getUnreadCount() {
        return sharedPreferences.getInt(UNREAD_COUNT, 0);
    }

    public void clearUnreadCount() {
        edit.putInt(UNREAD_COUNT, 0);
        edit.apply();
    }

    public void setUserName(String UserName) {
        edit.putString(USERNAME, UserName);
        edit.apply();
    }

    public String getUserName() {
        return sharedPreferences.getString(USERNAME, "");
    }

    public void setProfilePic(String ProfilePic) {
        edit.putString(PROFILEPIC, ProfilePic);
        edit.apply();
    }

    public String getProfilePic() {
        return sharedPreferences.getString(PROFILEPIC, "");
    }

    public void setCoverProfilePic(String ProfilePic) {
        edit.putString(PROFILEPICCover, ProfilePic);
        edit.apply();
    }

    public String getCoverProfilePic() {
        String string = sharedPreferences.getString(PROFILEPICCover, "");
        return string.isEmpty() ? getProfilePic() : string;
    }

    public void setUserId(String UserId) {
        edit.putString(USERID, UserId);
        edit.apply();
    }

    public String getUserId() {
        return sharedPreferences.getString(USERID, "");
    }

    //    device token stuff start
    public void setDeviceToken(Context context, String DeviceToken) {
        SharedPreferences.Editor editDeviceToken;
        editDeviceToken = context.getSharedPreferences(PREF_NAME + "DeviceToken", Context.MODE_PRIVATE).edit();
        editDeviceToken.putString("DeviceToken", DeviceToken);
        editDeviceToken.apply();
    }

    public void setInterestAlreadySet(Context context) {
        SharedPreferences.Editor editDeviceToken;
        editDeviceToken = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editDeviceToken.putBoolean("isInterestsSet", true);
        editDeviceToken.apply();
    }

    public boolean isInterestAlreadySet(Context context) {
        SharedPreferences sp;
        sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean("isInterestsSet", false);
    }

    public void setWelcomeMessageSeen(Context context) {
        SharedPreferences.Editor editDeviceToken;
        editDeviceToken = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit();
        editDeviceToken.putBoolean("welcomeMessageSeen", true);
        editDeviceToken.apply();
    }

    public boolean isWelcomeMessageSeen(Context context) {
        SharedPreferences sp;
        sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean("welcomeMessageSeen", false);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addUrlInHistory(Context context, String icon, String title, String url) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editDeviceToken;
        editDeviceToken = sp.edit();

        try {
            JSONArray historyArray = new JSONArray(sp.getString("webHistory", "[]"));
            JSONObject innerObj = new JSONObject();
            innerObj.put("url", url);
            innerObj.put("title", title);
            innerObj.put("icon", icon);
            historyArray.put(innerObj);

            if (historyArray.length() > 50) {
                historyArray.remove(0);
            }

            editDeviceToken.putString("webHistory", historyArray.toString());
            editDeviceToken.apply();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void addUrlInHistoryWithStack(Context context, String icon, String title, String url, ArrayList<WebInnerStackModel> alStack) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editDeviceToken;
        editDeviceToken = sp.edit();

        try {
            JSONArray historyArray = new JSONArray(sp.getString("webHistory", "[]"));
            JSONObject innerObj = new JSONObject();
            innerObj.put("url", url);
            innerObj.put("title", title);
            innerObj.put("icon", icon);

            JSONArray innerStackArray = new JSONArray();
            for (int i = 0; i < alStack.size(); i++) {
                JSONObject innerStack = new JSONObject();
                innerStack.put("title", alStack.get(i).getTitle());
                innerStack.put("url", alStack.get(i).getUrl());
                innerStackArray.put(innerStack);
            }
            innerObj.put("innerStack", innerStackArray);


            historyArray.put(innerObj);


            if (historyArray.length() > 50) {
                historyArray.remove(0);
            }

            editDeviceToken.putString("webHistory", historyArray.toString());
            editDeviceToken.apply();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WebHistoryModel> getWebHistory(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        ArrayList<WebHistoryModel> alModels = new ArrayList<>();
        try {
            JSONArray historyArray = new JSONArray(sp.getString("webHistory", "[]"));
            for (int i = 0; i < historyArray.length(); i++) {
                WebHistoryModel model = new WebHistoryModel();
                JSONObject inner = historyArray.optJSONObject(i);
                model.setTitle(inner.optString("title"));
                model.setUrl(inner.optString("url"));
                model.setIcon(inner.optString("icon"));

                ArrayList<WebInnerStackModel> alInnerStack = new ArrayList<>();

                JSONArray innerStack = inner.optJSONArray("innerStack");

                for (int j = 0; j < innerStack.length(); j++) {
                    JSONObject innerStackObj = innerStack.optJSONObject(j);
                    WebInnerStackModel innerModel = new WebInnerStackModel();
                    innerModel.setTitle(innerStackObj.optString("title"));
                    innerModel.setUrl(innerStackObj.optString("url"));
                    alInnerStack.add(innerModel);
                }

                model.setInnerstack(alInnerStack);
                alModels.add(model);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return alModels;
    }

    public String getDeviceToken(Context context) {
        return context.getSharedPreferences(PREF_NAME + "DeviceToken", Context.MODE_PRIVATE).getString("DeviceToken", "");
    }
//    device token stuff end

    public void logOut() {
        edit.clear();
        edit.apply();
    }


    public void setAppId(String UserId) {
        edit.putString(APP_ID, UserId);
        edit.apply();
    }

    public String getAppId() {
        return sharedPreferences.getString(APP_ID, "");
    }

    public void enableNotificationSound(boolean isEnabled) {
        edit.putBoolean("notificationSoundEnabled", isEnabled);
        edit.apply();
    }

    public void enableEnterIsSend(boolean isEnabled) {
        edit.putBoolean("enterIsSend", isEnabled);
        edit.apply();
    }

    public boolean isEnterIsSend() {
        return sharedPreferences.getBoolean("enterIsSend", false);
    }


    public void setSoundId(int resId, String soundName) {
        edit.putInt("soundId", resId);
        edit.putString("soundName", soundName);
        edit.apply();
    }

/*
    public int getSoundId() {
        return sharedPreferences.getInt("soundId", R.raw.notify_1);
    }
*/

    public String getSoundName() {
        return sharedPreferences.getString("soundName", "Sound 1");
    }

    public void setNotificationLightAndColor(String colorName, String colorCode) {
        edit.putString("notificationLightColor", colorCode);
        edit.putString("notificationLightName", colorName);
        edit.apply();
    }

    public void setVibration(String vibName, long pattern) {
        edit.putLong("vibrationPattern", pattern);
        edit.putString("vibrationName", vibName);
        edit.apply();
    }

    public void setChatFontSize(String fontName, int size) {
        edit.putInt("fontSize", size);
        edit.putString("fontName", fontName);
        edit.apply();
    }

    public int getFontSize() {
        return sharedPreferences.getInt("fontSize", 14);
    }

    public String getFontName() {
        return sharedPreferences.getString("fontName", "Medium");
    }

    public long getVibrationPattern() {
        return sharedPreferences.getLong("vibrationPattern", 500);
    }

    public String getVibrationName() {
        return sharedPreferences.getString("vibrationName", "Medium");
    }

    public String getNotificationLightName() {
        return sharedPreferences.getString("notificationLightName", "White");
    }

    public String getNotificationLightColorCode() {
        return sharedPreferences.getString("notificationLightColor", "#FFFFFF");
    }

    public boolean isNotificationSoundEnabled() {
        return sharedPreferences.getBoolean("notificationSoundEnabled", true);
    }

    public void setMyLatitude(String latitude) {
        edit.putString("MyLatitude", latitude);
        edit.apply();
    }

    public String getMyLatitude() {
        return sharedPreferences.getString("MyLatitude", "0.000");
    }

    public void setMyLongitude(String myLongitude) {
        edit.putString("MyLongitude", myLongitude);
        edit.apply();
    }

    public String getMyLongitude() {
        return sharedPreferences.getString("MyLongitude", "0.000");
    }

    public void setMaxKmRange(int maxRangeNow) {
        edit.putInt("maxKmRange", maxRangeNow);
        edit.apply();
    }

    public int getMaxKmRange() {
        return sharedPreferences.getInt("maxKmRange", 5);
    }
}
