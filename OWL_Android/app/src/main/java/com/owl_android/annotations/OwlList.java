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
	public ListEnum listType() default ListEnum.hidden;
	public int nameSize() default 16;// default unit sp
	public int contentSize() default 14;// default unit sp
	public int timeSize() default 14;// default unit sp
	public int imageSize() default 72;// default unit dp
//	public int textColor() default Color.BLACK.;
}
