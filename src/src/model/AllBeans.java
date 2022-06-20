package model;

public class AllBeans {
	//Icon(アイコン画像)
	private String iconId;
	private String iconPath;
	//User(ユーザ)
	private String userId; //ユーザID
	private String userPw; // パスワード
	private String userName; // ニックネーム
	private	 String userFlag;//フラグ
	//Page(ページ)
	private String pageId;
	private String pageTitle;
	private String pageFlag;
	//Memo(メモ)
	private String memoId;
	private String memoItem;
	private String memoCheck;
	//UPjoin(中間テーブル)
	private String userPageId;
	//Category(分類)
	private String categoryId;
	private String categoryName;
	//Item(項目)
	private String itemId;
	private String itemName;
	private String itemFavorite;
	private String itemRemain;
	private String itemLostday;
	private String itemAlert;
	private String itemAlertday;
	//Stock(在庫)
	private String stockId;
	private String stockName;
	private String stockBuy;
	private String stockLimit;
	private String stockAlert;
	private String stockAlertday1;
	private String stockAlertday2;
	private String stockAlertday3;
	private String stockAlertday4;



	//引数のないコンストラクタ
	public AllBeans() {
	}

	//セッタとゲッタ



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



	public String getUserFlag() {
		return userFlag;
	}



	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}



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



	public String getUserPageId() {
		return userPageId;
	}



	public void setUserPageId(String userPageId) {
		this.userPageId = userPageId;
	}



	public String getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getItemFavorite() {
		return itemFavorite;
	}



	public void setItemFavorite(String itemFavorite) {
		this.itemFavorite = itemFavorite;
	}



	public String getItemRemain() {
		return itemRemain;
	}



	public void setItemRemain(String itemRemain) {
		this.itemRemain = itemRemain;
	}



	public String getItemLostday() {
		return itemLostday;
	}



	public void setItemLostday(String itemLostday) {
		this.itemLostday = itemLostday;
	}



	public String getItemAlert() {
		return itemAlert;
	}



	public void setItemAlert(String itemAlert) {
		this.itemAlert = itemAlert;
	}



	public String getItemAlertday() {
		return itemAlertday;
	}



	public void setItemAlertday(String itemAlertday) {
		this.itemAlertday = itemAlertday;
	}



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


}
