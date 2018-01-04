
package com.reactlibrary;

//import android.app.AppOpsManager;
//import android.content.pm.ApplicationInfo;

import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;

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

//      OLD METHOD
//      String CHECK_OP_NO_THROW = "checkOpNoThrow";
//      String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
//
//      AppOpsManager mAppOps = (AppOpsManager) reactContext.getSystemService(Context.APP_OPS_SERVICE);
//      ApplicationInfo appInfo = reactContext.getApplicationInfo();
//      String pkg = reactContext.getApplicationContext().getPackageName();
//      int uid = appInfo.uid;
//
//      Class appOpsClass = null; /* Context.APP_OPS_MANAGER */
//      try {
//          appOpsClass = Class.forName(AppOpsManager.class.getName());
//          Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class);
//          Field opPostNotificationValue = appOpsClass.getDeclaredField(OP_POST_NOTIFICATION);
//
//          int value = (Integer) opPostNotificationValue.get(Integer.class);
//          boolean returnValue = (Integer) checkOpNoThrowMethod.invoke(mAppOps, value, uid, pkg) == AppOpsManager.MODE_ALLOWED;
//          promise.resolve(returnValue);
//
//      } catch (ClassNotFoundException e) {
//          e.printStackTrace();
//      } catch (NoSuchMethodException e) {
//          e.printStackTrace();
//      } catch (NoSuchFieldException e) {
//          e.printStackTrace();
//      } catch (InvocationTargetException e) {
//          e.printStackTrace();
//      } catch (IllegalAccessException e) {
//          e.printStackTrace();
//      }
  }
}