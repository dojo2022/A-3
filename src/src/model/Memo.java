package model;

import java.io.Serializable;

public class Memo implements Serializable{
private String memo_id;
private String memo_item;
private String memo_check;
private String page_id;

//引数なしコンストラクタ
public Memo() {

}

//setter getter
public String getMemo_id() {
	return memo_id;
}


public void setMemo_id(String memo_id) {
	this.memo_id = memo_id;
}


public String getMemo_item() {
	return memo_item;
}


public void setMemo_item(String memo_item) {
	this.memo_item = memo_item;
}


public String getMemo_check() {
	return memo_check;
}


public void setMemo_check(String memo_check) {
	this.memo_check = memo_check;
}


public String getPage_id() {
	return page_id;
}


public void setPage_id(String page_id) {
	this.page_id = page_id;
}


}