package com.owl_android.annotations;

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
	public String owlDetailName();
	public DetailEnum owlDetailView() default DetailEnum.textview;
	public int owlDetailOrder();
	public int textSize() default 16;// default unit sp
	public int imageSize() default 72;// default unit dp
	public int textColor() default 16;
}
