package com.owl_android.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OwlList {
	public ListEnum owlListType() default ListEnum.hidden;
	public int textSize() default 16;// default unit sp
	public int imageSize() default 72;// default unit dp
//	public int textColor() default Color.BLACK.;
}
