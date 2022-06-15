package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Page;
public class PageDAO {

//Insert
	public List<Page> insert(String page_title){
		Connection conn = null;
		List<Page> pageList = new ArrayList<Page>();
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");



				}
					catch (SQLException e) {
						e.printStackTrace();
						pageList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						pageList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								pageList = null;
							}
				}
	}
				// 結果を返す
				return pageList;
				}
//select
	public List<Page> select(String page_id){
		Connection conn = null;
		List<Page> pageList = new ArrayList<Page>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");




		}
			catch (SQLException e) {
				e.printStackTrace();
				pageList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				pageList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						pageList = null;
					}
				}
			}

			// 結果を返す
			return pageList;
	}
	//update
	public List<Page> update(String page_id){
		Connection conn = null;
		List<Page> pageList = new ArrayList<Page>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");




		}
			catch (SQLException e) {
				e.printStackTrace();
				pageList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				pageList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						pageList = null;
					}
				}
			}

			// 結果を返す
			return pageList;
	}
	//delete
	public List<Page> delete(String page_id){
		Connection conn = null;
		List<Page> pageList = new ArrayList<Page>();//ArrayList <インスタンスの型名> 変数名 = new ArrayList<インスタンスの型名>;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");




		}
			catch (SQLException e) {
				e.printStackTrace();
				pageList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				pageList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						pageList = null;
					}
				}
			}

			// 結果を返す
			return pageList;
	}
	}
