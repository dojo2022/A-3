package model;

import java.io.Serializable;

public class Category implements Serializable{
	private String categoryId;
	private String categoryName;

	//引数なしコンストラクタ
	public Category() {

	}

	//setter getter

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}







}


