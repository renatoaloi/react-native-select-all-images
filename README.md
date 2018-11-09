
# react-native-select-all-images

### TODO's

- Permissions for Android
- iOS implementation

## Getting started

`$ npm install react-native-select-all-images --save`

### Mostly automatic installation

`$ react-native link react-native-select-all-images`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-select-all-images` and add `RNReactNativeSelectAllImages.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeSelectAllImages.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeSelectAllImagesPackage;` to the imports at the top of the file
  - Add `new RNReactNativeSelectAllImagesPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-select-all-images'
  	project(':react-native-select-all-images').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-select-all-images/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-select-all-images')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeSelectAllImages.sln` in `node_modules/react-native-select-all-images/windows/RNReactNativeSelectAllImages.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Select.All.Images.RNReactNativeSelectAllImages;` to the usings at the top of the file
  - Add `new RNReactNativeSelectAllImagesPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativeSelectAllImages from 'react-native-select-all-images';

// TODO: What to do with the module?
RNReactNativeSelectAllImages;
```
  
