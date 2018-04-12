
package com.reactlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.lang.reflect.Method;

public class RNNotificationAndroidPermissionLibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNNotificationAndroidPermissionLibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNNotificationAndroidPermissionLibrary";
    }

    @ReactMethod
    public void checkNotificationPermission(Promise promise) {

        Context context = getReactApplicationContext();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        boolean areNotificationsEnabled = notificationManagerCompat.areNotificationsEnabled();

        promise.resolve(areNotificationsEnabled);
    }

    @ReactMethod
    public void requestAutostartPermissionForXiaomi() {
        try{
            String manufacturer = "xiaomi";
            if (manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
                //this will open auto start screen where user can enable permission for your app
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                getCurrentActivity().startActivity(intent);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @ReactMethod
    public void requestAutostartPermissionForChineseDevices(String manufacturer, String security_app_packagename, String security_app_activityname) {
        try{
            if (manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
                //this will open auto start screen where user can enable permission for your app
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(security_app_packagename, security_app_activityname));
                getCurrentActivity().startActivity(intent);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

//    @ReactMethod
//    public void isAutostartPermissionRequired(Promise promise) {
//        String manufacturer = "xiaomi";
//
//        try {
//            Class<?> c = Class.forName("android.os.SystemProperties");
//            if(c !=null){
//                Method get = c.getMethod("get", String.class);
//                String miui = (String) get.invoke(c, "ro.miui.ui.version.code");
//
//                Log.d("ReactNativeJS","miui is"+miui);
//
//                if(miui != ""){
//                    promise.resolve(true);
//                }
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            String isMIUI = (Class.forName("android.os.SystemProperties") .getMethod("get", String::class.java) .invoke(null, "ro.miui.ui.version.code") as String? ?: "") != "";
//
//            Log.d("ReactNativeJS","isMIUI is"+isMIUI);
//            if(isMIUI != ""){
//                promise.resolve(true);
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if (manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
//            //this will open auto start screen where user can enable permission for your app
//            promise.resolve(true);
//        }
//
//        promise.resolve(false);
//    }


}