package com.amaciasj.ad.andresmaciasexadt1;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    EditText edt_concept;
    EditText edt_quantity;
    TextView list;

    DataInputStream dis = null;
    DataOutputStream dos = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = (Button) findViewById(R.id.button);
        edt_concept = (EditText) findViewById(R.id.editText);
        edt_quantity = (EditText) findViewById(R.id.editText2);
        list = (TextView) findViewById(R.id.textView);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String concepto = edt_concept.getText().toString();
                String cantidad = edt_quantity.getText().toString();
                list.setText("");
                String nuevoConcepto = "";
                String nuevaCantidad = "";

                try {

                    dos = new DataOutputStream(openFileOutput("listadelacompra.txt", Context.MODE_APPEND));
                    dis = new DataInputStream(openFileInput("listadelacompra.txt"));
                    dos.writeUTF(cantidad);
                    nuevaCantidad = "[" + dis.readUTF() + "]";
                    dos.writeChar(';');
                    dos.writeUTF(concepto);
                    dis.readChar();
                    nuevoConcepto = dis.readUTF();
                    list.setText(list.getText().toString() + "\n" + nuevaCantidad + "\t" + nuevoConcepto);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        dis.close();
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

    }
}
