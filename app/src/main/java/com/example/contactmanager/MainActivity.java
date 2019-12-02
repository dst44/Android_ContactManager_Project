package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.contactmanager.Adapter.RecyclerViewAdapter;
import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ListView listView;
    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler dbh = new DatabaseHandler(MainActivity.this);

        //listView = findViewById(R.id.listview);
        contactArrayList = new ArrayList<>();
        makeDatabase(dbh, contactArrayList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // we want a linear layout in our recyclerView

        recyclerViewAdapter = new RecyclerViewAdapter(this, contactArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void makeDatabase(DatabaseHandler dbh, ArrayList<Contact> contactArrayList){

        dbh.clearDatabase();

        dbh.addContact(new Contact("A","98980000111"));
        dbh.addContact(new Contact("B","45678"));
        dbh.addContact(new Contact("C","6754435"));
        dbh.addContact(new Contact("D","423553425"));
        dbh.addContact(new Contact("E","73642545"));
        dbh.addContact(new Contact("F","987654434"));
        dbh.addContact(new Contact("G","6274476243"));
        dbh.addContact(new Contact("H","53223467"));
        dbh.addContact(new Contact("I","643687567"));
        dbh.addContact(new Contact("J","235346"));
        dbh.addContact(new Contact("K","86575685"));
        dbh.addContact(new Contact("L","09675745"));
        dbh.addContact(new Contact("M","8456347"));
        dbh.addContact(new Contact("N","252632463"));
        dbh.addContact(new Contact("O","124534654"));
        dbh.addContact(new Contact("P","4576474586"));

        List<Contact> contactList = dbh.getAllContacts();

        for(Contact contact: contactList){
            Log.d("check2", "onCreate: "+contact.getId()+ " "+contact.getName()+" "+contact.getPhoneNumber());
            contactArrayList.add(contact);
        }
    }
}
