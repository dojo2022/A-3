package test;

import java.util.ArrayList;

import dao.ItemDAO;
import dao.StockDAO;
import model.AllBeans;

public class TestItemDAO {


	public static void main(String[] args) {
		ItemDAO idao = new ItemDAO();
		StockDAO sdao = new StockDAO();

//		// insert()のテスト
//		System.out.println("---------- insert()のテスト ----------");
//		if (idao.insert("ごぼう", "0" , "1" ,"1" ,"1","ごぼう","2020-06-22" ,"2020-07-01","2020-06-29","2020-07-01" ,"2020-07-03"  ,"2020-07-08" )) {
//			System.out.println("登録成功！");
//
//			ArrayList<AllBeans> stockList = sdao.select("1");
//			for (AllBeans main : stockList) {
//				System.out.println("itemId：" + main.getItemId());
//				System.out.println("itemName：" + main.getItemName());
//				System.out.println("itemFavorite：" +  main.getItemFavorite());
//				System.out.println("itemRemain：" +  main.getItemRemain());
//				System.out.println("itemLostday：" +  main.getItemLostday());
//				System.out.println("categoryId：" +  main.getCategoryId());
//				System.out.println("pageId：" + main.getPageId());
//				System.out.println("itemAlert：" + main.getItemAlert());
//				System.out.println("itemAlertday：" + main.getItemAlertday());
//				System.out.println("stockId：" + main.getStockId());
//				System.out.println("stockName：" + main.getStockName());
//				System.out.println("stockBuy：" + main.getStockBuy());
//				System.out.println("stockLimit：" + main.getStockLimit());
//				System.out.println("stockAlert：" + main.getStockAlert());
//				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
//				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
//				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
//				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
//				System.out.println("categoryName：" + main.getCategoryName());
//
//			}
//		}
//		else {
//			System.out.println("登録失敗！");
//		}




		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		if (idao.update("カントリーマーム", "1" , "1", "2020-06-22", "3", "1","1", "1", "ぐみ","2020-06-22" ,"2020-06-22","1", "2020-06-22" ,"2020-06-22" ,"2020-06-22" ,"2020-06-22" , "11","6")) {
			System.out.println("登録成功！");

			ArrayList<AllBeans> stockList = sdao.select("3");
			for (AllBeans main : stockList) {
				System.out.println("itemId：" + main.getItemId());
				System.out.println("itemName：" + main.getItemName());
				System.out.println("itemFavorite：" +  main.getItemFavorite());
				System.out.println("itemRemain：" +  main.getItemRemain());
				System.out.println("itemLostday：" +  main.getItemLostday());
				System.out.println("categoryId：" +  main.getCategoryId());
				System.out.println("pageId：" + main.getPageId());
				System.out.println("itemAlert：" + main.getItemAlert());
				System.out.println("itemAlertday：" + main.getItemAlertday());
				System.out.println("stockId：" + main.getStockId());
				System.out.println("stockName：" + main.getStockName());
				System.out.println("stockBuy：" + main.getStockBuy());
				System.out.println("stockLimit：" + main.getStockLimit());
				System.out.println("stockAlert：" + main.getStockAlert());
				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
				System.out.println("getStockAlertday1：" + main.getStockAlertday1());
				System.out.println("categoryName：" + main.getCategoryName());

			}
		}
		else {
			System.out.println("登録失敗！");
		}








	}

}
