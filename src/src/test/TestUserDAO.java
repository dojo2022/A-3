package test;

import dao.UserDAO;

public class TestUserDAO {
	public static void main(String[] args) {
		UserDAO udao = new UserDAO();

		//insertのテスト　成功	齊藤
		System.out.println("---------- insert()のテスト ----------");
		if (udao.insert("takoyaki@yaketa","takosan","takoyaki")) {
			System.out.println("登録成功！");

		}
	else {
		System.out.println("登録失敗！");
	}

//		//途中だよ　齊藤
//		//selectのテスト
//		System.out.println("---------- select()のテスト ----------");
//		ArrayList<AllBeans> phList = udao.phselect("ishii-takahiro@kanransha");
//
//		for(AllBeans all : phList) {
//			System.out.println(all.getUserId());
//			System.out.println(all.getUserPw());
//			System.out.println(all.getUserName());
//			System.out.println(all.getIconId());
//			System.out.println(all.getIconPath());
//		}





	}
}
