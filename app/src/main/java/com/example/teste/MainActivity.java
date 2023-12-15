package com.example.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.teste.comon.Comon;
import com.example.teste.model.User;


public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.btncont);
        registerForContextMenu(btn);

        

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {


        if(item.getItemId() == R.id.register){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            return  true;
        }else if(item.getItemId() == R.id.login){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }else {
            return false;
        }


    }
}