package com.example.chythanya.messagebus;

import android.content.Context;

public interface MessageBus {
    void register(subscribe sub) ;

    void unregister(subscribe sub);

    void postMessage(Message msg);

    //subscribe provideSubscribe();

}
