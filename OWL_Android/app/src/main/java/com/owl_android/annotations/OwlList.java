package com.owl_android.annotations;

import com.owl_android.utils.R;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OwlList {
	ListEnum listType() default ListEnum.hidden;
	int nameSize() default 16;// default unit sp
	int contentSize() default 14;// default unit sp
	int timeSize() default 14;// default unit sp
	int imageSize() default 72;// default unit dp
	int textColorRes() default R.color.deep_gray;
}
