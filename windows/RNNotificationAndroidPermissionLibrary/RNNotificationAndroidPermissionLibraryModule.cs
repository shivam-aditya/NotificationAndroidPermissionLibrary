using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Notification.Android.Permission.Library.RNNotificationAndroidPermissionLibrary
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNNotificationAndroidPermissionLibraryModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNNotificationAndroidPermissionLibraryModule"/>.
        /// </summary>
        internal RNNotificationAndroidPermissionLibraryModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNNotificationAndroidPermissionLibrary";
            }
        }
    }
}
