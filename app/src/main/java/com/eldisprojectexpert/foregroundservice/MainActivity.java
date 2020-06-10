package com.eldisprojectexpert.foregroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextNotificationMessage;
    Button buttonStartForegroundService, buttonStopForegroundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNotificationMessage = findViewById(R.id.edittext_notification_message);
        buttonStartForegroundService = findViewById(R.id.button_start_foreground_service);
        buttonStopForegroundService = findViewById(R.id.button_stop_foreground_service);
    }



    public void startForegroundService(View view){
        String message = editTextNotificationMessage.getText().toString().trim();
        Intent intent = new Intent(MainActivity.this, ForegroundService.class);
        intent.putExtra("message", message);

        //start service explicitly
        startService(intent);
    }

    public void stopForegroundService(View view){
        Intent intent = new Intent(MainActivity.this, ForegroundService.class);
        stopService(intent);
    }
}
