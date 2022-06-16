package model;

import java.io.Serializable;

public class Page implements Serializable {

	private String page_id; //ページID
	private String page_title;
	private String page_flag;// ページタイトル

	//引数がないコンストラクタ
	public Page() {
		super();
		this.page_id = "";
		this.page_title = "";
		this.page_flag = "";
	}

	public String getPage_flag() {
		return page_flag;
	}

	public void setPage_flag(String page_flag) {
		this.page_flag = page_flag;
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