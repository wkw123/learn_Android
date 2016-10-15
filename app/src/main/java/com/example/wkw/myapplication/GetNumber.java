package com.example.wkw.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

/**
 * Created by wkw on 2016/10/14.
 */

public class GetNumber {

    public  static String getNumber(Context context){


        Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI,null, null, null, null);
        String phoneNumber;
        String phoneName;

        while (cursor.moveToNext()){
            phoneNumber = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            Log.i("info","name=" + phoneName + " phone=" + phoneNumber);
        }
        return  null;
    }
}
