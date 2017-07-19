package com.owl_android.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @TiTle AnnotationUtil.java
 * @Package com.owl_android.annotations
 * @Description
 * @Date 2017-7-17
 * @Author siyuan
 * @Refactor
 * @Company ISoftStone ZHHB
 * <hr> OWL_android Project
 * No annotation or get/set methods will not trigger
 */
public class AnnotationUtil {
	public static OwlDataBean getParseAnnotationInfo(Object bean) {
		Class<?> clazz = bean.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getDeclaredMethods();

		OwlDataBean syDataBean = new OwlDataBean(bean);
		syDataBean.setBean(bean);

		List<OwlListBean> listBeanList = new ArrayList<>();
		List<OwlDetailBean> detailBeanList = new ArrayList<>();
		try {
			for(Field field : fields) {
				// scan all the fields and find annotation
				// 1.
				if(field.isAnnotationPresent(OwlList.class)){
					OwlListBean listBean = new OwlListBean();
					listBeanList.add(listBean);

					OwlList owlList = (OwlList) field.getAnnotation(OwlList.class);
					String getMethod = pareGetName(field.getName());
					for(Method tempMethod : methods) {
						if(getMethod.equals(tempMethod.getName())) {
							listBean.listEnum = owlList.owlListType();
							listBean.textSize = owlList.textSize();
							listBean.imageSize = owlList.imageSize();
							listBean.value = String.valueOf(tempMethod.invoke(bean));
							listBean.property = field.getName();
							break;
						}
					}
				}

				// 2.
				if(field.isAnnotationPresent(OwlDetail.class)){
					OwlDetailBean detailBean = new OwlDetailBean();
					detailBeanList.add(detailBean);

					OwlDetail owlDetail = (OwlDetail) field.getAnnotation(OwlDetail.class);
					String getMethod = pareGetName(field.getName());
					for(Method tempMethod : methods) {
						if(getMethod.equals(tempMethod.getName())) {
							detailBean.owlDetailName = owlDetail.owlDetailName();
							detailBean.detailEnum = owlDetail.owlDetailView();
							detailBean.textSize = owlDetail.textSize();
							detailBean.imageSize = owlDetail.imageSize();
							detailBean.value = String.valueOf(tempMethod.invoke(bean));
							detailBean.property = field.getName();
							detailBean.order = owlDetail.owlDetailOrder();
							break;
						}
					}
				}
			}
			// fill in TypeEnum
			syDataBean.setDetailBeanList(detailBeanList);
			syDataBean.setListBeanList(listBeanList);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return syDataBean;
	}

	/**
	 * ƴ��ĳ����get ����
	 * @param fldname
	 * @return
	 */
	public static String pareGetName(String fldname){
		if(null == fldname || "".equals(fldname)){
			return null;
		}
		String pro = "get"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);
		return pro;
	}
}
