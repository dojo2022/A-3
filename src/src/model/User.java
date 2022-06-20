package model;

import java.io.Serializable;

public class User implements Serializable {

	private String userId; //ユーザID
	private String userPw; // パスワード
	private String userName; // ニックネーム
	private String iconId; // アイコン画像ID
	private	 String userFlag;//フラグ

	//引数がないコンストラクタ
	public User() {


	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIconId() {
		return iconId;
	}

	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}



}
