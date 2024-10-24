package com.example.shoppingmanagementapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText newUsernameEditText, newPasswordEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // חיבור רכיבי ה-UI
        newUsernameEditText = findViewById(R.id.new_username);
        newPasswordEditText = findViewById(R.id.new_password);
        Button registerButton = findViewById(R.id.register_button);

        // יצירת SharedPreferences
        sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        // טיפול בלחיצת כפתור "רישום"
        registerButton.setOnClickListener(v -> {
            String newUsername = newUsernameEditText.getText().toString();
            String newPassword = newPasswordEditText.getText().toString();

            // שמירת שם המשתמש והסיסמה ב-SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", newUsername);
            editor.putString("password", newPassword);
            editor.apply();

            // הצגת הודעה למשתמש
            Toast.makeText(RegisterActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();

            // סיום הפעילות וחזרה למסך הכניסה
            finish();
        });
    }
}
