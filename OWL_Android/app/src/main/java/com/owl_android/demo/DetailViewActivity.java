package com.owl_android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout;

import com.owl_android.utils.R;
import com.owl_android.view.OwlViewFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailViewActivity extends Activity {
    private LinearLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        setTitle("DetailView");
        constraintLayout = (LinearLayout) findViewById(R.id.constraintLayout);
        constraintLayout.setOrientation(LinearLayout.VERTICAL);
        initData();
    }

    private void initData() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        City city = new City();
        city.setCityName("北京市");
        city.setTime(df.format(new Date()));
        city.setContent("这是描述，OWL测试" + 1);

        // 构建
        LinearLayout owlDetailView = (LinearLayout) (OwlViewFactory.getInstance(this)
                .getTargetView(OwlViewFactory.OWL_DETAILVIEW, city).getTargetView());
        constraintLayout.addView(owlDetailView,
                new LinearLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

    }
}
