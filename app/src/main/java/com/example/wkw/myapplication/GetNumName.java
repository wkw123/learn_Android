package com.example.wkw.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wkw on 2016/10/14.
 */

public class GetNumName {

    public  static List<Map<String, String>> getNumber(Context context){

        List<Map<String, String>> dataList = new ArrayList<>();;
        Map<String, String> map;
        Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI,null, null, null, null);
        String phoneNumber;
        String phoneName;

        while (cursor.moveToNext()){
            phoneNumber = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));


            map = new HashMap<>();
            map.put("name", phoneName);
            map.put("number", phoneNumber);
            dataList.add(map);
            Log.i("info","name=" + phoneName + " phone=" + phoneNumber);
        }
        return  dataList;
    }
}
