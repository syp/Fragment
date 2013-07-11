package com.example.simplefragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class Main extends Activity {

    private static final String FRAG_TAG="simplefragment";
    private static final String FRAG_TAG2="simplefragment2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        add();
        Button addFragBtn = (Button) findViewById(R.id.add_frag_btn);
        addFragBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });

    }

    private void update(){
        Date time = new Date();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction xact = manager.beginTransaction();
        xact.replace(R.id.simple_frame, SimpleFragment.newInstance(time), FRAG_TAG);
        xact.replace(R.id.simple_frame2, SimpleFragment.newInstance(time), FRAG_TAG2);
        xact.addToBackStack(null);
        xact.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        xact.commit();
    }

    private void add(){
        //implementation to add fragment to activity main layout
        Date time = new Date();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction xact = manager.beginTransaction();
        if (null == manager.findFragmentByTag(FRAG_TAG)){
            SimpleFragment frag = SimpleFragment.newInstance(time);
            frag.setRetainInstance(true); // set fragment to be retained when orientation changes
            xact.add(R.id.simple_frame, frag, FRAG_TAG);
        }
        if (null == manager.findFragmentByTag(FRAG_TAG2)){
            xact.add(R.id.simple_frame2, SimpleFragment.newInstance(time), FRAG_TAG2);
        }
        xact.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
