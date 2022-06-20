package model;

import java.io.Serializable;

public class Stock implements Serializable {

	private String stockId;
	private String stockName;
	private String stockBuy;
	private String stockLimit;
	private String stockAlert;
	private String stockAlertday1;
	private String stockAlertday2;
	private String stockAlertday3;
	private String stockAlertday4;
	private String itemId;

	//引数無コンストラクタ

	public Stock() {

	}

	//ゲッターセッター
	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockBuy() {
		return stockBuy;
	}

	public void setStockBuy(String stockBuy) {
		this.stockBuy = stockBuy;
	}

	public String getStockLimit() {
		return stockLimit;
	}

	public void setStockLimit(String stockLimit) {
		this.stockLimit = stockLimit;
	}

	public String getStockAlert() {
		return stockAlert;
	}

	public void setStockAlert(String stockAlert) {
		this.stockAlert = stockAlert;
	}

	public String getStockAlertday1() {
		return stockAlertday1;
	}

	public void setStockAlertday1(String stockAlertday1) {
		this.stockAlertday1 = stockAlertday1;
	}

	public String getStockAlertday2() {
		return stockAlertday2;
	}

	public void setStockAlertday2(String stockAlertday2) {
		this.stockAlertday2 = stockAlertday2;
	}

	public String getStockAlertday3() {
		return stockAlertday3;
	}

	public void setStockAlertday3(String stockAlertday3) {
		this.stockAlertday3 = stockAlertday3;
	}

	public String getStockAlertday4() {
		return stockAlertday4;
	}

	public void setStockAlertday4(String stockAlertday4) {
		this.stockAlertday4 = stockAlertday4;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


}
