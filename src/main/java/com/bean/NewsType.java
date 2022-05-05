package com.bean;

import com.alibaba.fastjson.JSONObject;

public class NewsType extends Common {


	private static final long serialVersionUID = -8309786066381844681L;
	private Integer typeId;
	private String typeName;

	public NewsType() {

		super();
	}
	public NewsType(Integer typeId) {
		super();
		this.typeId = typeId;
	}
	public NewsType(Integer typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}
