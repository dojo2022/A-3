package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AllBeans;
import model.Page;

public class PageDAO {

	//Insert
	public boolean insert(String pageTitle, String pageFlag, String userId, String pageId) {
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
			String sql1 = "INSERT INTO page (page_title , page_flag) VALUES ('?','1')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			// SQL文を完成させる
			pStmt1.setString(1, pageTitle);
			pStmt1.setString(2, pageFlag);

			//②	INSERT	UPjoin	user_id、page_id
			String sql2 = "INSERT INTO UPjoin (user_id , page_id) VALUES ('?','?')";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
			pStmt2.setString(1, userId);
			pStmt2.setString(2, pageId);
			//③	INSERT	memo	page_id
			String sql3 = "INSERT INTO UPjoin () VALUES ()";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt3 = conn.prepareStatement(sql3);
			// SQL文を完成させる


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
	public boolean update(Page param) {
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
	public ArrayList<AllBeans> select(AllBeans param) {
		Connection conn = null;
		ArrayList<AllBeans> AllBeansList = new ArrayList<AllBeans>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

		} catch (SQLException e) {
			e.printStackTrace();
			AllBeansList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			AllBeansList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					AllBeansList = null;
				}
			}
		}

		// 結果を返す
		return AllBeansList;
	}

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
