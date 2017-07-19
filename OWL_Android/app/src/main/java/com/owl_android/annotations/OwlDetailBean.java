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
public class OwlDetailBean {
	public String owlDetailName;
	public DetailEnum detailEnum;
	public int textSize;
	public int imageSize;
//	public int textColor;
	public String property = "";
	public String value = "";
	public int order = Integer.MAX_VALUE;
	
	@Override
	public String toString() {
		String imageStr = detailEnum == DetailEnum.image ? " | imageSize(dp):" + imageSize : " | textSize(sp):" + textSize;
		return owlDetailName + "(" + property + ")" + value + " | " + detailEnum.toString() + imageStr + " | order:" + order;
	}
}