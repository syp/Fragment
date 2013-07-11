package com.example.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stephen on 13-7-11.
 */
public class DatetimeFragment extends Fragment {

    private String time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null == time){
            time = new SimpleDateFormat("d MMM yyyy HH:mm:ss").format(new Date());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ((TextView)view.findViewById(R.id.datetime_text)).setText(time);
        return view;
    }
}
