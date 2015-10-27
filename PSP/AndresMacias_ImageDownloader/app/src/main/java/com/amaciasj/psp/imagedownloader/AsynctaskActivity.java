package com.amaciasj.psp.imagedownloader;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        btnDescargar = (Button) findViewById(R.id.btn_download);
        editUrl = (EditText) findViewById(R.id.edit_url);
        imagen = (ImageView) findViewById(R.id.imageView);

        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urlImagen = editUrl.getText().toString();

                if (urlImagen.equals("")) {
                    Toast.makeText(AsyncTaskActivity.this, getString(R.string.asynctask_url_not_entered), Toast.LENGTH_LONG).show();
                } else {
                    new TareaAsincrona().execute(urlImagen);
                }

            }
        });

    }

    private class TareaAsincrona extends AsyncTask <String, Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progreso = new ProgressDialog(AsyncTaskActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progreso.setMessage("Descargando imagen...");
            progreso.setCancelable(false);
            progreso.show();

        }

        @Override
        protected Bitmap doInBackground(String... params) {

            String urlImagen = params[0];

            is = getInputStreamFromURL(urlImagen);
            bm = BitmapFactory.decodeStream(is);

            int nBytes = bm.getByteCount();

            return bm;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progreso.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (bitmap != null) {
                imagen.setImageBitmap(bitmap);
                progreso.dismiss();
            } else {
                progreso.dismiss();
                Toast.makeText(AsyncTaskActivity.this, "Error al descargar imagen", Toast.LENGTH_LONG).show();
            }
        }
    }



}
