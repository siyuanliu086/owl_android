package com.owl_android.annotations;

import com.owl_android.annotations.DetailEnum;

public class City {
	@OwlList(listType = ListEnum.title, textSize = 16)
	@OwlDetail(detailName = "城市：", order = 2, textSize = 16)
	private String regionName = "北京市";

	@OwlList(listType = ListEnum.image, imageSize = 68)
	@OwlDetail(detailName = "图片：", detailView = DetailEnum.image, imageSize = 68, order = 1)
	private String imageUrl = "http:lalala.png";

	@OwlList(listType = ListEnum.timeText, textSize = 14)
	@OwlDetail(detailName = "日期：", order = 3, textSize = 14)
	private String op = "2017-07-17";

	@OwlList(listType = ListEnum.content, textSize = 14)
	@OwlDetail(detailName = "说明：", detailView = DetailEnum.textarea, order = 4, textSize = 14)
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
