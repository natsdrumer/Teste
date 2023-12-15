package com.example.teste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.example.teste.comon.Comon;
import com.example.teste.model.Contact;
import com.example.teste.model.User;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    List<Contact> contact = new ArrayList<>();

    MyAdapter adapter = new MyAdapter(this, contact);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        registerForContextMenu(recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
        contact.add(new Contact("nata", "natslevy@gmail.com", "9510453"));
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.sms){
            sendSms();
            return true;
        }else if (id == R.id.call){
            call();
            return true;
        }else if(id == R.id.share){
            share();
            return true;
        }else {
            return false;
        }
    }

    private void share() {
        int position = adapter.getPosition();
        String name = contact.get(position).getName();
        String email = contact.get(position).getEmail();
        String number = contact.get(position).getNumber();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "name: " + name +"\n" + "number: " +  number + "\n" + "email: " + email);

        startActivity(intent);


    }

    private void call() {
        int position = adapter.getPosition();
        String number = "tel:" + contact.get(position).getNumber();
        Uri uri = Uri.parse(number);

        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    private void sendSms() {
        int position = adapter.getPosition();
        String number = "sms:" + contact.get(position).getNumber();
        Uri uri = Uri.parse(number);
        Intent intent = new Intent(Intent.ACTION_SEND, uri);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.contact){
            updateUser();
            return true;
        }else if (id == R.id.setting){
            showSettings();
            return true;
        }else if(id == R.id.logout){
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

    private void updateUser() {

        Intent intent = new Intent(this, RegisterActivity.class);
        int position = 0;
        intent.putExtra("position",position);
        startActivity(intent);
    }
}