package com.clayzhu.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class AnimalAdapter extends BaseAdapter {

    private LinkedList<Animal> mData;
    private Context mContext;

    public AnimalAdapter(LinkedList<Animal> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal, viewGroup, false);
            holder = new ViewHolder();
            holder.img_icon = view.findViewById(R.id.img_icon);
            holder.txt_aName = view.findViewById(R.id.txt_aName);
            holder.txt_aSpeak = view.findViewById(R.id.txt_aSpeak);
            view.setTag(holder);    //将Holder存储到view中
        }

        holder.img_icon.setBackgroundResource(mData.get(i).getaIcon());
        holder.txt_aName.setText(mData.get(i).getaName());
        holder.txt_aSpeak.setText(mData.get(i).getaSpeak());
        return view;
    }

    static class ViewHolder {
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aSpeak;
    }
}
