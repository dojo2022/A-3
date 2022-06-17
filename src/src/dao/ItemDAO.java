package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class ItemDAO {

	//insert
	public List<Memo> insert(int page_id){
		Connection conn = null;
		boolean result = false;
		List<Memo> memoList = new ArrayList<Memo>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

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
				memoList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				memoList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						memoList = null;
					}
				}
			}

			// 結果を返す
			return memoList;

	}


	//select


	//update


	//delete

}
