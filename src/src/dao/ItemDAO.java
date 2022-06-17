package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AllBeans;


public class ItemDAO {

	//insert
	public boolean insert(AllBeans param){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
						String sql = "";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる





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


	//select
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<AllBeans> select(AllBeans param) {
			Connection conn = null;
			List<AllBeans> itemList = new ArrayList<AllBeans>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する


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



	//update
	public boolean update(AllBeans param){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
						String sql = "";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる





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
	//insert
	public boolean delete(AllBeans param){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
						String sql = "";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる





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
