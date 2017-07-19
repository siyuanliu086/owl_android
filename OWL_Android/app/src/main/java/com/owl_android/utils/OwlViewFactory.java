package com.owl_android.utils;

import android.view.View;

/**
 * Created by syliud on 2017/7/17.
 */

public class OwlViewFactory {
    public static final int OWLVIEW_RECYCLERVIEW = 0;
    public static final int OWLVIEW_LISTVIEW = 1;
    public static final int OWLVIEW_DETAILVIEW = 2;

    private static OwlViewFactory instance;
    public static OwlViewFactory getInstance() {
        if(instance == null) {
            instance = new OwlViewFactory();
        }
        return instance;
    }

    public View getTargetView(int viewType){
        View targetView = null;
        switch (viewType) {
            case OWLVIEW_RECYCLERVIEW:
                break;
            case OWLVIEW_LISTVIEW:
                break;
            case OWLVIEW_DETAILVIEW:
                break;
        }
        return  targetView;
    }
}
