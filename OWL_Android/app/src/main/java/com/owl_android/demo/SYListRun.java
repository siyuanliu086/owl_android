package com.owl_android.demo;

import com.owl_android.annotations.AnnotationUtil;
import com.owl_android.annotations.City;
import com.owl_android.annotations.OwlDataBean;

public class SYListRun {
	public static void main(String[] args) {
		com.owl_android.annotations.City city = new City();
		OwlDataBean bean = AnnotationUtil.getParseAnnotationInfo(city);
		System.out.println(bean);
	}
}
