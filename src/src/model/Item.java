package model;

import java.io.Serializable;

public class Item implements Serializable {
	private String item_id;
	private String item_name;
	private String item_favorite;
	private String item_remain;
	private String item_lostday;
	private String category_id;
	private String page_id;
	private String item_alert;
	private String item_alertday;


	public Item() {
		super();
		this.item_id = "";
		this.item_name = "";
		this.item_favorite = "";
		this.item_remain = "";
		this.item_lostday = "";
		this.category_id = "";
		this.page_id = "";
		this.item_alert = "";
		this.item_alertday = "";
	}


	public String getItem_id() {
		return item_id;
	}


	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public String getItem_favorite() {
		return item_favorite;
	}


	public void setItem_favorite(String item_favorite) {
		this.item_favorite = item_favorite;
	}


	public String getItem_remain() {
		return item_remain;
	}


	public void setItem_remain(String item_remain) {
		this.item_remain = item_remain;
	}


	public String getItem_lostday() {
		return item_lostday;
	}


	public void setItem_lostday(String item_lostday) {
		this.item_lostday = item_lostday;
	}


	public String getCategory_id() {
		return category_id;
	}


	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}


	public String getPage_id() {
		return page_id;
	}


	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}


	public String getItem_alert() {
		return item_alert;
	}


	public void setItem_alert(String item_alert) {
		this.item_alert = item_alert;
	}


	public String getItem_alertday() {
		return item_alertday;
	}


	public void setItem_alertday(String item_alertday) {
		this.item_alertday = item_alertday;
	}



}
