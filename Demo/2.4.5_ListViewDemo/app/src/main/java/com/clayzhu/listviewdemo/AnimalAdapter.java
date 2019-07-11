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
        view = LayoutInflater.from(mContext).inflate(R.layout.item_list_animal, viewGroup, false);
        ImageView img_icon = view.findViewById(R.id.img_icon);
        TextView txt_aName = view.findViewById(R.id.txt_aName);
        TextView txt_aSpeak = view.findViewById(R.id.txt_aSpeak);

        img_icon.setBackgroundResource(mData.get(i).getaIcon());
        txt_aName.setText(mData.get(i).getaName());
        txt_aSpeak.setText(mData.get(i).getaSpeak());
        return view;
    }
}
