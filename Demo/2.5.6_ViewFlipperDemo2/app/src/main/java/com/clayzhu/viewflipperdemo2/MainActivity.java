package com.clayzhu.viewflipperdemo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper vflp_help;

    private int[] resId = {R.mipmap.ic_help_view_1, R.mipmap.ic_help_view_2, R.mipmap.ic_help_view_3, R.mipmap.ic_help_view_4};

    private float startX;
    private boolean isChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vflp_help = findViewById(R.id.vflp_help);
        //动态导入添加子View
        for (int i = 0; i < resId.length; i ++) {
            vflp_help.addView(getImageView(resId[i]));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                isChange = true;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isChange) {
                    if (event.getX() > startX) {    // 向右滑动，看前一页
                        vflp_help.setInAnimation(this, R.anim.left_in);
                        vflp_help.setOutAnimation(this, R.anim.left_out);
                        vflp_help.showPrevious();
                    } else if (startX > event.getX()) { // 向左滑动，看后一页
                        vflp_help.setInAnimation(this, R.anim.right_in);
                        vflp_help.setOutAnimation(this, R.anim.right_out);
                        vflp_help.showNext();
                    }
                    isChange = false;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId) {
        ImageView img = new ImageView(this);
        img.setBackgroundResource(resId);
        return img;
    }
}
