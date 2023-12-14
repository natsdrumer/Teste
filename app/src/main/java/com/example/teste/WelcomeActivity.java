package com.example.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.teste.comon.Comon;

public class WelcomeActivity extends AppCompatActivity {

    TextView nome, email, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nome = findViewById(R.id.tvName);
        email = findViewById(R.id.tvEmail);
        numero = findViewById(R.id.tvNumber);

        if(getIntent().hasExtra("name") && getIntent().hasExtra("number")&& getIntent().hasExtra("email")){
            String name = getIntent().getStringExtra("name");
            String number = getIntent().getStringExtra("number");
            String mail = getIntent().getStringExtra("email");
            nome.setText(name);
            email.setText(mail);
            numero.setText(number);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.setting){
            showSettings();
            return true;
        }else if (id == R.id.logout){
            logout();
            return true;
        }else {
            return false;
        }
    }

    private void logout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.logout)
                .setMessage(R.string.alert)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Comon.contactos.remove(0);
                        Comon.login.remove(0);
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);

                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        builder.show();
    }

    public void showSettings(){
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);

    }


}