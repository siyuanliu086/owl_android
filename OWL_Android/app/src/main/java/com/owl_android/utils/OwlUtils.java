package com.owl_android.utils;

import android.content.Context;

/**
 * @Package com.owl_android.utils
 * @Description
 * @Date 2017/7/20
 * @Author siyuan
 * @Refactor
 * @Company ISoftStone ZHHB
 * @Project OWL_Android
 */

public class OwlUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
