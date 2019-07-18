package com.clayzhu.listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    /**
     * ListView 无数据时显示
     */
    private TextView txt_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        bindViews();
        mData = new LinkedList<Data>();
        mAdapter = new MyAdapter(mContext, (LinkedList<Data>) mData);
        list_one.setAdapter(mAdapter);
    }

    private void bindViews() {
        list_one = findViewById(R.id.list_one);

        txt_empty = findViewById(R.id.txt_empty);
        txt_empty.setText("暂无数据～");
        list_one.setEmptyView(txt_empty);
    }
}
