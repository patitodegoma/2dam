package com.amaciasj.psp.andresmaciasexamen28102015;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by amacias on 28/10/2015.
 */
public class TareaAsinc extends AsyncTask <String, Void, Bitmap> {

    Bitmap bm;
    FileInputStream fis = null;
    URL u = null;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        String url = ImageUtils.getRandomPhoto();

        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

    }

    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        try {
            fis = (FileInputStream) u.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bm = BitmapFactory.decodeStream(fis);

        return bm;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
