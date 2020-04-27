package com.example.chythanya.messagebus;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements subscribe{
GlobalBus gb;
Button bt;
TextView tv;
subscribe sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = (subscribe) this;
        gb = (GlobalBus) getApplication();
        gb.register(sb);

        bt = findViewById(R.id.send);
        tv = findViewById(R.id.messagesent);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                startActivity(intent);

            }
        });

gb.postMessage(new Message("Hello from main activity..."));    }

    @Override
    public void getMessage(Message msg) {
        tv.setText(msg.mMessage);
        Log.i("chy","get message from Main activity");

    }

    @Override
    protected void onStop() {
        super.onStop();
        gb.postMessage(new Message("Hello to main activity 2"));
        gb.unregister(sb);
    }
}
