package com.owl_android.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by syliud on 2017/7/17.
 */

public class OwlLayout extends LinearLayout{

    public OwlLayout(Context context) {
        super(context);
    }

    public OwlLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OwlLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OwlLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
