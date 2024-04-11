package com.machine.test.crud.model;

import org.springframework.stereotype.Component;

@Component
public class CategoryDto {

	private Integer catgId;

	private String catgName;

	private String catgDescription;

	public Integer getCatgId() {
		return catgId;
	}

	public void setCatgId(Integer catgId) {
		this.catgId = catgId;
	}

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getCatgDescription() {
		return catgDescription;
	}

	public void setCatgDescription(String catgDescription) {
		this.catgDescription = catgDescription;
	}

}
