package com.clayzhu.listviewdemo3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_book;
    private ListView list_app;

    private List<App> mData1 = null;
    private List<Book> mData2 = null;

    private MyAdapter<App> myAdapter1 = null;
    private MyAdapter<Book> myAdapter2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        list_book = findViewById(R.id.list_book);
        list_app = findViewById(R.id.list_app);

        //数据初始化
        mData1 = new ArrayList<App>();
        mData1.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData1.add(new App(R.mipmap.iv_icon_douban, "豆瓣"));
        mData1.add(new App(R.mipmap.iv_icon_zhifubao, "支付宝"));

        mData2 = new ArrayList<Book>();
        mData2.add(new Book("《第一行代码Android》", "郭霖"));
        mData2.add(new Book("《Android群英传》", "徐宜生"));
        mData2.add(new Book("《Android开发艺术探索》", "任玉刚"));

        //Adapter初始化
        myAdapter1 = new MyAdapter<App>((ArrayList<App>) mData1, R.layout.item_one) {
            @Override
            public void bindView(ViewHolder holder, App obj) {
                holder.setImageResource(R.id.img_aicon, obj.getaIcon());
                holder.setText(R.id.txt_aname, obj.getaName());
            }
        };

        myAdapter2 = new MyAdapter<Book>((ArrayList<Book>) mData2, R.layout.item_two) {
            @Override
            public void bindView(ViewHolder holder, Book obj) {
                holder.setText(R.id.txt_bname, obj.getbName());
                holder.setText(R.id.txt_bauthor, obj.getbAuthor());
            }
        };

        //ListView设置下Adapter
        list_book.setAdapter(myAdapter2);
        list_app.setAdapter(myAdapter1);
    }
}
