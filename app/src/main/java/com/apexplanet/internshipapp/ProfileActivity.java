package com.apexplanet.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileActivity extends AppCompatActivity {
    private TextInputEditText nameEditText, emailEditText, phoneEditText;
    private TextInputLayout nameLayout, emailLayout, phoneLayout;
    private Button saveButton;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        nameLayout = findViewById(R.id.name_layout);
        emailLayout = findViewById(R.id.email_layout);
        phoneLayout = findViewById(R.id.phone_layout);
        saveButton = findViewById(R.id.save_button);
        profileImage = findViewById(R.id.profile_image);
    }

    private void setupClickListeners() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    saveProfile();
                }
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this,
                        "Profile Image clicked - Implement Image Picker", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInputs() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();

        if (name.isEmpty()) {
            nameLayout.setError("Name is required");
            return false;
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.setError("Valid email is required");
            return false;
        }
        if (phone.isEmpty() || phone.length() < 10) {
            phoneLayout.setError("Valid phone number is required");
            return false;
        }

        nameLayout.setError(null);
        emailLayout.setError(null);
        phoneLayout.setError(null);
        return true;
    }

    private void saveProfile() {
        Toast.makeText(this, "Profile Saved Successfully!", Toast.LENGTH_SHORT).show();
    }
}