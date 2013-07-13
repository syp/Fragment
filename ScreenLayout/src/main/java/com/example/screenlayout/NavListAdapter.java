package com.example.screenlayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stephen on 13-7-11.
 */
public class NavListAdapter extends BaseAdapter{
    //list item data
    private ArrayList<NavItem> listData = new ArrayList<NavItem>();

    public NavListAdapter(){
        listData.add(new NavItem("Frag1", "frag1", "fragment"));
        listData.add(new NavItem("Frag2", "frag2", "fragment"));
        listData.add(new NavItem("LayoutActivity", "LayoutActivity", "activity"));
        listData.add(new NavItem("Layout2Activity", "Layout2Activity", "activity"));
        listData.add(new NavItem("Layout3Activity", "Layout3Activity", "activity"));
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(null == view){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.listitem, viewGroup, false);
        }
        ((TextView)view.findViewById(R.id.list_item_title)).setText(listData.get(i).getTitle());
        return view;
    }

}
