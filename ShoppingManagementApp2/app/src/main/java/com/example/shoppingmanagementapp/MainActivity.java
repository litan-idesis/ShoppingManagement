package com.example.shoppingmanagementapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // חיבור רכיבי ה-UI
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);
        Button newUserButton = findViewById(R.id.new_user_button);

        // יצירת SharedPreferences לשמירת נתונים
        sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);

        // טיפול בלחיצת כפתור "התחבר"
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // בדיקה אם שם המשתמש והסיסמה קיימים ב-SharedPreferences
            if (validateUser(username, password)) {
                // מעבר לדף הראשי במידה והכניסה תקינה והעברת שם המשתמש ל-Activity הבא
                Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
                intent.putExtra("username", username);  // העברת שם המשתמש
                startActivity(intent);
            } else {
                // הצגת הודעת שגיאה אם הפרטים שגויים
                Toast.makeText(MainActivity.this, "שם משתמש או סיסמה לא נכונים", Toast.LENGTH_SHORT).show();
            }
        });

        // טיפול בלחיצת כפתור "משתמש חדש"
        newUserButton.setOnClickListener(v -> {
            // מעבר למסך רישום משתמש חדש
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    // פונקציה לבדוק אם שם המשתמש והסיסמה נכונים
    private boolean validateUser(String username, String password) {
        // קריאת שם המשתמש והסיסמה שנשמרו
        String savedUsername = sharedPreferences.getString("username", null);
        String savedPassword = sharedPreferences.getString("password", null);

        // בדיקה אם שם המשתמש והסיסמה שהוזנו תואמים למה שנשמר
        return username.equals(savedUsername) && password.equals(savedPassword);
    }
}
