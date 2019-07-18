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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                mAdapter.add(new Data(R.mipmap.ic_icon_qitao, "给猪哥跪了～～～ x " + flag));
                flag ++;
                break;
        }
    }
}
