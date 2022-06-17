package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AllBeans;
public class StockDAO {

	//insert
	public boolean insert(AllBeans param){
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
			String sql = "INSERT INTO Stock (stock_name, stock_buy, stock_limit,item_id) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, param.getStock_name());
			pStmt.setString(2, param.getStock_buy());
			pStmt.setString(3, param.getStock_limit());
			pStmt.setString(4, param.getItem_id());


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
		public List<AllBeans> select(String page_id){
			Connection conn = null;
			List<AllBeans> stockList = new ArrayList<AllBeans>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "INSERT INTO Stock (stock_name, stock_buy, stock_limit,item_id) VALUES (?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする


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
		public boolean update(AllBeans param) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "UPDATE Stock SET stock_buy=?, stock_limit=?, stock_alert=? WHERE stock_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, param.getStock_buy());
				pStmt.setString(2, param.getStock_limit());
				pStmt.setString(3, param.getStock_alert());
				pStmt.setString(4, param.getStock_id());

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
		public boolean delete(AllBeans param) {
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
				pStmt.setString(1, param.getStock_id());

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
