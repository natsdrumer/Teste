package com.example.teste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.teste.model.Contact;
import com.example.teste.model.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Contact> contactos;

    //MyViewHolder holder;

    public MyAdapter(Context context, List<Contact> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    private int position;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.nameview.setText(contactos.get(position).getName());
        holder.numberview.setText(contactos.get(position).getNumber());

        holder.next.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setPosition(holder.getAdapterPosition());
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

