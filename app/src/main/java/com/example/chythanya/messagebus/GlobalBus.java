package com.example.chythanya.messagebus;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class GlobalBus extends Application implements MessageBus, subscribe{

        public static ArrayList<subscribe> reglist= new ArrayList<>();
        subscribe sb;
        Activity mcallback;
        int num;

    @Override
    public void register(subscribe sub) {
        reglist.add(sub);
       // num = reglist.size();
       Log.i("chy","reglist :" + num);
    }

    @Override
    public void unregister(subscribe sub) {
reglist.remove(sub);
    }

    @Override
    public void postMessage(Message msg) {

        for (int i=0;i<reglist.size();i++){
         sb = reglist.get(i);
         sb.getMessage(msg);

         Log.i("Chy","testing");
        }
    }


    @Override
    public void getMessage(Message msg) {
Log.i("chy","get message from global bus");
    }
}
