package model;
import java.io.Serializable;

public class UPjoin implements Serializable{

	private String user_page_id;
	private String user_id;
	private String page_id;

	//引数なしコンストラクタ
	public UPjoin() {

	}


	//ゲッターとセッター

	public String getUser_page_id() {
		return user_page_id;
	}

	public void setUser_page_id(String user_page_id) {
		this.user_page_id = user_page_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}









}
