package com.example.screenlayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by stephen on 13-7-12.
 */
public class FragActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragactivity);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.frag_placement, CustomFragment.newInstance(new Date()));
        ft.commit();
    }
}
