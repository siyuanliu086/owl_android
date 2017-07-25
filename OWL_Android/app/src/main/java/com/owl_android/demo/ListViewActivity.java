package com.owl_android.demo;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.owl_android.utils.R;
import com.owl_android.view.OwlViewFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private LinearLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        setTitle("DetailView");
        mLayout = (LinearLayout) findViewById(R.id.constraintLayout);
        initData();
    }

    private void initData() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

        List<City> cityList = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            City city = new City();
            city.setCityName("北京市" + i);
            city.setTime(df.format(new Date()));
            city.setImageUrl("https://github.com/siyuanliu086/owl_android/raw/master/showicon/owl_android.png");
            city.setContent("owl is an injection framework which works in android\n这是描述，OWL测试" + i);
            cityList.add(city);
        }
        // 构建
        ListView owlListView = (ListView) OwlViewFactory.getInstance(this)
                .getTargetListView(OwlViewFactory.OWL_LISTVIEW, cityList).getTargetView();
//                .getTargetListView(OwlViewFactory.OWL_LISTVIEW, cityList, OwlUtils.dip2px(this, 10)).getTargetView();
        mLayout.addView(owlListView,
                new LinearLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        // 回调形式待实现
//        IOwlLayout detailFactory = OwlViewFactory.getInstance(this).getTargetView(OwlViewFactory.OWL_DETAILVIEW, city);
//        constraintLayout.addView(owlDetailView,
//                new LinearLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

    }
}
