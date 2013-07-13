package com.example.screenlayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stephen on 13-7-11.
 */
public class CustomFragment extends Fragment{

    private String datetime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // implement view of fragment
        View view = inflater.inflate(R.layout.fragment, container, false);
        ((TextView)view.findViewById(R.id.datetime_text)).setText(datetime);
        return view;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null == savedInstanceState){
            savedInstanceState = getArguments();
        }
        if(null != savedInstanceState){
            datetime = savedInstanceState.getString("DateTimeText");
        }
        if(null == datetime){
            datetime = formatTime(new Date());
        }
    }

    public static CustomFragment newInstance(Date time){
        CustomFragment instance = new CustomFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DateTimeText", formatTime(time));
        instance.setArguments(bundle);
        return instance;
    }

    private static String formatTime(Date time){
        if(time!=null){
            return new SimpleDateFormat("d MMM yyyy HH:mm:ss").format(time);
        }else{
            return null;
        }
    }
}
