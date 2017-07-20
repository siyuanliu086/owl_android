package com.owl_android.annotations;


/**
 * @TiTle OwlDetailBean.java
 * @Package com.owl_android.annotations
 * @Description One Detail Unit
 * @Date 2017-7-18
 * @Author siyuan
 * @Refactor 
 * @Company ISoftStone ZHHB
 */
public class OwlListBean {
	public ListEnum listEnum;
	public int titleSize;
	public int contentSize;
	public int timeSize;
	public int imageSize;
//	public int textColor;
	public String property = "";
	public String value = "";
	
	@Override
	public String toString() {
		String imageStr = listEnum == ListEnum.image ? " | imageSize(dp):" + imageSize : " | nameSize(sp):" + titleSize;
		return property + ":" + value + " | listEnum:" + listEnum.toString() + imageStr;
	}
}
