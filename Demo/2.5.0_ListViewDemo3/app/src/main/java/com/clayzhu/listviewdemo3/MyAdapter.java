package com.clayzhu.listviewdemo3;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MyAdapter<T> extends BaseAdapter {

    private Context mContext;
    private LinkedList<T> mData;

    public MyAdapter(Context mContext, LinkedList<T> mData) {
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
//            view = LayoutInflater.from(mContext).inflate(R.layout.item_list, viewGroup, false);
//            holder = new ViewHolder();
//            holder.img_icon = view.findViewById(R.id.img_icon);
//            holder.txt_content = view.findViewById(R.id.txt_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//        holder.img_icon.setImageResource(mData.get(i).getImgId());
//        holder.txt_content.setText(mData.get(i).getContent());
        return view;
    }

    public void add(T data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void add(int position, T data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(T data) {
        if (mData != null) {
            mData.remove(data);
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (mData != null) {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        private SparseArray<View> mViews;   //存储ListView 的 item中的View
        private View item;  //存放convertView
        private int position;   //游标
        private Context context;    //Context上下文

        //构造方法，完成相关初始化
        private ViewHolder(Context context, ViewGroup parent, int layoutRes) {
            mViews = new SparseArray<>();
            this.context = context;
            View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }

        ImageView img_icon;
        TextView txt_content;
    }
}
