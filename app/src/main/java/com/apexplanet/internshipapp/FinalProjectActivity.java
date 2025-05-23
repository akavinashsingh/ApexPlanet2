package com.apexplanet.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalProjectActivity extends AppCompatActivity {
    private CardView profileCard, dataCard, featuresCard, aboutCard;
    private TextView welcomeMessage, projectStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_project);
        initializeViews();
        setupClickListeners();
        displayProjectStats();
    }

    private void initializeViews() {
        profileCard = findViewById(R.id.profile_card);
        dataCard = findViewById(R.id.data_card);
        featuresCard = findViewById(R.id.features_card);
        aboutCard = findViewById(R.id.about_card);
        welcomeMessage = findViewById(R.id.welcome_message);
        projectStats = findViewById(R.id.project_stats);
    }

    private void setupClickListeners() {
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalProjectActivity.this, ProfileActivity.class));
            }
        });
        dataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalProjectActivity.this, DataActivity.class));
            }
        });
        featuresCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalProjectActivity.this, AdvancedFeaturesActivity.class));
            }
        });
        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalProjectActivity.this, AboutActivity.class));
            }
        });
    }

    private void displayProjectStats() {
        String stats = "Project Statistics:\n" +
                " - 5 Tasks Completed\n" +
                " - 8 Activities Created\n" +
                " - API Integration Done\n" +
                " - Advanced Features Implemented\n" +
                " - Ready for Deployment";
        projectStats.setText(stats);
        String welcome = "Congratulations!\nApexPlanet Internship Project Completed Successfully!";
        welcomeMessage.setText(welcome);
    }
}