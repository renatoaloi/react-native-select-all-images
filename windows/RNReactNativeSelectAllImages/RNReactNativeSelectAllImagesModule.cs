using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Select.All.Images.RNReactNativeSelectAllImages
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeSelectAllImagesModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeSelectAllImagesModule"/>.
        /// </summary>
        internal RNReactNativeSelectAllImagesModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeSelectAllImages";
            }
        }
    }
}
