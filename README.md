
# react-native-notification-android-permission-library

This project is made to get status of notification permission for android in react native. 

NOTE: This is only meant for Android. Please do not use it for iOS in it's current state.

## Getting started

`$ npm install react-native-notification-android-permission-library --save`

### Mostly automatic installation

`$ react-native link react-native-notification-android-permission-library`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-notification-android-permission-library` and add `RNNotificationAndroidPermissionLibrary.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNNotificationAndroidPermissionLibrary.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNNotificationAndroidPermissionLibraryPackage;` to the imports at the top of the file
  - Add `new RNNotificationAndroidPermissionLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-notification-android-permission-library'
  	project(':react-native-notification-android-permission-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-notification-android-permission-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-notification-android-permission-library')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNNotificationAndroidPermissionLibrary.sln` in `node_modules/react-native-notification-android-permission-library/windows/RNNotificationAndroidPermissionLibrary.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Notification.Android.Permission.Library.RNNotificationAndroidPermissionLibrary;` to the usings at the top of the file
  - Add `new RNNotificationAndroidPermissionLibraryPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNNotificationAndroidPermissionLibrary from 'react-native-notification-android-permission-library';

async checkAndroidNotificationPermission () {
    let status = await RNNotificationAndroidPermissionLibrary.checkNotificationPermission();
    console.log("Android Push Notification status is: " + status);
}
```
## API

- checkNotificationPermission() - Returns bool (true/false) depending on status of push notification permission for android OS.

## License

MIT