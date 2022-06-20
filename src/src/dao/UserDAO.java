package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllBeans;

public class UserDAO {

	// insert
	public boolean insert(String userId,String userPw,String userName,String pageTitle,String pageId,String memoItem,String memoCheck) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// usertableのINSERT文を準備する
			String sql1 = "INSERT INTO User (user_id,user_pw,user_name) VALUES ('?','?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1,userId);
			pStmt1.setString(2,userPw);
			pStmt1.setString(3,userName);

			//pagetableのINSERT文を準備する
			//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			String sql2 = "INSERT INTO Page (page_title) VALUES ('?')";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			pStmt2.setString(1,pageTitle);

			//UPjoinのINSERT文を準備する
			//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			String sql3 = "INSERT INTO UPjoin (user_id,page_id) VALUES ('?','?')";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			pStmt3.setString(1,userId);
			pStmt3.setString(2,pageId);//Intで大丈夫？？

			//MemoのINSERT文を準備する
			//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			String sql4 = "INSERT INTO Memo (memo_item,memo_check) VALUES ('?','?')";
			PreparedStatement pStmt4 = conn.prepareStatement(sql4);

			pStmt4.setString(1,memoItem);
			pStmt4.setString(2,memoCheck);

			int ans = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();
			ans += pStmt3.executeUpdate();
			ans += pStmt4.executeUpdate();

			if (ans == 4) {
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

	//select ログインするためのメソッド
	// ログインできるならtrueを返す
	public boolean Login(String userId, String userPw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を完成させる
			String sql = "select count(*) from user where user_id = '?' and user_pw = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);
			pStmt.setString(2, userPw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする

			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	//select  アカウント編集系
	//（ハンバーガーメニューにも使えるのでは？）
	public ArrayList<AllBeans> select(String userId) {
		Connection conn = null;
		ArrayList<AllBeans> userList = new ArrayList<AllBeans>();//ArrayListの名前変えないと？

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SELECT文を完成させる

			//トランザクションする必要あり？

			// usertableにicontableをくっつけたもののためのSQLを準備する
			String sql1 = "SELECT *  FROM User LEFT OUTER JOIN icon ON user.icon_id = icon.icon_id WHERE user_id='?'";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			pStmt1.setString(1,userId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt1.executeQuery();

			//まだ未完成 変更をしていないところ
			// 結果表をコレクションにコピーする あとで改造
			while (rs.next()) { //rsインスタンスの内容を全て取り出す
				AllBeans all = new AllBeans();
				all.setUserId(rs.getString("userId"));
				all.setUserPw(rs.getString("userPw"));
				all.setUserName(rs.getString("userName"));
				all.setIconId(rs.getString("iconId"));
				all.setIconPath(rs.getString("iconPath"));

				userList.add(all);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			userList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			userList = null;

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

	//ページ用ハンバーガーに使うデータを取ってくる
	public ArrayList<AllBeans> phselect(String userId) {
		Connection conn = null;
		ArrayList<AllBeans> phList = new ArrayList<AllBeans>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SELECT文を完成させる

			//トランザクションする必要あり？

			// usertableにUPjointableとpagetableをくっつけたもののためのSQLを準備する
			String sql1 = "SELECT *  FROM User LEFT OUTER JOIN UPjoin ON user.user_id = UPjoin.user_id LEFT OUTER JOIN page ON UPjoin.page_id = page.page_id WHERE user.user_id='?'";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			pStmt1.setString(1,userId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt1.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) { //rsインスタンスの内容を全て取り出す
				AllBeans all = new AllBeans();
				all.setUserPw(rs.getString("userPageId"));
				all.setUserId(rs.getString("userId"));
				all.setPageId(rs.getString("pageId"));
				all.setPageTitle(rs.getString("pageTitle"));


				phList.add(all);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			phList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			phList = null;

		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					phList = null;
				}
			}
		}

		// 結果を返す
		return phList;
	}


	//update
	public boolean update(String userPw, String userName, String iconId, String userId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//// UserUPDATE文を準備する
			String sql = "UPDATE User SET user_pw='?',user_name='?',icon_id='?' where user_id='?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userPw);
			pStmt.setString(2, userName);
			pStmt.setString(3, iconId);
			pStmt.setString(4, userId);

			// SQL文を実行し成功したらtrueを返す
			if (pStmt.executeUpdate() == 1) {
				result = true;
				conn.commit();
			} else {
				conn.rollback(); //sql文が一つでもできていなければロールバックする
				result = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();

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

	//deleteFlag
	public boolean deleteFlag(String userId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");


			//// Userのuserflag UPDATE文を準備する
			String sql = "UPDATE User SET user_flag='0' where user_id=?;";//SQL文記述
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);

			// SQL文を実行し成功したらtrueを返す
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();

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

}