package com.example.tom.finalexam;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class HostResultsActivity extends AppCompatActivity {

    private Host [] hostData;

    DBHandler dbHandler;

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_results);

        dbHandler = new DBHandler(this, null);

        String [] noHost = {"No hosts found!"};

        hostData = dbHandler.getHost();

        if (hostData != null){
            adapter = new HostResultsAdapter(this, hostData);
        } else {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noHost);
        }

        ListView listView = (ListView) findViewById(R.id.hostListView);

        listView.setAdapter(adapter);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
