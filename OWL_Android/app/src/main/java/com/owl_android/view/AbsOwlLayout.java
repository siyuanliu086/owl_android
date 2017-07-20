package com.owl_android.view;

import android.view.ViewGroup;

/**
 * @Package com.owl_android.view
 * @Description
 * @Date 2017/7/20
 * @Author siyuan
 * @Refactor
 * @Company ISoftStone ZHHB
 * @Project OWL_Android
 */

public interface AbsOwlLayout {

    /**
     * Define setAnnotationBean
     * @param object
     * @param <View>
     * @return ViewGroup
     */
//    public abstract <ViewGroup> ViewGroup setAnnotationBean(Object object);

    /**
     *
     * @return target ViewGroup
     */
    ViewGroup getTargetView();
}
