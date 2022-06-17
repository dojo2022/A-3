package model;
import java.io.Serializable;


public class Icon implements Serializable{
	private String icon_id;
	private String icon_path;

	//引数無しコンストラクタ
	public Icon() {

	}


	//ゲッターセッター
	public String getIcon_id() {
		return icon_id;
	}

	public void setIcon_id(String icon_id) {
		this.icon_id = icon_id;
	}

	public String getIcon_path() {
		return icon_path;
	}

	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}




}
