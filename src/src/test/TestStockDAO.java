package test;

import java.util.ArrayList;

import dao.StockDAO;
import model.AllBeans;

public class TestStockDAO {
	public static void main(String[] args) {
		StockDAO sdao = new StockDAO();



		// insert()のテスト
				System.out.println("---------- insert()のテスト ----------");
			//	Bc insRec = new Bc("0006", "西脇 隆俊", "602-8570", "京都市上京区下立売通新町西入薮ノ内町", "関西", "075-451-8111", "kyoto");
				if (sdao.insert("ロールキャベツ","2022-06-21","2022-06-30", "4","2022-06-28", "2022-06-30", "2020-07-02", "2020-07-07")) {
					System.out.println("登録成功！");

					ArrayList<AllBeans> stockList = sdao.select("1");
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
