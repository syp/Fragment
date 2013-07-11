package com.example.simplefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stephen on 13-7-11.
 */
public class SimpleFragment extends Fragment {

    private String time;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simplefragment, container, false);
        ((TextView)view.findViewById(R.id.datetime_text)).setText(time);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == savedInstanceState){
            savedInstanceState = getArguments();
        }
        if (null != savedInstanceState){
            time = savedInstanceState.getString("datetime");
        }
        if(null == time){
            time = new SimpleDateFormat("d MMM yyyy HH:mm:ss").format(new Date());
        }
    }

    public static SimpleFragment newInstance(Date time){
        Bundle input = new Bundle();
        input.putString("datetime", getDateTimeString(time));
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(input);
        return fragment;
    }

    private static String getDateTimeString(Date time){
        return new SimpleDateFormat("d MMM yyyy HH:mm:ss").format(time);
    }
}
