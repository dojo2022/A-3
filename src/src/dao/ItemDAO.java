package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ItemDAO {

	//insert
	//必須項目の時にお気に入りが登録できないからfavoriteにif文で未入力の場合はこう、とか、サーブレットで値を渡す必要があるかも
	public boolean insert(String itemName, String itemFavorite , String categoryId ,String pageId ,String itemAlert,String stockName ,String stockBuy ,String stockLimit,String stockAlertday1 ,String stockAlertday2 ,String stockAlertday3 ,String stockAlertday4){
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
			pStmt1.setString(2, itemFavorite); // nullの条件で0を格納する必要あり！
			pStmt1.setString(3, categoryId);
			pStmt1.setString(4, pageId);
			pStmt1.setString(5, itemAlert);

			// Itemテーブルでitem_idが一番大きいものをselectする
			String sql2 = "SELECT MAX(item_id) FROM Item";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt2.executeQuery();

			rs.next();
			String itemId = rs.getString("item_id");

			// StockテーブルのINSERT文を準備する（賞味期限アラートを追加する（別クラスで計算したものを持ってくる））
			String sql3 = "INSERT INTO Stock (stock_name , stock_buy , stock_limit ,stock_alertday1 ,stock_alertday2 ,stock_alertday3 ,stock_alertday4, item_id) VALUES (?,?,?,?,?,?,?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			// SQL文を完成させる
			pStmt1.setString(1, stockName);
			pStmt1.setString(2, stockBuy);
			pStmt1.setString(3, stockLimit);
			pStmt1.setString(4, stockAlertday1);
			pStmt1.setString(5, stockAlertday2);
			pStmt1.setString(6, stockAlertday3);
			pStmt1.setString(7, stockAlertday4);
			pStmt1.setString(8, itemId);

			int ans = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();
			ans += pStmt3.executeUpdate();

			if (ans == 3) {
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

	//update、残量
	//全部一個のメソッドにする分、残量切れ日を更新する時とそうじゃない時のif文が必要
	public boolean update(String itemName, String itemFavorite ,String itemRemain, String itemLostday, String categoryId ,String pageId ,String itemAlert, String itemAlertday, String stockName ,String stockBuy ,String stockLimit,String stockAlert, String stockAlertday1 ,String stockAlertday2 ,String stockAlertday3 ,String stockAlertday4 ,String itemId ,String stockId){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// itemテーブルのUPDATE（買い替えアラートを更新する（別クラスで計算したものを持ってくる））
			String sql1 = "UPDATE Item SET item_name=? , item_favorite=? ,item_remain=?, item_lostday=?, category_id=? , page_id=? , item_alert=? , item_alertday=? where item_id=?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1, itemName);
			pStmt1.setString(2, itemFavorite);
			pStmt1.setString(3, itemRemain);
			pStmt1.setString(4, itemLostday);
			pStmt1.setString(5, categoryId);
			pStmt1.setString(6, pageId);
			pStmt1.setString(7, itemAlert);
			pStmt1.setString(8, itemAlertday);
			pStmt1.setString(9, itemId);

			// stockテーブルのUPDATE（賞味期限アラートを更新する（別クラスで計算したものを持ってくる））
			String sql2 = "UPDATE Stock SET stock_name=? , stock_buy=? , stock_limit=?, stock_alert=? ,stock_alertday1=? ,stock_alertday2=? ,stock_alertday3=? ,stock_alertday4=?, where stock_id=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt1.setString(1, stockName);
			pStmt1.setString(2, stockBuy);
			pStmt1.setString(3, stockLimit);
			pStmt1.setString(3, stockAlert);
			pStmt1.setString(4, stockAlertday1);
			pStmt1.setString(5, stockAlertday2);
			pStmt1.setString(6, stockAlertday3);
			pStmt1.setString(7, stockAlertday4);
			pStmt1.setString(8, stockId);

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
			String sql1 = "DELETE FROM Stock WHERE item_id = ?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt1.setString(1, itemId);

			// ItemテーブルのDELETE
			String sql2 = "DELETE FROM Item WHERE item_id = ?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			pStmt2.setString(1, itemId);

			int ans = 0;
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

}
