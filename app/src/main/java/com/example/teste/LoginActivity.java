package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teste.comon.Comon;

public class LoginActivity extends AppCompatActivity {

    Button btnLog, btnCan;
    EditText etEmail, etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLog = findViewById(R.id.btnUp);
        btnCan = findViewById(R.id.btnCan);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        btnCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmail.setText("");
                etPass.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();

                String e = Comon.contactos.get(0).getEmail();
                String p = Comon.contactos.get(0).getPasword();

                if(email.equals(e) && pass.equals(p)){
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("name", Comon.contactos.get(0).getName());
                    intent.putExtra("email", Comon.contactos.get(0).getEmail());
                    intent.putExtra("number", Comon.contactos.get(0).getNumber());
                    Comon.login.add(Comon.contactos.get(0));
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), R.string.erro, Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}