package com.example.tom.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Tom on 12/8/2015.
 */
public class HostResultsAdapter extends ArrayAdapter<Host>{

    Host host;

    TextView emailTextView;

    public HostResultsAdapter(Context context, Host[] objects){
        super(context, R.layout.custom_row_host, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View hostView = inflater.inflate(R.layout.custom_row_host, parent, false);

        host = getItem(position);

        emailTextView = (TextView) hostView.findViewById(R.id.emailTextView);

        emailTextView.setText(host.getEmail());

        return hostView;
    }
}
