package com.owl_android.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.owl_android.utils.R;
import com.owl_android.view.recyclerview.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private DemoRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new DemoRecyclerAdapter(this, mDatas));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter.setOnItemClickLitener(new DemoRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "" + mDatas.get(position), Toast.LENGTH_SHORT).show();
                if(position == 0) {
                    goToRecyclerViewDemo();
                } else if(position == 1) {
                    goToRecyclerViewDemo();
                } else if(position == 2) {
                    goToDetailViewDemo();
                }
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private void goToDetailViewDemo() {
        startActivity(new Intent(MainActivity.this, DetailViewActivity.class));
    }

    private void goToRecyclerViewDemo() {
        startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
    }

    protected void initData() {
        mDatas = new ArrayList<>();
        mDatas.add("Recycler View");
        mDatas.add("列表页面");
        mDatas.add("详情页面");
    }


}
