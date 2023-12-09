package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite.db.DatabaseHelper;
import com.example.sqlite.db.entity.Contact;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ContactAdapter contactAdapter;
    private ArrayList<Contact> contactArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("My favorite contacts");

        recyclerView = findViewById(R.id.recycler_view_contacts);
        databaseHelper = new DatabaseHelper(this);

        contactArrayList.addAll(databaseHelper.getAllContacts());

        contactAdapter = new ContactAdapter(this, contactArrayList, MainActivity.this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactAdapter);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(v -> addAndEditContacts(false, null, -1));
    }

    public void addAndEditContacts(final boolean isUpdated, final Contact contact, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.layout_add_contact, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(view);

        TextView contactTitle = view.findViewById(R.id.new_contact_title);
        final EditText newContactName = view.findViewById(R.id.name);
        final EditText newContactEmail = view.findViewById(R.id.email);

        contactTitle.setText(!isUpdated ? "Add contact" : "Edit contact");

        if (isUpdated && contact != null) {
            newContactName.setText(contact.getName());
            newContactEmail.setText(contact.getEmail());
        }

        alertDialogBuilder.setCancelable(false).setPositiveButton(isUpdated ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (isUpdated) {
                            DeleteContact(contact, position);
                        } else {
                            dialog.cancel();
                        }
                    }
                });

        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            if (newContactName.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Enter contact name!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                alertDialog.dismiss();
            }

            if (isUpdated) {
                UpdateContact(newContactName.getText().toString(), newContactEmail.getText().toString(), position);
            } else {
                CreateContact(newContactName.getText().toString(), newContactEmail.getText().toString());
            }
        });

    }

    private void DeleteContact(Contact contact, int position) {
        contactArrayList.remove(position);
        databaseHelper.deleteContact(contact);
        contactAdapter.notifyDataSetChanged();
    }

    private void UpdateContact(String name, String email, int position) {
        Contact contact = contactArrayList.get(position);
        contact.setName(name);
        contact.setEmail(email);
        databaseHelper.updateContact(contact);
        contactArrayList.set(position, contact);
        contactAdapter.notifyDataSetChanged();
    }

    private void CreateContact(String name, String email) {
        long id = databaseHelper.insertContact(name, email);
        Contact contact = databaseHelper.getContact(id);
        if (contact != null) {
            contactArrayList.add(0, contact);
            contactAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}