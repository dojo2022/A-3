package model;

import java.io.Serializable;

public class Stock implements Serializable {

	private String stock_id;
	private String stock_name;
	private String stock_buy;
	private String stock_limit;
	private String stock_alert;
	private String stock_alertday1;
	private String stock_alertday2;
	private String stock_alertday3;
	private String stock_alertday4;
	private String item_id;

//引数無コンストラクタ
	public Stock() {

	}

//ゲッターセッター
	public String getStock_id() {
		return stock_id;
	}


	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}


	public String getStock_name() {
		return stock_name;
	}


	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}


	public String getStock_buy() {
		return stock_buy;
	}


	public void setStock_buy(String stock_buy) {
		this.stock_buy = stock_buy;
	}


	public String getStock_limit() {
		return stock_limit;
	}


	public void setStock_limit(String stock_limit) {
		this.stock_limit = stock_limit;
	}


	public String getStock_alert() {
		return stock_alert;
	}


	public void setStock_alert(String stock_alert) {
		this.stock_alert = stock_alert;
	}


	public String getStock_alertday1() {
		return stock_alertday1;
	}


	public void setStock_alertday1(String stock_alertday1) {
		this.stock_alertday1 = stock_alertday1;
	}


	public String getStock_alertday2() {
		return stock_alertday2;
	}


	public void setStock_alertday2(String stock_alertday2) {
		this.stock_alertday2 = stock_alertday2;
	}


	public String getStock_alertday3() {
		return stock_alertday3;
	}


	public void setStock_alertday3(String stock_alertday3) {
		this.stock_alertday3 = stock_alertday3;
	}


	public String getStock_alertday4() {
		return stock_alertday4;
	}


	public void setStock_alertday4(String stock_alertday4) {
		this.stock_alertday4 = stock_alertday4;
	}


	public String getItem_id() {
		return item_id;
	}


	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}





}
