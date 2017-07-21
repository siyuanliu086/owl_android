package com.owl_android.annotations;

import com.owl_android.utils.R;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @TiTle OwlDetail.java
 * @Package com.owl_android.annotations
 * @Description described a detail style, the important is Order and View 
 * @Date 2017-7-17
 * @Author siyuan
 * @Refactor 
 * @Company ISoftStone ZHHB
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OwlDetail {
	String detailName();
	DetailEnum detailView() default DetailEnum.textview;
	int order();
	int nameSize() default 16;// default unit sp
	int valueSize() default 14;// default unit sp
	int imageSize() default 72;// default unit dp
	int nameColorRes() default R.color.deep_black;
	int valueColorRes() default R.color.deep_gray;
}
