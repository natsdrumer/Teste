package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etname, etnumber, etemail, etpass, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etname = findViewById(R.id.eName);
        etnumber = findViewById(R.id.eNumber);
        etemail = findViewById(R.id.eEmail);
        etpass = findViewById(R.id.ePass);
        date = findViewById(R.id.eDate);

    }
}