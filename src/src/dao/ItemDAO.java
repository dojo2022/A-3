package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllBeans;


public class ItemDAO {

	//insert
	//必須項目の時にお気に入りが登録できないからfavoriteにif文で未入力の場合はこう、とか、サーブレットで値を渡す必要があるかも
	public boolean insert(String itemName, String itemFavorite, String categoryId, String pageId, String itemAlert, String stockName, String stockBuy, String stockLimit, String stockAlertday1, String stockAlertday2, String stockAlertday3, String stockAlertday4){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// ItemテーブルのINSERT文を準備する
			String sql1 = "INSERT INTO Item (item_name , item_favorite , category_id , page_id , item_alert) VALUES (?,?,?,?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt1.setString(1, itemName);
			if (itemFavorite != null) {
				pStmt1.setString(2, itemFavorite);// nullの条件で0を格納する必要あり！(済)
			}
			else {
				pStmt1.setString(2, "0");
			}
			pStmt1.setString(3, categoryId);
			pStmt1.setString(4, pageId);
			pStmt1.setString(5, itemAlert);

			// Itemテーブルでitem_idが一番大きいものをSELECTするSQL文
			String sql2 = "SELECT MAX(item_id) FROM Item";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// StockテーブルのINSERT文を準備する（賞味期限アラートを追加する（別クラスで計算したものを持ってくる））
			String sql3 = "INSERT INTO Stock (stock_name , stock_buy , stock_limit ,stock_alertday1 ,stock_alertday2 ,stock_alertday3 ,stock_alertday4, item_id) VALUES (?,?,?,?,?,?,?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			// SQL文を完成させる
			pStmt3.setString(1, stockName);

			if (stockBuy != "") {
				pStmt3.setString(2, stockBuy);
			} else {
				pStmt3.setString(2, "9999-12-31");
			}

			if (stockLimit != "") {
				pStmt3.setString(3, stockLimit);
			} else {
				pStmt3.setString(3, "9999-12-31");
			}

			if (stockAlertday1 != "") {
				pStmt3.setString(4, stockAlertday1);
			} else {
				pStmt3.setString(4, "9999-12-31");
			}

			if (stockAlertday2 != "") {
				pStmt3.setString(5, stockAlertday2);
			} else {
				pStmt3.setString(5, "9999-12-31");
			}

			if (stockAlertday3 != "") {
				pStmt3.setString(6, stockAlertday3);
			} else {
				pStmt3.setString(6, "9999-12-31");
			}

			if (stockAlertday4 != "") {
				pStmt3.setString(7, stockAlertday4);
			} else {
				pStmt3.setString(7, "9999-12-31");
			}

			int ans = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();

			//ItemのINSERT後にSQL文を実行し、結果表を取得する
			ResultSet rs = pStmt2.executeQuery();
			rs.next();
			String itemId = rs.getString("MAX(item_id)");

			//取得したitemIdをsql3にセット
			pStmt3.setString(8, itemId);

			//StockテーブルへのINSERT文を実行する
			ans += pStmt3.executeUpdate();

			if (ans == 2) {
				conn.commit(); //全部のsql文ができていれば成功
				result = true;
			}
		} catch (SQLException e) {

			//try catch 文を書く
			try {
				conn.rollback();//sql文が一つでもできていなければロールバックする
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	//update 一覧タブ用（ItmeAjaxServlet）
	//残量切れ日に入れる値は条件を分けて計算済み（Alert.java）
	public boolean ajaxUpdate(String itemFavorite, String itemRemain, String itemLostday, String itemAlertday, String itemId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// itemテーブルのUPDATE（買い替えアラートを更新する（別クラスで計算したものを持ってくる））
			String sql = "UPDATE Item SET item_favorite=?, item_remain=?, item_lostday=?, item_alertday=? where item_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, itemFavorite);
			pStmt.setString(2, itemRemain);
//			if (itemRemain == "1") {
//				pStmt.setString(3, itemLostday);
//			} else {
//				pStmt.setString(3, "9999-12-31");
//			}
			pStmt.setString(3, itemLostday);
			pStmt.setString(4, itemAlertday);
			pStmt.setString(5, itemId);

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}

	//itemRemainの値が2、3の時のupdateメソッド（使わないで済みそう）
	public boolean itemFRupdate(String itemFavorite, String itemRemain, String itemId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			String sql = "UPDATE Item SET item_favorite=?, item_remain=?,where item_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, itemFavorite);
			pStmt.setString(2, itemRemain);
			pStmt.setString(3, itemId);

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}


	//update 新編集・削除タブ用（ItemUpdateDeleteServlet）
	public boolean editUpdate(String itemName, String itemFavorite, String categoryId, String itemAlert, String itemAlertday, String itemId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// itemテーブルのUPDATE（買い替えアラートを更新する（別クラスで計算したものを持ってくる））
			String sql = "UPDATE Item SET item_name=?, item_favorite=?, category_id=?, item_alert=?, item_alertday=? where item_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, itemName);
			pStmt.setString(2, itemFavorite);
			pStmt.setString(3, categoryId);
			pStmt.setString(4, itemAlert);
			pStmt.setString(5, itemAlertday);
			pStmt.setString(6, itemId);

			//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}


	//update	旧編集・削除タブ用？(もう使わなそう)
	public boolean oldUpdate(String itemName, String itemFavorite, String categoryId, String itemAlert, String itemAlertday, String itemId, String stockName, String stockBuy, String stockLimit, String stockAlert, String stockAlertday1, String stockAlertday2, String stockAlertday3, String stockAlertday4, String stockId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// itemテーブルのUPDATE（買い替えアラートを更新する（別クラスで計算したものを持ってくる））
			String sql1 = "UPDATE Item SET item_name=?, item_favorite=?, category_id=?, item_alert=?, item_alertday=? where item_id=?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1, itemName);
			pStmt1.setString(2, itemFavorite);
			pStmt1.setString(3, categoryId);
			pStmt1.setString(4, itemAlert);
			pStmt1.setString(5, itemAlertday);
			pStmt1.setString(6, itemId);

			// stockテーブルのUPDATE（賞味期限アラートを更新する（別クラスで計算したものを持ってくる））
			String sql2 = "UPDATE Stock SET stock_name=? , stock_buy=? , stock_limit=?, stock_alert=? ,stock_alertday1=? ,stock_alertday2=? ,stock_alertday3=? ,stock_alertday4=? where stock_id=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt2.setString(1, stockName);
			if (stockBuy != "") {
				pStmt2.setString(2, stockBuy);
			} else {
				pStmt2.setString(2, "9999-12-31");
			}
			if (stockLimit != "") {
				pStmt2.setString(3, stockLimit);
			} else {
				pStmt2.setString(3, "9999-12-31");
			}
			pStmt2.setString(4, stockAlert);
			if (stockAlertday1 != "") {
				pStmt2.setString(5, stockAlertday1);
			} else {
				pStmt2.setString(5, "9999-12-31");
			}
			if (stockAlertday2 != "") {
				pStmt2.setString(6, stockAlertday2);
			} else {
				pStmt2.setString(6, "9999-12-31");
			}
			if (stockAlertday3 != "") {
				pStmt2.setString(7, stockAlertday3);
			} else {
				pStmt2.setString(7, "9999-12-31");
			}
			if (stockAlertday4 != "") {
				pStmt2.setString(8, stockAlertday4);
			} else {
				pStmt2.setString(8, "9999-12-31");
			}
			pStmt2.setString(9, stockId);

			int ans=0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();

			if(ans == 2) {
				conn.commit();
				result = true;
			}else {
				conn.rollback();
				result = false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}


	//delete
	public boolean delete(String itemId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// stockテーブルのDELETE
			String sql1 = "SELECT COUNT(*) FROM Stock WHERE item_id = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt1.setString(1, itemId);

			String sql2 = "DELETE FROM Stock WHERE item_id = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			pStmt2.setString(1, itemId);

			// ItemテーブルのDELETE
			String sql3 = "DELETE FROM Item WHERE item_id = ?";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			// SQL文を完成させる
			pStmt3.setString(1, itemId);

			int selectAns=0;
			int ans1 = 0;
			int ans2 = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ResultSet rs = pStmt1.executeQuery();
			while (rs.next()) {
				selectAns=rs.getInt("COUNT(*)");
			}
			ans1 = pStmt2.executeUpdate();
			ans2 = pStmt3.executeUpdate();

			if (ans1+ans2 == (selectAns+ans2)) {
				conn.commit();
				result = true;
			} else {
				conn.rollback();
				result = false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;

	}

	// select一覧タブからの編集削除タブ用
	public ArrayList<AllBeans> select(String itemId){
		Connection conn = null;
		ArrayList<AllBeans> itemList = new ArrayList<AllBeans>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			//ここ考えないと！！ itemid 一件だけ検索する
			String sql = "SELECT * FROM Item  LEFT JOIN Stock ON Item.item_id = Stock.item_id LEFT JOIN Category ON  Item.category_id = Category.category_id WHERE Item.item_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, itemId);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				AllBeans main = new AllBeans();
				main.setItemId(rs.getString("item_id"));
				main.setItemName(rs.getString("item_name"));
				main.setItemFavorite(rs.getString("item_favorite"));
				main.setItemRemain(rs.getString("item_remain"));
				main.setItemLostday(rs.getString("item_lostday"));
				main.setCategoryId(rs.getString("category_id"));
				main.setPageId(rs.getString("page_id"));
				main.setItemAlert(rs.getString("item_alert"));
				main.setItemAlertday(rs.getString("item_alertday"));
				main.setCategoryName(rs.getString("category_name"));
				itemList.add(main);
			}


		}
			catch (SQLException e) {
				e.printStackTrace();
				itemList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				itemList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						itemList = null;
					}
				}
			}

			// 結果を返す
			return itemList;
}


}
