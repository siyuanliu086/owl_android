package com.owl_android.view;
import android.view.ViewGroup;

public interface IOwlLayoutCallback {
    /**
     * 解析完成回调
     * @param targetView
     */
    ViewGroup onParsingCompleted(Object bean);
}
