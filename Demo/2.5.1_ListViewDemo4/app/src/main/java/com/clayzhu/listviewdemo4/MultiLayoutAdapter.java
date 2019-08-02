package com.clayzhu.listviewdemo4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class MultiLayoutAdapter extends BaseAdapter {

    //定义两个类别标志
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;

    private Context mContext;
    private ArrayList<Object> mData = null;

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
