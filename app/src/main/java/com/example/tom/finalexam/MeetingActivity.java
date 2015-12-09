package com.example.tom.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MeetingActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText descriptionEditText;
    EditText locationEditText;
    EditText dateEditText;
    EditText timeEditText;
    EditText hostidEditText;

    Intent intent;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);
        locationEditText = (EditText) findViewById(R.id.locationEditText);
        dateEditText = (EditText) findViewById(R.id.dateEditText);
        timeEditText = (EditText) findViewById(R.id.timeEditText);
        hostidEditText = (EditText) findViewById(R.id.hostidEditText);

        dbHandler = new DBHandler(this, null);

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

    public void addMeeting (View view){

        String name = nameEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        String location = locationEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String hostid = hostidEditText.getText().toString();

        if (name.trim().equals("") || description.trim().equals("") ||
                location.trim().equals("") || date.trim().equals("")
                || time.trim().equals("") || hostid.trim().equals(""))
            Toast.makeText(this, "Please enter a name, description, location," +
                            "date, time, or host id!",
                    Toast.LENGTH_LONG).show();
        else {
            dbHandler.addMeeting(name, description, location, date, time, hostid);
            Toast.makeText(this, "Meeting added!",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void getMeeting(View view) {
        intent = new Intent(this, MeetingResultsActivity.class);
        startActivity(intent);
    }
}
