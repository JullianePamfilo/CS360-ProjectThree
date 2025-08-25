package com.example.pamfilo_module3assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;

import androidx.appcompat.app.AppCompatActivity;

// This class is the entry point of my app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // I connect the UI pieces to code
        EditText nameText = findViewById(R.id.nameText);
        Button buttonSayHello = findViewById(R.id.buttonSayHello);
        Button buttonOpenGrid = findViewById(R.id.buttonOpenGrid);
        Button buttonOpenSms = findViewById(R.id.buttonOpenSms);
        TextView textGreeting = findViewById(R.id.textGreeting);

        // The Say Hello button should only be clickable when text is typed
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                buttonSayHello.setEnabled(!s.toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // When I tap this, it shows a greeting message
        buttonSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString().trim();
                if (!name.isEmpty()) {
                    String greeting = "Hello " + name + "!";
                    textGreeting.setText(greeting);
                }
            }
        });

        // When I tap this, I open the GridActivity screen
        buttonOpenGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gridIntent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(gridIntent);
            }
        });

        // When I tap this, I go to the screen that handles SMS permission
        buttonOpenSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smsIntent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(smsIntent);
            }
        });
    }
}
