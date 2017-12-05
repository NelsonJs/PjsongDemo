package com.pjsong.testing.pjsongdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pjsong.testing.pjsongdemo.inter.OnClickIndexRcyItem;
import com.pjsong.testing.pjsongdemo.pop.Pop1Activity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        List<String> list = new ArrayList<>();
        list.add("弹窗动画");
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        Adapter adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickIndexRcyItem(new OnClickIndexRcyItem() {
            @Override
            public void clickItem(int position) {
                Intent intent = new Intent(MainActivity.this, Pop1Activity.class);
                startActivity(intent);
            }
        });
    }
}
