package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class MemoDAO {
	//select
	public List<Memo> select(String pageId) {
		Connection conn = null;
		List<Memo> memoList = new ArrayList<Memo>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

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
				memo.setMemoId(rs.getString("memoId"));
				memo.setMemoItem(rs.getString("memoItem"));
				memo.setMemoCheck(rs.getString("memoCheck"));

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

	// update
	public boolean update(String memoItem, String memoCheck, String memoId) {
		Connection conn = null;
		boolean result = false; //結果を表す変数（初期値は失敗）

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//memoのupdateSQL文を準備する
			String sql = "UPDATE Memo SET memo_item = ?, memo_check = ? WHERE memo_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,memoItem);
			pStmt.setString(2,memoCheck);
			pStmt.setString(3,memoId);

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