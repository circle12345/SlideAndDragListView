package com.le.slideanddraglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by damai on 17/10/12.
 */

public class DragListAdapter extends BaseAdapter {

    private List<String> mData;
    private LayoutInflater mInflater = null;

    public DragListAdapter(Context context, List<String> data) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.simple_list_item, null);
        }

        TextView info = (TextView) convertView.findViewById(R.id.textView);
        info.setText(mData.get(position));

        return convertView;
    }

}

