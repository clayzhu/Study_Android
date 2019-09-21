package com.clayzhu.drawerlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawer_layout;
    private ListView list_left_drawer;
    private ArrayList<Item> menuLists;
    private MyAdapter<Item> myAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout = findViewById(R.id.drawer_layout);
        list_left_drawer = findViewById(R.id.list_left_drawer);

        menuLists = new ArrayList<>();
        menuLists.add(new Item(R.mipmap.iv_menu_realtime, "实时信息"));
        menuLists.add(new Item(R.mipmap.iv_menu_alert, "提醒通知"));
        menuLists.add(new Item(R.mipmap.iv_menu_trace, "活动路线"));
        menuLists.add(new Item(R.mipmap.iv_menu_settings, "相关设置"));
        myAdapter = new MyAdapter<Item>(menuLists, R.layout.item_list) {
            @Override
            public void bindView(ViewHolder holder, Item obj) {
                holder.setImageResource(R.id.img_icon, obj.getIconId());
                holder.setText(R.id.txt_content, obj.getIconName());
            }
        };
        list_left_drawer.setAdapter(myAdapter);
        list_left_drawer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position).getIconName());
        contentFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content, contentFragment).commit();
        drawer_layout.closeDrawer(list_left_drawer);
    }
}
