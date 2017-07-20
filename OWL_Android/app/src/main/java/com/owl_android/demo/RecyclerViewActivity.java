package com.owl_android.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.owl_android.utils.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setTitle("RecyclerView");
        initData();
    }

    private void initData() {
        SimpleDateFormat df = new SimpleDateFormat("ss:SSS");

        List<City> dataList = new ArrayList<>();
        for(int i = 0; i < 100; i ++) {
            City city = new City();
            city.setCityName("城市"+i);
            city.setTime(df.format(new Date()));
            city.setContent("这是描述，OWL测试" + 1);
            dataList.add(city);
        }

//        OwlDetailView owlRecyclerView = (OwlDetailView) OwlViewFactory.getInstance().getTargetView(OwlViewFactory.OWL_DETAILVIEW);
    }
}
