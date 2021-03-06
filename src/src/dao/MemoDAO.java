package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Memo;

public class MemoDAO {
	//selectメソッド
	public ArrayList<Memo> select(String pageId) {
		Connection conn = null;
		ArrayList<Memo> memoList = new ArrayList<Memo>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// memoのselectSQL文を準備する
			String sql = "SELECT * FROM Memo WHERE page_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, pageId);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();//ResultSetはなんでも入る表のようなもの4

			// 結果表をコレクションにコピーする
			while (rs.next()) { //rsインスタンスの内容を全て取り出す
				Memo memo = new Memo();
				//memo.setMemoId(rs.getString("memo_id"));
				memo.setMemoItem(rs.getString("memo_item"));
				//memo.setMemoCheck(rs.getString("memo_check"));

				memoList.add(memo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			memoList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			memoList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					memoList = null;
				}
			}
		}

		// 結果を返す
		return memoList;
	}


	//insertメソッド
	// ,String pageId
	public int insert(String str, String pageId) {
		Connection conn = null;
		int ans = 0;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を完成させる
			//①	memoINSERT


			//memoのINSERT文を準備する(下の２行はエラーになったら外（↑）に出してあげる
			String sql = "INSERT INTO memo (memo_item,page_id) VALUES (?,?)";//INSERT INTO テーブル名（列名A,列名B,…） VALUES（値A,値B,…）
			PreparedStatement pStmt = conn.prepareStatement(sql);


//
//			//どうやってpage_idをもってきて、それをくっつけるのか
			pStmt.setString(1, str);
			pStmt.setString(2, pageId);
			ans =  pStmt.executeUpdate();

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
		return ans;
	}

	//delateメソッド
	public boolean delete(String pageId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "DELETE FROM memo WHERE page_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, pageId);

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