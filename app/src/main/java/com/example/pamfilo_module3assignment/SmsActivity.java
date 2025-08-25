package com.example.pamfilo_module3assignment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SmsActivity extends AppCompatActivity {

    private static final int SMS_PERMISSION_CODE = 123;
    private TextView textPermissionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // I grab the UI elements I need from the layout
        Button buttonRequestSms = findViewById(R.id.buttonRequestSms);
        textPermissionStatus = findViewById(R.id.textPermissionStatus);

        // When I tap the button, I check or ask for permission
        buttonRequestSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSmsPermission();
            }
        });
    }

    // I use this function to check and request permission
    private void handleSmsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission already granted
            textPermissionStatus.setText("SMS permission is already granted.");
        } else {
            // Ask for permission
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SMS_PERMISSION_CODE
            );
        }
    }

    // This is where I find out what the user picked
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                textPermissionStatus.setText("Thanks! SMS permission was granted.");
            } else {
                textPermissionStatus.setText("SMS permission was denied.");
            }
        }
    }
}
