package com.amaciasj.ad.loginpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String PREFERENCES = "LoginPrefs";

    Button btnEnter;
    EditText editUser, editPassword;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnter = (Button) findViewById(R.id.btn_send);
        editUser = (EditText) findViewById(R.id.edit_email);
        editPassword = (EditText) findViewById(R.id.edit_password);

        SharedPreferences sp = getSharedPreferences(PREFERENCES, 0);
        final SharedPreferences.Editor editor = sp.edit();

        if (sp.getString("logged", "").toString().equals("logged")) {

            i = new Intent (MainActivity.this, LoggedActivity.class);
            startActivity(i);

        }

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = editUser.getText().toString();
                String pass = editPassword.getText().toString();

                if (!user.equals("") && !pass.equals("")) {

                    if (user.equals("amaciasj@gmail.com") && pass.equals("aravasylotuiteas")) {

                        SharedPreferences sp = getSharedPreferences(PREFERENCES, 0);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("logged", "logged");
                        editor.commit();

                        i = new Intent (MainActivity.this, LoggedActivity.class);
                        startActivity(i);

                    }

                }

            }
        });
    }
}
