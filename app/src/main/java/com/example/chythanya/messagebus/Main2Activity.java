package com.example.chythanya.messagebus;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements subscribe{
    GlobalBus gb;
    TextView tmsg;
    subscribe sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        gb = (GlobalBus) getApplicationContext();
        sb = (subscribe) this;

        gb.register(sb);
        tmsg = findViewById(R.id.message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        gb.postMessage(new Message("Hello to main activity from main 2 activity"));
        gb.unregister(sb);
    }

    @Override
    public void getMessage(Message msg) {
        tmsg.setText(msg.mMessage);
        Log.i("chy","get message from Main2 activity");
    }
}
