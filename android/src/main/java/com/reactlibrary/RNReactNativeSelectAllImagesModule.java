
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;

import java.util.HashMap;
import java.util.Map;

public class RNReactNativeSelectAllImagesModule extends ReactContextBaseJavaModule {

    private static final String DISPLAY_NAME = "DISPLAY_NAME";
    private static final String DATA = "DATA";
    private static final String DATE_TAKEN = "DATE_TAKEN";
    private static final String SIZE_IN_BYTES = "SIZE_IN_BYTES";
    private final ReactApplicationContext reactContext;

    public RNReactNativeSelectAllImagesModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNReactNativeSelectAllImages";
    }

    @ReactMethod
    public void getImages(final Promise promise) {
        new GetImagesTask(promise, reactContext).execute();
    }

    private static class GetImagesTask extends AsyncTask<Void, Void, Void> {

        private Promise promise;
        private ReactApplicationContext reactContext;

        GetImagesTask(Promise promise, ReactApplicationContext reactContext) {
            this.promise = promise;
            this.reactContext = reactContext;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                WritableArray imagesArray = new WritableNativeArray();
                ContentResolver imageResolver = reactContext.getContentResolver();
                Uri imageUri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Cursor imageCursor = imageResolver.query(imageUri, null, null, null,
                        android.provider.MediaStore.Images.Media.DATE_TAKEN + " DESC");
                if (imageCursor != null && imageCursor.moveToFirst()) {
                    int displayNameColumn = imageCursor
                            .getColumnIndex(android.provider.MediaStore.Images.Media.DISPLAY_NAME);
                    int dataColumn = imageCursor.getColumnIndex(android.provider.MediaStore.Images.Media.DATA);
                    int sizeColumn = imageCursor.getColumnIndex(android.provider.MediaStore.Images.Media.SIZE);
                    int dateColumn = imageCursor.getColumnIndex(android.provider.MediaStore.Images.Media.DATE_TAKEN);
                    do {
                        WritableMap map = Arguments.createMap();
                        map.putString(DISPLAY_NAME, imageCursor.getString(displayNameColumn));
                        map.putString(DATA, imageCursor.getString(dataColumn));
                        map.putString(DATE_TAKEN, imageCursor.getString(dateColumn));
                        map.putInt(SIZE_IN_BYTES, imageCursor.getInt(sizeColumn));
                        imagesArray.pushMap(map);
                    } while (imageCursor.moveToNext());
                }
                promise.resolve(imagesArray);
            } catch (Exception e) {
                promise.reject(e);
            }
            return null;
        }
    }
}