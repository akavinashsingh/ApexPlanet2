package com.apexplanet.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView welcomeText;
    private Button setupCompleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        welcomeText = findViewById(R.id.welcome_text);
        setupCompleteButton = findViewById(R.id.setup_complete_button);
        welcomeText.setText("Welcome to ApexPlanet Internship!\nEnvironment Setup Complete");
    }

    private void setupClickListeners() {
        setupCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Development Environment Successfully Configured!", Toast.LENGTH_LONG).show();
            }
        });
    }
}