package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.teste.comon.Comon;
import com.example.teste.model.User;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    EditText etname, etnumber, etemail, etpass, date;
    TextView titulo;

    Button btnR, btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etname = findViewById(R.id.eName);
        etnumber = findViewById(R.id.eNumber);
        etemail = findViewById(R.id.eEmail);
        etpass = findViewById(R.id.ePass);
        date = findViewById(R.id.eDate);
        btnC = findViewById(R.id.btnC);
        btnR = findViewById(R.id.btnR);
        titulo = findViewById(R.id.titlenew);

        if(getIntent().hasExtra("tittle")){
            String title = getIntent().getStringExtra("tittle");
            titulo.setText(title);
            btnR.setText(R.string.update);
            etnumber.setText(Comon.contactos.get(0).getNumber());
            etemail.setText(Comon.contactos.get(0).getEmail());
            etpass.setText(Comon.contactos.get(0).getPasword());
            date.setText(Comon.contactos.get(0).getDateBirth().toString());


            btnR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etname.getText().toString();
                    String email = etemail.getText().toString();
                    String number = etnumber.getText().toString();
                    String pass = etpass.getText().toString();
                    String data = date.getText().toString();
                    String sexo = "";

                    Comon.contactos.get(0).setName(name);
                    Comon.contactos.get(0).setEmail(email);
                    Comon.contactos.get(0).setNumber(number);
                    Comon.contactos.get(0).setPasword(pass);
                    Comon.contactos.get(0).setSexo(sexo);
                    Comon.contactos.get(0).setDateBirth(data);





                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    intent.putExtra("name", Comon.contactos.get(0).getName());
                    intent.putExtra("emai", Comon.contactos.get(0).getEmail());
                    intent.putExtra("number", Comon.contactos.get(0).getNumber());
                    startActivity(intent);
                }
            });




        }

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etemail.setText("");
                etpass.setText("");
                etname.setText("");
                etnumber.setText("");
                date.setText("");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString();
                String email = etemail.getText().toString();
                String number = etnumber.getText().toString();
                String pass = etpass.getText().toString();
                String data = date.getText().toString();
                String sexo = "";

                Comon.contactos.add(new User(name, pass, email, number, data, sexo));

                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                intent.putExtra("name", Comon.contactos.get(0).getName());
                intent.putExtra("emai", Comon.contactos.get(0).getEmail());
                intent.putExtra("number", Comon.contactos.get(0).getNumber());
                startActivity(intent);
            }
        });

    }
}