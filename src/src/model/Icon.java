package model;
import java.io.Serializable;


public class Icon implements Serializable{
	private String iconId;
	private String iconPath;

	//引数無しコンストラクタ
	public Icon() {

	}

	//ゲッターとセッター
	public String getIconId() {
		return iconId;
	}

	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

}