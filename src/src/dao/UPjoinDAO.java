package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UPjoin;

public class UPjoinDAO {

	//insert
	public List<UPjoin> insert(String user_id, int page_id){
		Connection conn = null;
		List<UPjoin> upjoinList = new ArrayList<UPjoin>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");




		}
			catch (SQLException e) {
				e.printStackTrace();
				upjoinList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				upjoinList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						upjoinList = null;
					}
				}
			}

			// 結果を返す
			return upjoinList;

	}


	//select

	public List<UPjoin> select(int page_id){
		Connection conn = null;
		List<UPjoin> upjoinList = new ArrayList<UPjoin>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");




		}
			catch (SQLException e) {
				e.printStackTrace();
				upjoinList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				upjoinList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						upjoinList = null;
					}
				}
			}

			// 結果を返す
			return upjoinList;
	}


}
