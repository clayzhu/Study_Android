package com.clayzhu.listviewdemo2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;

    public MyAdapter(Context mContext, LinkedList<Data> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
            holder = new ViewHolder();
            holder.img_icon = view.findViewById(R.id.img_icon);
            holder.txt_content = view.findViewById(R.id.txt_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.img_icon.setImageResource(mData.get(i).getImgId());
        holder.txt_content.setText(mData.get(i).getContent());
        return null;
    }

    private class ViewHolder {
        ImageView img_icon;
        TextView txt_content;
    }
}
