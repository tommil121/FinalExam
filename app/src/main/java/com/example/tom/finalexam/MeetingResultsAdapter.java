package com.example.tom.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Tom on 12/8/2015.
 *
public class MeetingResultsAdapter extends ArrayAdapter<Meeting>{

    Meeting meeting;

    TextView nameTextView;
    TextView descriptionTextView;
    TextView locationTextView;
    TextView dateTextView;
    TextView timeTextView;
    TextView hostidTextView;

    /*public MeetingResultsAdapter(Context context, Meeting[] objects){
        super(context, R.layout.custom_row_meeting, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View guitarView = inflater.inflate(R.layout.custom_row_meeting, parent, false);

        meeting = getItem(position);

        return messageView;
    }
}*/
