package com.owl_android.view.detail;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.owl_android.annotations.AnnotationUtil;
import com.owl_android.annotations.OwlDataBean;
import com.owl_android.annotations.OwlDetailBean;
import com.owl_android.utils.OwlUtils;
import com.owl_android.utils.R;
import com.owl_android.view.AbsOwlLayout;

import java.util.List;

import static com.owl_android.annotations.DetailEnum.textarea;

/**
 * @Package com.owl_android.view.detail
 * @Description show a detail View, default extends form LinearLayout
 * @Date 2017/7/20
 * @Author siyuan
 * @Refactor
 * @Company ISoftStone ZHHB
 * @Project OWL_Android
 */

public class OwlDetailView implements AbsOwlLayout {
    private LinearLayout contentLayout;
    private OwlDetailView detailView = this;
    private Context mContext = null;

    public OwlDetailView(Context context) {
        mContext = context;
        contentLayout = new LinearLayout(context);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
    }

    public OwlDetailView setAnnotationBean(Object object) {
        OwlDataBean owlDataBean = AnnotationUtil.getParseAnnotationInfo(object);
        List<OwlDetailBean> detailBeenList = owlDataBean.getDetailBeanList();

        int dip48 = OwlUtils.dip2px(mContext, 48);
        for (OwlDetailBean detailBean : detailBeenList) {
            // out layout
            LinearLayout nameLayout = new LinearLayout(mContext);
            nameLayout.setBackgroundColor(Color.WHITE);
            nameLayout.setOrientation(LinearLayout.HORIZONTAL);

            // name
            TextView nameTextview = new TextView(mContext);
            nameTextview.setTextSize(TypedValue.COMPLEX_UNIT_SP, detailBean.nameSize);
            nameTextview.setTextColor(mContext.getResources().getColor(detailBean.nameColorRes));
            nameTextview.setText(detailBean.owlDetailName);
            nameTextview.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            nameLayout.addView(nameTextview);
            LinearLayout.LayoutParams nameParams = (LinearLayout.LayoutParams) nameTextview.getLayoutParams();
            nameParams.gravity = Gravity.START | Gravity.CENTER_VERTICAL;
            nameParams.weight = 1;
            nameParams.height = dip48;
            nameParams.leftMargin = dip48 / 6;

            // value
            if (detailBean.detailEnum == textarea) {
                // do not catch focus at the first
                nameLayout.setOrientation(LinearLayout.VERTICAL);
                nameLayout.setFocusable(true);
                nameLayout.setFocusableInTouchMode(true);

                // add a line
                View lineView = new View(mContext);
                lineView.setBackgroundColor(mContext.getResources().getColor(R.color.lines_color));
                nameLayout.addView(lineView);
                LinearLayout.LayoutParams lineParams = (LinearLayout.LayoutParams) lineView.getLayoutParams();
                lineParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
                lineParams.height = 2;
                lineParams.leftMargin = dip48 / 6;
                lineParams.rightMargin = dip48 / 6;
                lineParams.topMargin = dip48 / 8;
                lineParams.bottomMargin = dip48 / 8;

                // add EditText
                EditText valueEdittext = new EditText(mContext);
                valueEdittext.setTextSize(TypedValue.COMPLEX_UNIT_SP, detailBean.valueSize);
                valueEdittext.setTextColor(mContext.getResources().getColor(detailBean.valueColorRes));
                valueEdittext.setText(detailBean.value);
                valueEdittext.setGravity(Gravity.START | Gravity.TOP);
                valueEdittext.setBackground(null);
                nameLayout.addView(valueEdittext);
                LinearLayout.LayoutParams valueParams = (LinearLayout.LayoutParams) valueEdittext.getLayoutParams();
                valueParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
                valueParams.weight = 1;
                valueParams.height = dip48 * 4;
                valueParams.leftMargin = dip48 / 6;
                valueParams.rightMargin = dip48 / 6;
            } else {
                TextView valuetextview = new TextView(mContext);
                valuetextview.setTextSize(TypedValue.COMPLEX_UNIT_SP, detailBean.valueSize);
                valuetextview.setTextColor(mContext.getResources().getColor(detailBean.valueColorRes));
                valuetextview.setText(detailBean.value);
                valuetextview.setGravity(Gravity.END | Gravity.CENTER_VERTICAL);
                nameLayout.addView(valuetextview);
                LinearLayout.LayoutParams valueParams = (LinearLayout.LayoutParams) valuetextview.getLayoutParams();
                valueParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
                valueParams.weight = 1;
                valueParams.height = dip48;
                valueParams.rightMargin = dip48 / 6;
            }
            contentLayout.addView(nameLayout);
            LinearLayout.LayoutParams contentLayoutParams = (LinearLayout.LayoutParams) nameLayout.getLayoutParams();
            contentLayoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
            contentLayoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
            contentLayoutParams.bottomMargin = dip48 / 4;
        }
        return detailView;
    }

    /**
     * Define setAnnotationBean
     *
     * @return ViewGroup
     */
    @Override
    public LinearLayout getTargetView() {
        return contentLayout;
    }
}
