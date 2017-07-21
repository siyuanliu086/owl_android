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

public interface IOwlLayout {

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

    /**
     * 解析完成回调
     * @param targetView
     */
    ViewGroup onParsingCompleted(Object bean);
}
