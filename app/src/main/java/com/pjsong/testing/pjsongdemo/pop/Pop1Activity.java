package com.pjsong.testing.pjsongdemo.pop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pjsong.testing.pjsongdemo.R;

public class Pop1Activity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_1_);

        initView();
        initListener();

    }

    private void initView() {
        textView = findViewById(R.id.tv);
        linearLayout = findViewById(R.id.ll);
        imageView = findViewById(R.id.iv);
        bg = findViewById(R.id.bg);
    }

    private void initListener() {
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                showPop_1();
                break;
        }

    }

    private void showPop_1() {

        int anim = 0;
        if (linearLayout.getVisibility() ==View.GONE){
            anim = R.anim.poup_out;
        }else {
            anim = R.anim.popup_in;
        }
        Animation animation = AnimationUtils.loadAnimation(Pop1Activity.this,
                anim);
        linearLayout.startAnimation(animation);
        if (linearLayout.getVisibility() ==View.GONE){
            bg.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
        }else {
            bg.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
        }
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                linearLayout.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
