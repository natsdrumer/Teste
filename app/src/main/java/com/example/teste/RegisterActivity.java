package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.teste.comon.Comon;
import com.example.teste.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {

    EditText etname, etnumber, etemail, etpass, date;
    TextView titulo;

    Button btnR, btnC;

    RadioGroup rg_sexo;

    String sexo;

    Calendar myCalender;

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
        rg_sexo = findViewById(R.id.rg_sexo);

        final Calendar calendar = Calendar.getInstance();

        final DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePicker view, int year, int monthOfYear, int dayOfMonth) -> {
                    // Update the EditText with the selected date
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, monthOfYear, dayOfMonth);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    date.setText(dateFormat.format(selectedDate.getTime()));
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)

        );


        date.setOnClickListener(v -> datePickerDialog.show());


        if(getIntent().hasExtra("position")){
            int position = getIntent().getIntExtra("position", 0);
            titulo.setText(R.string.tittleupdate);
            btnR.setText(R.string.update);
            etname.setText(Comon.contactos.get(position).getName());
            etnumber.setText(Comon.contactos.get(position).getNumber());
            etemail.setText(Comon.contactos.get(position).getEmail());
            etpass.setText(Comon.contactos.get(position).getPasword());
            date.setText(Comon.contactos.get(position).getDateBirth().toString());


            btnR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etname.getText().toString();
                    String email = etemail.getText().toString();
                    String number = etnumber.getText().toString();
                    String pass = etpass.getText().toString();
                    String data = date.getText().toString();


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

            btnC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etemail.setText("");
                    etpass.setText("");
                    etname.setText("");
                    etnumber.setText("");
                    date.setText("");

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }

            });




        }

        rg_sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rbfem){
                    fem();
                }else if (i == R.id.rbmasc){
                    masc();
                }
            }
        });

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


                Comon.contactos.add(new User(name, pass, email, number, data, sexo));
                Comon.login.add(Comon.contactos.get(0));
                //Log.d(Comon.contactos.get(), "onClick: ");

                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("number", number);

                etemail.setText("");
                etpass.setText("");
                etname.setText("");
                etnumber.setText("");

                startActivity(intent);
            }
        });





    }



    private void masc() {
        sexo = "Masculino";
    }

    private void fem() {
        sexo = "Feminino";

    }
}