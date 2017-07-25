package com.owl_android.demo;

import com.owl_android.annotations.DetailEnum;
import com.owl_android.annotations.ListEnum;
import com.owl_android.annotations.OwlDetail;
import com.owl_android.annotations.OwlList;
import com.owl_android.utils.R;

public class City {
	@OwlList(listType = ListEnum.title, textColorRes = R.color.owl_deep_black)
	@OwlDetail(detailName = "城市", order = 2)
	private String cityName = "北京市";

	@OwlList(listType = ListEnum.image, imageSize = 68)
	@OwlDetail(detailName = "图片", detailView = DetailEnum.image, imageSize = 68, order = 1)
	private String imageUrl = "http:lalala.png";

	@OwlList(listType = ListEnum.timeText, nameSize = 14, textColorRes = R.color.owl_deep_gray)
	@OwlDetail(detailName = "日期", order = 3)
	private String time = "2017-07-17";

	@OwlList(listType = ListEnum.content, nameSize = 14, textColorRes = R.color.owl_deep_gray)
	@OwlDetail(detailName = "说明", detailView = DetailEnum.textarea, order = 4)
	private String content = "这是OWL测试案例";

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
