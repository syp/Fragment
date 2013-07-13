package com.example.screenlayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.Date;

public class Layout2Activity extends Activity {

    private boolean useFrag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2_main);
        // initialize the fragment if there is layout2_frag2
        if(findViewById(R.id.layout2_frag2)!=null){
            FragmentManager fragManager = getFragmentManager();
            FragmentTransaction xact = fragManager.beginTransaction();
            xact.add(R.id.layout2_frag2, CustomFragment.newInstance(new Date()),"frag1");
            xact.commit();
            useFrag = true;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout2, menu);
        return true;
    }

    @Override
    public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
        String fragTarget = intent.getStringExtra("target");
        if(fragTarget != null && useFrag){
            FragmentManager fragmentManager = getFragmentManager();
            Fragment targetFrag = fragmentManager.findFragmentByTag(fragTarget);
            if(targetFrag==null){
                targetFrag = CustomFragment.newInstance(new Date());
            }
            FragmentTransaction xact = fragmentManager.beginTransaction();
            xact.replace(R.id.layout2_frag2, targetFrag, fragTarget);
            xact.addToBackStack(null);
            xact.commit();
            return;
        }else{
            super.startActivityFromFragment(fragment, intent, requestCode);
        }
    }

}
