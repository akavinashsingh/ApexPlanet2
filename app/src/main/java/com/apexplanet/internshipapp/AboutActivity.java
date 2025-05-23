package com.apexplanet.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    private TextView aboutText, contactInfo, internshipDetails;
    private Button visitWebsiteButton, callButton, emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initializeViews();
        setupClickListeners();
        displayInformation();
    }

    private void initializeViews() {
        aboutText = findViewById(R.id.about_text);
        contactInfo = findViewById(R.id.contact_info);
        internshipDetails = findViewById(R.id.internship_details);
        visitWebsiteButton = findViewById(R.id.visit_website_button);
        callButton = findViewById(R.id.call_button);
        emailButton = findViewById(R.id.email_button);
    }

    private void setupClickListeners() {
        visitWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apexplanet.in"));
                startActivity(intent);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919905879870"));
                startActivity(intent);
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:info@apexplanet.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Internship Inquiry");
                startActivity(intent);
            }
        });
    }

    private void displayInformation() {
        aboutText.setText("ApexPlanet Software Pvt. Ltd. is dedicated to driving innovation " +
                "and excellence in digital solutions. We specialize in web development and " +
                "app development services tailored to meet unique client needs.");
        contactInfo.setText("Contact Information:\n" +
                "Phone: +91 9905879870\n" +
                "Email: info@apexplanet.in\n" +
                "Website: www.apexplanet.in");
        internshipDetails.setText("45-Days Android Development Internship Program\n\n" +
                "Tasks Completed:\n" +
                "✓ Environment Setup & Onboarding\n" +
                "✓ UI/UX Design Implementation\n" +
                "✓ Backend Integration & APIs\n" +
                "✓ Advanced Features & Testing\n" +
                "✓ Finalization & Deployment");
    }
}