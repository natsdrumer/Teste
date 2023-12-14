package com.example.teste;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

    ImageView next;
    TextView nameview, numberview, emailview;


    public MyViewHolder(@NonNull View itemview) {
        super(itemview);
        emailview = itemview.findViewById(R.id.emailC);
        nameview = itemview.findViewById(R.id.nameC);
        numberview = itemview.findViewById(R.id.numbC);
        next = itemview.findViewById(R.id.next);
        next.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        menu.add(Menu.NONE, R.id.sms,Menu.NONE,R.string.sms);
        menu.add(Menu.NONE, R.id.call, Menu.NONE, R.string.call);
        menu.add(Menu.NONE, R.id.share, Menu.NONE, R.string.share);



    }
}