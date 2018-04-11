
package com.reactlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

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
        String manufacturer = "xiaomi";

        if (manufacturer.equalsIgnoreCase(android.os.Build.MANUFACTURER)) {
            //this will open auto start screen where user can enable permission for your app
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            getCurrentActivity().startActivity(intent);
        }
    }
}