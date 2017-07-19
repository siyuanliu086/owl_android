package com.owl_android.demo;

import com.owl_android.annotations.DetailEnum;
import com.owl_android.annotations.ListEnum;
import com.owl_android.annotations.OwlDetail;
import com.owl_android.annotations.OwlList;

public class City {
	@OwlList(owlListType = ListEnum.title, textSize = 16)
	@OwlDetail(owlDetailName = "城市：", owlDetailOrder = 2, textSize = 16)
	private String regionName = "北京市";

	@OwlList(owlListType = ListEnum.image, imageSize = 68)
	@OwlDetail(owlDetailName = "图片：", owlDetailView = DetailEnum.image, imageSize = 68, owlDetailOrder = 1)
	private String imageUrl = "http:lalala.png";

	@OwlList(owlListType = ListEnum.timeText, textSize = 14)
	@OwlDetail(owlDetailName = "日期：", owlDetailOrder = 3, textSize = 14)
	private String op = "2017-07-17";

	@OwlList(owlListType = ListEnum.content, textSize = 14)
	@OwlDetail(owlDetailName = "说明：", owlDetailView = DetailEnum.textarea, owlDetailOrder = 4, textSize = 14)
	private String content = "这是OWL测试案例";

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
