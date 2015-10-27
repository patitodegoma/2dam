package com.amaciasj.psp.imagedownloader;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HandlerActivity extends AppCompatActivity {

    Button btnDescargar;
    EditText editUrl;
    ProgressDialog progreso;
    ImageView imagen;

    InputStream is = null;
    Bitmap bm = null;

    // Método de Acceso a Datos
    public InputStream getInputStreamFromURL(String url) {

        URL u = null;

        InputStream is;
        is = null;

        try {
            u = new URL(url);
            URLConnection con = u.openConnection();
            is = con.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return is;
    }

    Handler puente = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Devolucion d = (Devolucion) msg.obj;

            Bitmap imagenDescargada = d.getImagenDescargada();
            int nBytes = d.getnBytes();

            imagen.setImageBitmap(imagenDescargada);

            progreso.dismiss();

            Toast.makeText(HandlerActivity.this, "Se descargaron " + nBytes/1024 + " KB", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        btnDescargar = (Button) findViewById(R.id.btn_download);
        editUrl = (EditText) findViewById(R.id.edit_url);
        imagen = (ImageView) findViewById(R.id.imageView);

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String urlImagen = editUrl.getText().toString();

                if (urlImagen.equals("")) {
                    Toast.makeText(HandlerActivity.this, getString(R.string.handler_url_not_entered), Toast.LENGTH_LONG).show();
                } else {
                    progreso = new ProgressDialog(HandlerActivity.this);
                    progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progreso.setMessage("Descargando imagen...");
                    progreso.setCancelable(false);
                    progreso.show();

                    // La descarga se realiza aquí para no sobrecargar el hilo principal
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            is = getInputStreamFromURL(urlImagen);
                            bm = BitmapFactory.decodeStream(is);

                            int nBytes = bm.getByteCount();

                            Message m = new Message();
                            m.obj = new Devolucion(bm, nBytes);
                            puente.sendMessage(m);   // Envío la imagen al hilo principal
                        }
                    }).start();

                }

            }
        });


    }

    private class Devolucion {

        Bitmap imagenDescargada;
        int nBytes;

        public Devolucion (Bitmap imagenDescargada, int nBytes) {
            this.imagenDescargada = imagenDescargada;
            this.nBytes = nBytes;
        }

        public Bitmap getImagenDescargada() {
            return imagenDescargada;
        }

        public void setImagenDescargada(Bitmap imagenDescargada) {
            this.imagenDescargada = imagenDescargada;
        }

        public int getnBytes() {
            return nBytes;
        }

        public void setnBytes(int nBytes) {
            this.nBytes = nBytes;
        }
    }


}

