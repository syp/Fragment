package com.example.screenlayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by stephen on 13-7-12.
 */
public class NavFragment extends Fragment {

    protected AdapterView.OnItemClickListener itemClickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NavItem item = (NavItem)parent.getAdapter().getItem(position);
                if("fragment".equals(item.getTargetType())){
                    //send out intent to FragActivity here
                    Intent intent = new Intent(getActivity(), FragActivity.class);
                    intent.putExtra("target",item.getTarget());
                    startActivity(intent);
                }else if("activity".equals(item.getTargetType())){
                    //send out intent to corresponding activity
                    try{
                        Class clazz = Class.forName("com.example.screenlayout."+item.getTarget());
                        Intent intent = new Intent(getActivity(), clazz);
                        startActivity(intent);
                    }catch (ClassNotFoundException exception){
                        Log.e("screenlayout",
                                "Cannot find Class com.example.screenlayout."+item.getTarget(),
                                exception);
                    }
                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nav_fragment, container, false);
        ListView navlist = (ListView)view.findViewById(R.id.frag_navlist);
        navlist.setAdapter(new NavListAdapter());
        navlist.setOnItemClickListener(itemClickListener);
        return view;
    }
}
