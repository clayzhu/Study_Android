package com.clayzhu.framelayoutdemo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //初始化变量,帧布局
    FrameLayout frame = null;
    //自定义一个用于定时更新UI界面的handler类对象
    Handler handler = new Handler() {
        int i = 0;

        @Override
        public void handleMessage(@NonNull Message msg) {
            //判断信息是否为本应用发出的
            if (msg.what == 0x123) {
                i ++;
                move(i % 8);
            }
            super.handleMessage(msg);
        }
    };

    //定义走路时切换图片的方法
    void move(int i) {
        Drawable a = getResources().getDrawable(R.mipmap.s_1);
        Drawable b = getResources().getDrawable(R.mipmap.s_2);
        Drawable c = getResources().getDrawable(R.mipmap.s_3);
        Drawable d = getResources().getDrawable(R.mipmap.s_4);
        Drawable e = getResources().getDrawable(R.mipmap.s_5);
        Drawable f = getResources().getDrawable(R.mipmap.s_6);
        Drawable g = getResources().getDrawable(R.mipmap.s_7);
        Drawable h = getResources().getDrawable(R.mipmap.s_8);
        //通过setForeground来设置前景图像
        switch (i) {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.myframe);
        //定义一个定时器对象,定时发送信息给handler
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 170);
    }
}
