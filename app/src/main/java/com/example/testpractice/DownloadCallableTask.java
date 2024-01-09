package com.example.testpractice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public class DownloadCallableTask implements Callable<Bitmap> {
    String Url;

    public DownloadCallableTask(String url) {
        Url = url;
    }

    @Override
    public Bitmap call() throws Exception {
        URL url = new URL(Url);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        return bitmap;
    }
}
