package com.owl_android.annotations;

public class City {
	@OwlList(owl_type = OwlTypeEnum.title)
	private String regionName = "北京市";

	@OwlList(owl_type = OwlTypeEnum.image)
	private String icon = "http:lalala.png";

	@OwlList(owl_type = OwlTypeEnum.timeText)
	private String op = "2017-07-17";

	@OwlList(owl_type = OwlTypeEnum.content)
	private String content = "这是OWL测试";

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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
