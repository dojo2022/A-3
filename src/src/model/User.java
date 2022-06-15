package model;

import java.io.Serializable;

public class User implements Serializable {

	private String user_id; //ユーザID
	private String user_pw; // パスワード
	private String user_name; // ニックネーム
	private String icon_id; // アイコン画像ID

	//引数がないコンストラクタ
	public User() {
		super();
		this.user_id = "";
		this.user_pw = "";
		this.user_name = "";
		this.icon_id = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(String icon_id) {
		this.icon_id = icon_id;
	}

}
