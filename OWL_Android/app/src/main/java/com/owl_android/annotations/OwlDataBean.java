package com.owl_android.annotations;

import java.util.Map;

/**
 * @TiTle SYDataBean.java
 * @Package com.annotations
 * @Description 数据封装
 * @Date 2017-7-14
 * @Author siyuan
 * @Refactor 
 * @Company ISoftStone ZHHB
 * <hr> OWL_android Project
 */
public class OwlDataBean {
	private Object bean;
	private Map<OwlTypeEnum, String> listType;
	
	public OwlDataBean(Object bean) {
		this.bean = bean;
	}
	
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Map<OwlTypeEnum, String> getListType() {
		return listType;
	}

	public void setListType(Map<OwlTypeEnum, String> listType) {
		this.listType = listType;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(listType != null) {
			for(OwlTypeEnum key : listType.keySet()) {
				sb.append(key.toString() + " : " + listType.get(key) + "\n");
			}
		}
		return getClass().getSimpleName() + " parse " 
			+ bean.getClass().getSimpleName() + "...\n" + sb.toString();
	}
}
