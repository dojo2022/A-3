package model;

import java.io.Serializable;

public class Page implements Serializable {

	private String page_id; //ページID
	private String page_title; // ページタイトル

	//引数がないコンストラクタ
	public Page() {
		super();
		this.page_id = "";
		this.page_title = "";
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}

	public String getPage_title() {
		return page_title;
	}

	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
}