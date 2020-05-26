package com.eldisprojectexpert.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class ForegroundService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String message = intent.getStringExtra("message");

        Intent launchActivityIntent = new Intent(ForegroundService.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, launchActivityIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, GlobalClass.CHANNEL_ID)
                .setContentTitle("Foreground Service")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_android)
                .setAutoCancel(true)
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification); //we use this when we want to use foreground service

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
