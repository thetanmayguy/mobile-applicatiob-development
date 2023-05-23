package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signInButton;
    private EditText usernameField;
    private EditText passwordField;

    private String username;
    private String password;

    public static final int MAX_ATTEMPTS = 2;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameField = findViewById(R.id.username_edit_text);
        passwordField = findViewById(R.id.password_edit_text);
        signInButton = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("userNameKey");
        password = bundle.getString("passwordKey");

        signInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String enteredUsername = usernameField.getText().toString();
        String enteredPassword = passwordField.getText().toString();

        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            makeToast("Successful Login!");
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        } else {
            if (attempts < MAX_ATTEMPTS) {
                makeToast("Incorrect login credentials\nLogin attempts remaining: " + (MAX_ATTEMPTS - attempts));
            } else {
                makeToast("Failed Login Attempts");
                signInButton.setEnabled(false);
            }
            attempts++;
        }
    }

    private void makeToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}