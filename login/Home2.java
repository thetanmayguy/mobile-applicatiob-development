package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }

    public void next(View view){
        Intent intent = new Intent(this, Home3.class);
        startActivity(intent);
    }

    public void prev(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}