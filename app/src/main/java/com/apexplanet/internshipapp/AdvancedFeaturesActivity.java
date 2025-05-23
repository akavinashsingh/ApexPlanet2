package com.apexplanet.internshipapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.apexplanet.internshipapp.auth.AuthenticationManager;
import com.apexplanet.internshipapp.utils.NotificationHelper;

public class AdvancedFeaturesActivity extends AppCompatActivity {
    private Button sendNotificationButton, loginButton, logoutButton;
    private EditText usernameEditText, passwordEditText;
    private Switch darkModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_features);
        initializeViews();
        setupClickListeners();
        updateUI();
    }

    private void initializeViews() {
        sendNotificationButton = findViewById(R.id.send_notification_button);
        loginButton = findViewById(R.id.login_button);
        logoutButton = findViewById(R.id.logout_button);
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        darkModeSwitch = findViewById(R.id.dark_mode_switch);
    }

    private void setupClickListeners() {
        sendNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationHelper.showNotification(AdvancedFeaturesActivity.this,
                        "ApexPlanet Internship", "Advanced features are working perfectly!");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogout();
            }
        });

        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(this,
                    "Dark mode " + (isChecked ? "enabled" : "disabled"),
                    Toast.LENGTH_SHORT).show();
        });
    }

    private void performLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        if (AuthenticationManager.getInstance(this).login(username, password)) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            updateUI();
        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    private void performLogout() {
        AuthenticationManager.getInstance(this).logout();
        Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show();
        updateUI();
    }

    private void updateUI() {
        boolean isLoggedIn = AuthenticationManager.getInstance(this).isLoggedIn();
        loginButton.setEnabled(!isLoggedIn);
        logoutButton.setEnabled(isLoggedIn);
        usernameEditText.setEnabled(!isLoggedIn);
        passwordEditText.setEnabled(!isLoggedIn);
        if (isLoggedIn) {
            usernameEditText.setText("");
            passwordEditText.setText("");
        }
    }
}