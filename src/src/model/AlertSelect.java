package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlertSelect {

	public static void main (String[] args){
//		StockDAO sdao = new StockDAO();
//
//		ArrayList<AllBeans> alertList = sdao.selectAlert("2");
//
//		for(AllBeans alert : alertList) {
//			System.out.println(alert.getItemId());
//			System.out.println(alert.getItemAlertday());
//			System.out.println(alert.getStockName());
//			System.out.println(alert.getStockAlertday1());
//			System.out.println(alert.getStockAlertday2());
//			System.out.println(alert.getStockAlertday3());
//			System.out.println(alert.getStockAlertday4());
//			System.out.println("ここまで");
//		}
//
////		AlertSelect a = new AlertSelect();
//		ArrayList<Message> alertDays = alertDay(alertList);
//
//		for(Message message : alertDays) {
//			System.out.println(message.getStockMessage());
//			System.out.println(message.getItemMessage());
//		}
	}






	// 賞味期限アラートを作成
	public ArrayList<Message> alertDay(ArrayList<AllBeans> alertList){

		ArrayList<Message> alertDays = new ArrayList<Message>();//戻り値


		//今日の日付を取得
		Date today = new Date();
		System.out.println("today：" + today);
		//文字列のフォーマットを指定
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");

		String stockName, itemName;

		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		Date date4 = new Date();
		Date date5 = new Date();

		int ans1, ans2, ans3, ans4, ans5;

		//メッセージを入れる
		String stockMessage,itemMessage;

		try {
			for(AllBeans alert : alertList) {

				stockName = alert.getStockName();
				itemName = alert.getItemName();

				//String型をDate型に変換する
				date1 = sdFormat.parse(alert.getStockAlertday1());
				date2 = sdFormat.parse(alert.getStockAlertday2());
				date3 = sdFormat.parse(alert.getStockAlertday3());
				date4 = sdFormat.parse(alert.getStockAlertday4());
				date5 = sdFormat.parse(alert.getItemAlertday());

				//Beansを実体化
			    Message message = new Message();

			    ans1 = date1.compareTo(today);
			    ans2 = date2.compareTo(today);
			    ans3 = date3.compareTo(today);
			    ans4 = date4.compareTo(today);

				//もし今日より一週間後が過去だったら
				if (ans4 == 0 || ans4 == -1){
					//｛日付 ｝｛在庫名｝の賞味期限が１週間経過しました。
					stockMessage = alert.getStockAlertday4() + "　" + stockName + "の賞味期限が１週間経過しました。";
					message.setStockMessage(stockMessage);
				}
				 //もし今日より二日後が過去だったら
				else if(ans3 == 0 || ans3 == -1) {
					//｛日付 ｝｛在庫名｝の賞味期限が2日経過しました。
					stockMessage = alert.getStockAlertday3() +"　"+ stockName + "の賞味期限が2日経過しました。";
					message.setStockMessage(stockMessage);

				}
				//もし当日より今日が過去だったら
				else if (ans2 == 0 || ans2 == -1){
					//｛日付 ｝｛在庫名｝の賞味期限は今日です。
					stockMessage = alert.getStockAlertday2() + "　" + stockName + "の賞味期限は今日です。";
					message.setStockMessage(stockMessage);
				}
				//もし二日前が今日より過去だったら
				else if (ans1 == 0 || ans1 == -1){
					//｛日付 ｝｛在庫名｝の賞味期限は明後日です。
					stockMessage = alert.getStockAlertday1() + "　" + stockName + "の賞味期限は明後日です。";
					message.setStockMessage(stockMessage);
				}
//				else {
//					stockMessage = null;
//					message.setStockMessage(stockMessage);
//				}

				//ここまで賞味期限アラート


				//ここから買い替えアラート

				ans5 = date5.compareTo(today);

				if (ans5 == 0 || ans5 == -1) {
					//{日付} {項目名}の買い替え時期です。
					//ほんとはこれをBeansにセットしたい
					itemMessage = alert.getItemAlertday() + "　" + itemName + "の買い替え時期です。" ;
					message.setItemMessage(itemMessage);
				}
//				else {
//					itemMessage = null;
//					message.setItemMessage(itemMessage);
//				}

				alertDays.add(message);
			}
		}

		catch (ParseException e) {//エラー出たときどうしよう？
			e.printStackTrace();
			alertDays = null;
		}

       return alertDays;

	}

}



