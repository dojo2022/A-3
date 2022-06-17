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
			String sql1 = "INSERT INTO user (user_id,user_pw,user_name) VALUES ('?','?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1, param.getUser_id());
			pStmt1.setString(2, param.getUser_pw());
			pStmt1.setString(3, param.getUser_name());

			//pagetableのINSERT文を準備する
			//"INSERT INTO user (page_id,page_title,page_flag) VALUES ('?','?','?')";

			String sql2 = "INSERT INTO user () VALUES ('?','?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt1.setString(1, param.getUser_id());
			pStmt1.setString(2, param.getUser_pw());
			pStmt1.setString(3, param.getUser_name());

			//UPjoinのINSERT文を準備する

			/// INSSERT文を準備する
			String sql = "";//SQL文記述
			PreparedStatement pStmt = conn.prepareStatement(sql);


			int ans = 0;
			conn.beginRequest();//調べておいてね～～
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();
			ans += pStmt3.executeUpdate();

			if(ans == 3) {
				conn.commit();
				result = true;
			}else {
				conn.rollback();
				result = false;
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