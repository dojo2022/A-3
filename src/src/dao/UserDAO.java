package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AllBeans;

public class UserDAO {

	// insert
	public boolean insert(AllBeans param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// usertableのINSERT文を準備する
			String sql = "";//SQL文記述
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//pagetableのINSERT文を準備する

			//UPjoinのINSERT文を準備する

			// INSERT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// SQL文を実行し成功したらtrueを返す
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			//ロールバックするためのExceptionを作る？？

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

	//select
	public List<AllBeans> select(AllBeans param) {
		Connection conn = null;
		List<AllBeans> userList = new ArrayList<AllBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SELECT文を完成させる
			// USERtableのためのSQLを準備する
			String sql = "";//SQL文を記述
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// PagetableのためのSQLを準備する

			// UPjointableのためのSQLを準備する

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
			userList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			userList = null;

			//ロールバックするためのExceptionを作る？？

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					userList = null;
				}
			}
		}

		// 結果を返す
		return userList;
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

			//// UPDATE文を準備する
			String sql = "";//SQL文記述
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// UPDATE文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// SQL文を実行し成功したらtrueを返す
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			//ロールバックするためのExceptionを作る？？

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

	//deleteFlag
	public boolean deleteFlag(AllBeans param) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//// UPDATE文を準備する
			String sql = "";//SQL文記述
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// UPDATE文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// SQL文を実行し成功したらtrueを返す
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//ロールバックするためのExceptionを作る

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

}