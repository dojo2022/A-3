package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllBeans;
public class StockDAO {

	//insert
	public boolean insert(String stockName, String stockBuy, String stockLimit, String itemId, String stockAlertday1, String stockAlertday2, String stockAlertday3, String stockAlertday4){
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//項目IDをselect ⇒　在庫をinsertする？
			//一覧の在庫追加のフォームの中に<input type="hidden" name="itemId" value=""${e.itemId}$>で値を引き渡す

			// SQL文を準備する
			String sql = "INSERT INTO Stock (stock_name, stock_buy, stock_limit,item_id, stock_alertday1, stock_alertday2, stock_alertday3, stock_alertday4) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, stockName);
			pStmt.setString(2, stockBuy);
			pStmt.setString(3, stockLimit);
			pStmt.setString(4, itemId);
			pStmt.setString(5, stockAlertday1);
			pStmt.setString(6, stockAlertday2);
			pStmt.setString(7, stockAlertday3);
			pStmt.setString(8, stockAlertday4);


			// SQL文を実行する
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

	// select
		public ArrayList<AllBeans> select(String pageId){
			Connection conn = null;
			ArrayList<AllBeans> stockList = new ArrayList<AllBeans>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "SELECT * FROM Item  LEFT JOIN Stock ON Item.item_id = Stock.item_id LEFT JOIN Category ON  Item.category_id = Category.category_id WHERE Item.page_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, pageId);


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
					main.setStockId(rs.getString("stock_id"));
					main.setStockName(rs.getString("stock_name"));
					main.setStockBuy(rs.getString("stock_buy"));
					main.setStockLimit(rs.getString("stock_limit"));
					main.setStockAlert(rs.getString("stock_alert"));
					main.setStockAlertday1(rs.getString("stock_alertday1"));
					main.setStockAlertday2(rs.getString("stock_alertday2"));
					main.setStockAlertday3(rs.getString("stock_alertday3"));
					main.setStockAlertday4(rs.getString("stock_alertday4"));
					main.setCategoryName(rs.getString("category_name"));
					stockList.add(main);
				}


			}
				catch (SQLException e) {
					e.printStackTrace();
					stockList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					stockList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							stockList = null;
						}
					}
				}

				// 結果を返す
				return stockList;
}

		//update
		public boolean update(String stockBuy, String stockLimit, String stockAlert, String stockId, String stockAlertday1, String stockAlertday2, String stockAlertday3, String stockAlertday4) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "UPDATE Stock SET stock_buy=?, stock_limit=?, stock_alert=?, stock_alertday1=?, stock_alertday2=?,stock_alertday3=?, stock_alertday4=?, WHERE stock_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, stockBuy);
				pStmt.setString(2, stockLimit);
				pStmt.setString(3, stockAlert);
				pStmt.setString(4, stockAlertday1);
				pStmt.setString(5, stockAlertday2);
				pStmt.setString(6, stockAlertday3);
				pStmt.setString(7, stockAlertday4);
				pStmt.setString(8, stockId);

				// SQL文を実行する
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

		//delete
		public boolean delete(String stockId) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "DELETE FROM Stock WHERE stock_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, stockId);

				// SQL文を実行する
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

	}
