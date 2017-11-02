package com.le.slideanddraglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by damai on 17/10/12.
 */

public class DragListAdapter extends BaseAdapter {

    private List<String> mData;
    private LayoutInflater mInflater = null;
    private Context context;
    private OnDeleteViewClick mOnDeleteListner;
    private OnTopViewClick mOnTopListner;

    public DragListAdapter(Context context, List<String> data) {
        mData = data;
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
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

        TextView deleteView = (TextView) convertView.findViewById(R.id.deleteView);
        deleteView.setTag(position);
        deleteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mOnDeleteListner.onDelete((int)view.getTag());
            }
        });

        TextView topView = (TextView) convertView.findViewById(R.id.toTopView);
        topView.setTag(position);

        topView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mOnTopListner.onTop((int)view.getTag());
            }
        });

        return convertView;
    }

    public void setmOnDeleteListner(OnDeleteViewClick listner){
        mOnDeleteListner = listner;
    }

    interface OnDeleteViewClick{
        void onDelete(int position);
    }

    public void setData(List data){
        mData = data;
    }

    public List<String> getData(){
        return mData;
    }

    interface OnTopViewClick{
        void onTop(int position);
    }

    public void setOnTopListner(OnTopViewClick listner){
        mOnTopListner = listner;
    }

}

