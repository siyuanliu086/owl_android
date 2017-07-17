package com.owl_android.annotations;

public class SYListRun {
	public static void main(String[] args) {
		City city = new City();
		OwlDataBean bean = AnnotationUtil.getParseAnnotationInfo(city);
		System.out.println(bean);
	}
}
