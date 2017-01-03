package com.example.liyang.youhobuy.Utils;

import com.example.liyang.youhobuy.MyApplication;

/**
 * Created by liyang on 2016/12/28.
 */

public class IDUtils {
    public static int getId(String name, String type, String pm){
        return MyApplication.app.getResources().getIdentifier(name,type,pm);
    }
    public static int getPackageId(String name,String type){
        return getId(name,type,MyApplication.app.getPackageName());
    }
    public static int getDrawableId(String name){
        return getId(name,"mipmap",MyApplication.app.getPackageName());
    }
}
