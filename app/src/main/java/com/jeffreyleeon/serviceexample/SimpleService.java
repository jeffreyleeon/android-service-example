package com.jeffreyleeon.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by leechunon on 20/7/2016.
 */
public class SimpleService extends Service {

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    boolean paused = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service created...", Toast.LENGTH_LONG).show();
        paused = false;
        Thread initBkgdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                playMusic();
            }
        });
        initBkgdThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed...", Toast.LENGTH_LONG).show();
        paused = true;
    }

    private void playMusic() {
        Log.d("TAG", "Music playing");
    }
}
