package com.owl_android.annotations;

import java.util.List;

/**
 * @TiTle SYDataBean.java
 * @Package com.annotations
 * @Description Bean with annotation info
 * @Date 2017-7-14
 * @Author siyuan
 * @Refactor 
 * @Company ISoftStone ZHHB
 * <hr> OWL_android Project
 */
public class OwlDataBean {
	private Object bean;
	// detail info
	private List<OwlDetailBean> detailBeanList;
	// list info
	private List<OwlListBean> listBeanList;
	
	public OwlDataBean(Object bean) {
		this.bean = bean;
	}
	
	public Object getBean() {
		return bean;
	}
	
	public void setBean(Object bean) {
		this.bean = bean;
	}
	
	public List<OwlDetailBean> getDetailBeanList() {
		return detailBeanList;
	}

	public void setDetailBeanList(List<OwlDetailBean> detailBeanList) {
		this.detailBeanList = detailBeanList;
	}

	public List<OwlListBean> getListBeanList() {
		return listBeanList;
	}

	public void setListBeanList(List<OwlListBean> listBeanList) {
		this.listBeanList = listBeanList;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(detailBeanList != null) {
			for(OwlDetailBean bean : detailBeanList) {
				sb.append(bean.toString() + "\n");
			}
		}
		if(listBeanList != null) {
			sb.append("\n");
			for(OwlListBean bean : listBeanList) {
				sb.append(bean.toString() + "\n");
			}
		}
		return getClass().getSimpleName() + " parse " 
			+ bean.getClass().getSimpleName() + "...\n" + sb.toString();
	}
}
