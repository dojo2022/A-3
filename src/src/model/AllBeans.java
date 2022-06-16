package model;

public class AllBeans {
	//Category(分類)
	private String category_id;
	private String category_name;
	//Icon(アイコン画像)
	private String icon_id;
	private String icon_path;
	//Item(項目)
	private String item_id;
	private String item_name;
	private String item_favorite;
	private String item_remain;
	private String item_lostday;
	private String page_id;
	private String item_alert;
	private String item_alertday;
	//Memo(メモ)
	private String memo_id;
	private String memo_item;
	private String memo_check;
	//Page(ページ)
	private String page_title;
	private String page_flag;
	//Stock(在庫)
	private String stock_id;
	private String stock_name;
	private String stock_buy;
	private String stock_limit;
	private String stock_alert;
	private String stock_alertday1;
	private String stock_alertday2;
	private String stock_alertday3;
	private String stock_alertday4;
	//UPjoin(中間テーブル)
	private String user_page_id;
	//User
	private String user_id; //ユーザID
	private String user_pw; // パスワード
	private String user_name; // ニックネーム
	private	 String user_flag;//フラグ

	//引数のないコンストラクタ
	public AllBeans() {
		super();
		this.category_id = "";
		this.category_name = "";
		this.icon_id = "";
		this.icon_path = "";
		this.item_id = "";
		this.item_name = "";
		this.item_favorite = "";
		this.item_remain = "";
		this.item_lostday = "";
		this.page_id = "";
		this.item_alert = "";
		this.item_alertday = "";
		this.memo_id = "";
		this.memo_item = "";
		this.memo_check = "";
		this.page_title = "";
		this.page_flag = "";
		this.stock_id = "";
		this.stock_name = "";
		this.stock_buy = "";
		this.stock_limit = "";
		this.stock_alert = "";
		this.stock_alertday1 = "";
		this.stock_alertday2 = "";
		this.stock_alertday3 = "";
		this.stock_alertday4 = "";
		this.user_page_id = "";
		this.user_id = "";
		this.user_pw = "";
		this.user_name = "";
		this.user_flag = "";
	}

	//セッタとゲッタ
	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

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

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_favorite() {
		return item_favorite;
	}

	public void setItem_favorite(String item_favorite) {
		this.item_favorite = item_favorite;
	}

	public String getItem_remain() {
		return item_remain;
	}

	public void setItem_remain(String item_remain) {
		this.item_remain = item_remain;
	}

	public String getItem_lostday() {
		return item_lostday;
	}

	public void setItem_lostday(String item_lostday) {
		this.item_lostday = item_lostday;
	}

	public String getPage_id() {
		return page_id;
	}

	public void setPage_id(String page_id) {
		this.page_id = page_id;
	}

	public String getItem_alert() {
		return item_alert;
	}

	public void setItem_alert(String item_alert) {
		this.item_alert = item_alert;
	}

	public String getItem_alertday() {
		return item_alertday;
	}

	public void setItem_alertday(String item_alertday) {
		this.item_alertday = item_alertday;
	}

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

	public String getPage_title() {
		return page_title;
	}

	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}

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

	public String getUser_page_id() {
		return user_page_id;
	}

	public void setUser_page_id(String user_page_id) {
		this.user_page_id = user_page_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPage_flag() {
		return page_flag;
	}

	public void setPage_flag(String page_flag) {
		this.page_flag = page_flag;
	}

	public String getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(String user_flag) {
		this.user_flag = user_flag;
	}



}
