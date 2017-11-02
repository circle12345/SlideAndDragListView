package com.le.slideanddraglistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainActivity extends Activity implements DragListAdapter.OnDeleteViewClick, DragListAdapter.OnTopViewClick {

    ListView mListView;
    DragListAdapter adapter;
    String[] items = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.list_view);
        adapter = new DragListAdapter(this, Arrays.asList(items));
        mListView.setAdapter(adapter);

        adapter.setmOnDeleteListner(this);
        adapter.setOnTopListner(this);
    }

    @Override
    public void onDelete(int position) {
        List<String> list = new ArrayList<>();
        for (int i=0 ; i < items.length; i++){
            if (i != position)
                list.add(items[i]);
        }
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTop(int position) {
        List<String> list = new ArrayList<>();
        for (int i=0 ; i < items.length; i++){
            if (i == position){
                String temp = items[0];
                items[0] = items[position];
                items[position] = temp;
            }
        }

        for (int i=0 ; i < adapter.getData().size(); i++){
            list.add(items[i]);
        }
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }
}
