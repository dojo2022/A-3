package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Memo implements Serializable{
private String memoId;
private String memoItem;
private String memoCheck;
private String pageId;
private ArrayList<String> textList;

//引数なしコンストラクタ
public Memo() {

}

//setter getter

public String getMemoId() {
	return memoId;
}

public void setMemoId(String memoId) {
	this.memoId = memoId;
}

public String getMemoItem() {
	return memoItem;
}

public void setMemoItem(String memoItem) {
	this.memoItem = memoItem;
}

public String getMemoCheck() {
	return memoCheck;
}

public void setMemoCheck(String memoCheck) {
	this.memoCheck = memoCheck;
}

public String getPageId() {
	return pageId;
}

public void setPageId(String pageId) {
	this.pageId = pageId;
}

public ArrayList<String> getTextList() {
	return textList;
}

public void setTextList(ArrayList<String> textList) {
	this.textList = textList;
}





}