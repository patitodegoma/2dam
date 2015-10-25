package com.amaciasj.psp.imagedownloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnHandler, btnAsynctask;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHandler = (Button) findViewById(R.id.btn_handler);
        btnAsynctask = (Button) findViewById(R.id.btn_asynctask);

        btnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(i);

            }
        });

        btnAsynctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(MainActivity.this, AsynctaskActivity.class);
                startActivity(i);

            }
        });
    }
}
