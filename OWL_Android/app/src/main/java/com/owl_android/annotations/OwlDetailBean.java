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
public class OwlDetailBean implements Comparable<OwlDetailBean>{
	public String owlDetailName;
	public DetailEnum detailEnum;
	public int nameSize;
	public int valueSize;
	public int imageSize;
	public int nameColorRes;
	public int valueColorRes;
	public String property = "";
	public String value = "";
	public int order = Integer.MAX_VALUE;
	
	@Override
	public String toString() {
		String imageStr = detailEnum == DetailEnum.image ? " | imageSize(dp):" + imageSize : " | nameSize(sp):" + nameSize;
		return owlDetailName + "(" + property + ")" + value + " | valueSize(sp)"+valueSize+") | " + detailEnum.toString() + imageStr + " | order:" + order;
	}

	@Override
	public int compareTo(OwlDetailBean o) {
		return this.order - o.order;
	}
}
