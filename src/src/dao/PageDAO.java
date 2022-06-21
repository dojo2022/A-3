package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PageDAO {

	//Insert
	public boolean insert(String pageTitle, String userId, String pageId) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を完成させる
			//①	INSERT	page	page_title
			// PageテーブルのINSERT文を準備する
			String sql1 = "INSERT INTO Page (page_title) VALUES (?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			// SQL文を完成させる
			pStmt1.setString(1, pageTitle);

			//②	INSERT	UPjoin	user_id、page_id
			String sql2 = "INSERT INTO UPjoin (user_id , page_id) VALUES (?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
			pStmt2.setString(1, userId);
			pStmt2.setString(2, pageId);


			//要らない説濃厚
			//③	INSERT	memo	page_id
			String sql3 = "INSERT INTO Memo (page_id) VALUES (?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);
			// SQL文を完成させる
			pStmt3.setString(1, pageId);//jnsert文memodao

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

	//update
	public boolean update(String pageTitle, String pageId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE Page SET page_title=? WHERE page_id=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, pageTitle);
			pStmt.setString(2, pageId);
			// SQL文を実行する
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

	/* 使わないかも
		//select
		public ArrayList<Page> select(String pageId) {
			Connection conn = null;
			ArrayList<Page> PageList = new ArrayList<Page>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// usertableにUPjointableとpagetableをくっつけたもののためのSQLを準備する
				String sql = "SELECT *  FROM Page WHERE page_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1,pageId);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする

				while (rs.next()) { //rsインスタンスの内容を全て取り出す

					Page page = new Page();
					page.setPageId(rs.getString("page_id"));
					page.setPageTitle(rs.getString("page_title"));

					PageList.add(page);
					}



			} catch (SQLException e) {
				e.printStackTrace();
				PageList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				PageList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						PageList = null;
					}
				}
			}

			// 結果を返す
			return PageList;
		}
	*/
	//deleteFlagでupdateしてデータを持ってこさせないようにする
	public boolean deleteFlag(String pageId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する改造する
			String sql = "UPDATE Page SET page_flag=0 where page_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, pageId);

			// SQL文を実行する
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
