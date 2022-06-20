package model;
import java.io.Serializable;

public class UPjoin implements Serializable{

	private String userPageId;
	private String userId;
	private String pageId;

	//引数なしコンストラクタ
	public UPjoin() {

	}


	//ゲッターとセッター
	public String getUserPageId() {
		return userPageId;
	}

	public void setUserPageId(String userPageId) {
		this.userPageId = userPageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

}

