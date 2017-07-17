package com.owl_android.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @TiTle AnnotationUtil.java
 * @Package com.owl_android.annotations
 * @Description
 * @Date 2017-7-17
 * @Author siyuan
 * @Refactor 
 * @Company ISoftStone ZHHB
 * <hr> OWL_android Project
 * 无注释或无get/set方法不进入解析
 */
public class AnnotationUtil {
	public static OwlDataBean getParseAnnotationInfo(Object bean) {
		OwlDataBean syDataBean = new OwlDataBean(bean);
		Map<OwlTypeEnum, String> dataBeanMap = new HashMap<>();
		Class<?> clazz = bean.getClass();
		try {
			Field[] fields = clazz.getDeclaredFields();
			Method[] methods = clazz.getDeclaredMethods();
			for(Field field : fields) {
				if(field.isAnnotationPresent(OwlList.class)){
					OwlList syList = (OwlList) field.getAnnotation(OwlList.class);
					String getMethod = pareGetName(field.getName());
					for(Method tempMethod : methods) {
						if(getMethod.equals(tempMethod.getName())) {
							dataBeanMap.put(syList.owl_type(), String.valueOf(tempMethod.invoke(bean)));
							break;
						}
					}
				}
			}
			syDataBean.setListType(dataBeanMap);
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
     * 解析获取Get方法
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
