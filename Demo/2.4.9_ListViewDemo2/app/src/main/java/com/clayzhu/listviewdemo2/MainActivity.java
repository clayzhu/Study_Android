package com.clayzhu.listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    /**
     * ListView 无数据时显示
     */
    private TextView txt_empty;
    /**
     * 添加一条记录
     */
    private Button btn_add;
    private int flag = 1;
    /**
     * 往第五列插入一条数据
     */
    private Button btn_add2;
    /**
     * 根据对象删除数据
     */
    private Button btn_remove;
    private Data mData_5;
    /**
     * 根据游标删除数据
     */
    private Button btn_remove2;
    /**
     * 移除所有记录
     */
    private Button btn_clear;

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

        // ListView 无数据时显示
        txt_empty = findViewById(R.id.txt_empty);
        txt_empty.setText("暂无数据～");
        list_one.setEmptyView(txt_empty);

        // 添加一条记录
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        // 往第五列插入一条数据
        btn_add2 = findViewById(R.id.btn_add2);
        btn_add2.setOnClickListener(this);

        // 根据对象删除数据
        btn_remove = findViewById(R.id.btn_remove);
        btn_remove.setOnClickListener(this);

        // 根据游标删除数据
        btn_remove2 = findViewById(R.id.btn_remove2);
        btn_remove2.setOnClickListener(this);

        // 移除所有记录
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:  // 添加一条记录
                mAdapter.add(new Data(R.mipmap.ic_icon_qitao, "给猪哥跪了～～～ x " + flag));
                flag ++;
                break;
            case R.id.btn_add2: // 往第五列插入一条数据
                if (mAdapter.getCount() < 4) {
                    return;
                }
                mAdapter.add(4, new Data(R.mipmap.ic_icon_qitao, "给猪哥跪了～～～ x " + flag));
                flag ++;
                break;
            case R.id.btn_remove:   // 根据对象删除数据
                if (mAdapter.getCount() < 5) {
                    return;
                }
                mData_5 = mData.get(4);
                mAdapter.remove(mData_5);
                break;
            case R.id.btn_remove2:  // 根据游标删除数据
                if (mAdapter.getCount() < 3) {
                    return;
                }
                mAdapter.remove(2);
                break;
            case R.id.btn_clear:    // 移除所有记录
                mAdapter.clear();
                break;
        }
    }
}
