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
				// 1.LIST
				if(field.isAnnotationPresent(OwlList.class)){
					OwlListBean listBean = new OwlListBean();
					listBeanList.add(listBean);
					
					OwlList owlList = field.getAnnotation(OwlList.class);
					String getMethod = pareGetName(field.getName());
					for(Method tempMethod : methods) {
						if(getMethod.equals(tempMethod.getName())) {
							listBean.listEnum = owlList.listType();
							listBean.titleSize = owlList.nameSize();
							listBean.contentSize = owlList.contentSize();
							listBean.contentSize = owlList.timeSize();
							listBean.imageSize = owlList.imageSize();
                            listBean.textColorRes = owlList.textColorRes();
							listBean.value = String.valueOf(tempMethod.invoke(bean));
							listBean.property = field.getName();
							break;
						}
					}
				}
				
				// 2.DETAIL
				if(field.isAnnotationPresent(OwlDetail.class)){
					OwlDetailBean detailBean = new OwlDetailBean();
					detailBeanList.add(detailBean);
					
					OwlDetail owlDetail = field.getAnnotation(OwlDetail.class);
					String getMethod = pareGetName(field.getName());
					for(Method tempMethod : methods) {
						if(getMethod.equals(tempMethod.getName())) {
							detailBean.owlDetailName = owlDetail.detailName();
							detailBean.detailEnum = owlDetail.detailView();
							detailBean.nameSize = owlDetail.nameSize();
							detailBean.valueSize = owlDetail.valueSize();
							detailBean.imageSize = owlDetail.imageSize();
                            detailBean.nameColorRes = owlDetail.nameColorRes();
                            detailBean.valueColorRes = owlDetail.valueColorRes();
							detailBean.value = String.valueOf(tempMethod.invoke(bean));
							detailBean.property = field.getName();
							detailBean.order = owlDetail.order();
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
     * 构造Get方法
     * @param fldname
     * @return
     */
    private static String pareGetName(String fldname){
        if(null == fldname || "".equals(fldname)){
            return null;
        }
        String pro = "get"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);
        return pro;
    }
}
