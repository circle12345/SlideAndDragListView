package com.le.slideanddraglistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends Activity {

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
    }

}
