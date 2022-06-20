package model;

import java.io.Serializable;

public class Page implements Serializable {

	private String pageId; //ページID
	private String pageTitle;
	private String pageFlag;// ページタイトル

	//引数がないコンストラクタ
	public Page() {


	}

	//ゲッターセッター
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public String getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}


}