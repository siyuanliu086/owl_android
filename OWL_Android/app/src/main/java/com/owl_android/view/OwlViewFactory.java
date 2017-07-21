package com.owl_android.view;

import android.content.Context;

import com.owl_android.view.detail.OwlDetailView;
import com.owl_android.view.listview.OwlListView;

import java.util.List;

/**
 *
 */
public class OwlViewFactory {
    public static final int OWL_RECYCLERVIEW = 0;
    public static final int OWL_LISTVIEW = 1;
    public static final int OWL_DETAILVIEW = 2;

    private Context mContext = null;

    private static OwlViewFactory instance;
    public static OwlViewFactory getInstance(Context context) {
        if(instance == null) {
            instance = new OwlViewFactory(context);
        }
        return instance;
    }

    private OwlViewFactory(Context context) {
        mContext = context;
    }

    public IOwlLayout getTargetView(int viewType, Object bean){
        if(OWL_DETAILVIEW == viewType) {
            OwlDetailView targetView = new OwlDetailView(mContext);
            return targetView.setAnnotationBean(bean);
        } else if(OWL_LISTVIEW == viewType) {
//            OwlListView targetView = new OwlListView(mContext);
//            List<Object> objectList = bean;
//            return targetView.setAnnotationBean(bean);
        }
        return  null;
    }

    public IOwlLayout getTargetListView(int viewType, List<? extends Object> beanList){
        if(OWL_DETAILVIEW == viewType) {
//            OwlDetailView targetView = new OwlDetailView(mContext);
//            return targetView.setAnnotationBean(bean);
        } else if(OWL_LISTVIEW == viewType) {
            OwlListView targetView = new OwlListView(mContext);
//            List<Object> objectList = beanList;
            return targetView.setAnnotationBean(beanList);
        }
        return  null;
    }

}
