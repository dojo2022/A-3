package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItemDAO {

	//insert
	public boolean insert(String item_name, String item_favorite , String category_id ,String page_id ,String item_alert,String stock_name ,String stock_buy ,String stock_limit ,String item_id){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// ItemテーブルのINSERT文を準備する
			String sql1 = "INSERT INTO item (item_name , item_favorite , category_id , page_id , item_alert) VALUES ('?','?','?','?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt1.setString(1, item_name);
			pStmt1.setString(2, item_favorite);
			pStmt1.setString(3, category_id);
			pStmt1.setString(4, page_id);
			pStmt1.setString(5, item_alert);

			// StockテーブルのINSERT文を準備する
			String sql2 = "INSERT INTO item (stock_name , stock_buy , stock_limit , item_id) VALUES ('?','?','?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			pStmt1.setString(1, stock_name);
			pStmt1.setString(2, stock_buy);
			pStmt1.setString(3, stock_limit);
			pStmt1.setString(4, item_id);

			int ans = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();

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

	//update
	public boolean update(String item_name, String item_favorite , String category_id ,String page_id ,String item_alert,String stock_name ,String stock_buy ,String stock_limit ,String item_id){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// itemテーブルのUPDATE
			String sql1 = "UPDATE item SET item_name=? , item_favorite=? , category_id=? , page_id=? , item_alert=? where item_id=?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1, item_name);
			pStmt1.setString(2, item_favorite);
			pStmt1.setString(3, category_id);
			pStmt1.setString(4, page_id);
			pStmt1.setString(5, item_alert);

			String sql2 = "UPDATE stock SET stock_name=? , stock_buy=? , stock_limit=? , item_id=? where stock_id=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt2.setString(1, stock_name);
			pStmt2.setString(2, stock_buy);
			pStmt2.setString(3, stock_limit);
			pStmt2.setString(4, item_id); //item_idは絶対かわらないけどどうする

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
	public boolean delete(String item_id){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// stockテーブルのDELETE
			String sql1 = "DELETE FROM stock WHERE stock_id = '?';";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			// SQL文を完成させる
			pStmt1.setString(1, item_id);

			// ItemテーブルのDELETE
			String sql2 = "DELETE FROM stock WHERE item_id = '?';";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			// SQL文を完成させる
			pStmt2.setString(1, item_id);

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
