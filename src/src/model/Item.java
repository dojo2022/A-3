package model;

import java.io.Serializable;

public class Item implements Serializable {
	private String itemId;
	private String itemName;
	private String itemFavorite;
	private String itemRemain;
	private String itemLostday;
	private String categoryId;
	private String pageId;
	private String itemAlert;
	private String itemAlertday;

	//引数無しコンストラクタ
	public Item() {

	}


	//ゲッターセッター
	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemFavorite() {
		return itemFavorite;
	}


	public void setItemFavorite(String itemFavorite) {
		this.itemFavorite = itemFavorite;
	}


	public String getItemRemain() {
		return itemRemain;
	}


	public void setItemRemain(String itemRemain) {
		this.itemRemain = itemRemain;
	}


	public String getItemLostday() {
		return itemLostday;
	}


	public void setItemLostday(String itemLostday) {
		this.itemLostday = itemLostday;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String getPageId() {
		return pageId;
	}


	public void setPageId(String pageId) {
		this.pageId = pageId;
	}


	public String getItemAlert() {
		return itemAlert;
	}


	public void setItemAlert(String itemAlert) {
		this.itemAlert = itemAlert;
	}


	public String getItemAlertday() {
		return itemAlertday;
	}


	public void setItemAlertday(String itemAlertday) {
		this.itemAlertday = itemAlertday;
	}



}
