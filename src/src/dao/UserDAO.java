package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllBeans;
import model.User;

public class UserDAO {

	// insert
	//ここの引数減らしたい
	public boolean insert(String userId,String userPw,String userName) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// usertableのINSERT文を準備する
			String sql1 = "INSERT INTO User (user_id,user_pw,user_name) VALUES (?,?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);

			pStmt1.setString(1,userId);
			pStmt1.setString(2,userPw);
			pStmt1.setString(3,userName);

			//pagetableのINSERT文を準備する
			//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			//page_flagを1にする
			String sql2 = "INSERT INTO Page (page_flag) VALUES (1)";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			//追加したpageidを取得
			String sql3 = "SELECT MAX(page_id) FROM Page";
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);

			//UPjoinのINSERT文を準備する
			//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			String sql4 = "INSERT INTO UPjoin (user_id, page_id) VALUES (?, ?)";
			PreparedStatement pStmt4 = conn.prepareStatement(sql4);

			pStmt4.setString(1, userId);

			int ans = 0;
			conn.setAutoCommit(false);//＝オートコミットを切る
			ans += pStmt1.executeUpdate();
			ans += pStmt2.executeUpdate();

			//PageのINSERT後にSQL文を実行し、結果表を取得する
			ResultSet rs = pStmt3.executeQuery();
			rs.next();
			String pageId = rs.getString("MAX(page_id)");

			//取得したpage_idをsql4にセット
			pStmt4.setString(2 ,pageId);

			ans += pStmt4.executeUpdate();


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

	//select ログインするためのメソッド
	// ログインできるならtrueを返す
	public User Login(String userId, String userPw) {
		Connection conn = null;
		User user = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を完成させる
			String sql = "select * from user where user_id = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, userId);
			pStmt.setString(2, userPw);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする

			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setIconId(rs.getString("icon_id"));
				user.setUserFlag(rs.getString("user_flag"));

			}



		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			user = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					user = null;
				}
			}
		}

		// 結果を返す
		return user;
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
			String sql1 = "SELECT *  FROM User LEFT OUTER JOIN Icon ON User.icon_id = Icon.icon_id WHERE user_id= ?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			pStmt1.setString(1,userId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt1.executeQuery();

			//まだ未完成 変更をしていないところ
			// 結果表をコレクションにコピーする あとで改造
			while (rs.next()) { //rsインスタンスの内容を全て取り出す
				AllBeans all = new AllBeans();
				all.setUserId(rs.getString("user_id"));
				all.setUserPw(rs.getString("user_pw"));
				all.setUserName(rs.getString("user_name"));
				all.setIconId(rs.getString("icon_id"));
				all.setIconPath(rs.getString("icon_path"));

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
			String sql1 = "SELECT *  FROM User LEFT OUTER JOIN UPjoin ON User.user_id = UPjoin.user_id LEFT OUTER JOIN Page ON UPjoin.page_id = Page.page_id WHERE User.user_id= ?";
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			pStmt1.setString(1,userId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt1.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) { //rsインスタンスの内容を全て取り出す
				AllBeans all = new AllBeans();
				all.setUserPw(rs.getString("user_page_id"));
				all.setUserId(rs.getString("user_id"));
				all.setPageId(rs.getString("page_id"));
				all.setPageTitle(rs.getString("page_title"));

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


	//pageflagが1のpageidとpagetitleを取得
		public ArrayList<AllBeans> upselect(String userId) {
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
				String sql1 = "SELECT * FROM upjoin LEFT OUTER JOIN page ON upjoin.page_id = page.page_id WHERE upjoin.user_id =? AND page.page_flag =1";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);
				pStmt1.setString(1,userId);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt1.executeQuery();


				// 結果表をコレクションにコピーする
				while (rs.next()) { //rsインスタンスの内容を全て取り出す
					AllBeans all = new AllBeans();
					all.setPageId(rs.getString("page_id"));
					all.setPageId(rs.getString("page_title"));

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
			String sql = "UPDATE User SET user_pw= ?,user_name= ?,icon_id= ? WHERE user_id= ?";
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
			String sql = "UPDATE User SET user_flag= 0 WHERE user_id=?";//SQL文記述
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