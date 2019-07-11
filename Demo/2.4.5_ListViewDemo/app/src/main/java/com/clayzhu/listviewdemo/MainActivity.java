package com.clayzhu.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Animal> mData = null;
    private Context mContext;
    private AnimalAdapter mAdapter = null;
    private ListView list_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        list_animal = findViewById(R.id.list_animal);

        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headerView = inflater.inflate(R.layout.view_header, null, false);
        View footerView = inflater.inflate(R.layout.view_footer, null, false);
        //添加表头和表尾需要写在setAdapter方法调用之前！！！
        list_animal.addHeaderView(headerView);
        list_animal.addFooterView(footerView);

        mData = new LinkedList<Animal>();
        mData.add(new Animal("狗说", "你是狗么？", R.mipmap.ic_launcher));
        mData.add(new Animal("牛说", "你是牛么？", R.mipmap.ic_launcher));
        mData.add(new Animal("鸭说", "你是鸭么？", R.mipmap.ic_launcher));
        mData.add(new Animal("鱼说", "你是鱼么？", R.mipmap.ic_launcher));
        mData.add(new Animal("马说", "你是马么？", R.mipmap.ic_launcher));

        mAdapter = new AnimalAdapter((LinkedList<Animal>) mData, mContext);
        list_animal.setAdapter(mAdapter);

        list_animal.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(mContext, "你点击了第" + i + "项", Toast.LENGTH_SHORT).show();
    }
}
