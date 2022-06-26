package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.ItemDAO;




public class Alert {

//	public static void main(String args[]) {
//		Item i =itemAlert("40");
//
//		System.out.println(i.getItemLostday());
//		System.out.println(i.getItemAlertday());
//	}

	//期限日アラート（stock依存）
	public String[] stockAlert(String stockLimit) {//期限日（stock_limit）を取得
		String[] array = new String[4];
		try {
			if (stockLimit == null || stockLimit == "" || stockLimit == "9999-12-31") {
				array[0] = "9999-12-31";
				array[1] = "9999-12-31";
				array[2] = "9999-12-31";
				array[3] = "9999-12-31";
			} else {
				//文字列のフォーマットを指定
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
				//String型をDate型に変換する
				Date date2 = sdFormat.parse(stockLimit);

				//Date型を現在日時でインスタンス化
				Date date1 = new Date();
				Date date3 = new Date();
				Date date4 = new Date();

		        //Date型の持つ日時を表示
		        System.out.println(date2);

				//Calendar型に変換
			    Calendar calendar1 = Calendar.getInstance();
			    calendar1.setTime(date2);
			    Calendar calendar3 = Calendar.getInstance();
			    calendar3.setTime(date2);
			    Calendar calendar4 = Calendar.getInstance();
			    calendar4.setTime(date2);

			    //2日前（stock_alertday1）、当日（stock_alertday2）、2日後（stock_alertday3）、1週間後（stock_alertday4）を計算
			    calendar1.add(Calendar.DAY_OF_MONTH, -2);
			    calendar3.add(Calendar.DAY_OF_MONTH, 2);
			    calendar4.add(Calendar.DAY_OF_MONTH, 7);

			    //Calender型からDate型を取得する
			    date1 = calendar1.getTime();
			    date3 = calendar3.getTime();
			    date4 = calendar4.getTime();

	//		    //Date型からSQLDate型を取得する
	//		    java.sql.Date alert1 = new java.sql.Date(date1.getTime());
	//		    java.sql.Date alert2 = new java.sql.Date(date2.getTime());
	//		    java.sql.Date alert3 = new java.sql.Date(date3.getTime());
	//		    java.sql.Date alert4 = new java.sql.Date(date4.getTime());

				//Date型をString型に変換
			    String alert1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
			    String alert2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
			    String alert3 = new SimpleDateFormat("yyyy-MM-dd").format(date3);
			    String alert4 = new SimpleDateFormat("yyyy-MM-dd").format(date4);

			    //期限アラート日をarrayにセットする
			    array[0] = alert1;
			    array[1] = alert2;
			    array[2] = alert3;
			    array[3] = alert4;
			}

		} catch (ParseException e) {//エラー出たときどうしよう？
			e.printStackTrace();
			array = null;
		}

		for (String str : array) {
			System.out.println(str);
		}
		System.out.println(array.length);

	    //結果を返す
	    return array;

	}

	//買い替えアラート 買い替えアラート期間(item_Alert)切り替えによる計算
	//ItemUpdateDeleteServlet用
	public String itemAlertEdit(String itemLostday, String itemAlert) {
		String itemAlertday = new String();//戻り値1

		try {
			if (itemLostday == "9999-12-31" || itemLostday == null) {
				itemAlertday = "9999-12-31";
			} else {
				//文字列のフォーマットを指定
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
				//String型をDate型に変換する
				Date lostday = sdFormat.parse(itemLostday);

				//Date型をCalendar型に変換（計算のため）
			    Calendar calendar = Calendar.getInstance();
			    calendar.setTime(lostday);

				//残量切れ日+アラート期間（なし=1、即日=2、３日後=3、１週間後=4、２週間後=5、１カ月後=6）を計算、買い替えアラート日（item_alertday）を算出
				if (itemAlert == "3") {
					calendar.add(Calendar.DAY_OF_MONTH, 3);
				} else if (itemAlert == "4") {
					calendar.add(Calendar.DAY_OF_MONTH, 7);
				} else if (itemAlert == "5") {
					calendar.add(Calendar.DAY_OF_MONTH, 14);
				} else if (itemAlert == "6") {
					calendar.add(Calendar.MONTH, 1);
				} else if (itemAlert == "1"){
					calendar.set(Calendar.YEAR, 9999);
					calendar.set(Calendar.MONTH, 11);
					calendar.set(Calendar.DAY_OF_MONTH, 31);
				}

				//Calender型からDate型を取得する
				Date date = calendar.getTime();
				System.out.println(date);

				//Date型をString型に変換
				itemAlertday = new SimpleDateFormat("yyyy-MM-dd").format(date);
			}

		} catch (Exception e) {//エラー出たときどうしよう？
			e.printStackTrace();
			itemAlertday = null;
		}

		//結果を返す
		return itemAlertday;
	}

	//買い替えアラート 残量ボタン(item_remain)切り替えによる計算
	//ItemAjaxServlet用
	public Item itemAlertButton(String itemRemain, String itemId) {
		Item item = new Item();//戻り値格納用
		String itemLostday = new String();//戻り値1
		String itemAlertDay = new String();//戻り値2

		try {
			if (itemRemain != "1") {
				itemLostday = "9999-12-31";
				itemAlertDay = "9999-12-31";
			} else {
				//残量切れ日（残量なしボタンが押された日）の算出
				Date lostday = new Date();

				//Date型をCalendar型に変換（計算のため）
				Date date = new Date();
			    Calendar calendar = Calendar.getInstance();
			    calendar.setTime(date);

				//アラート期間（item_alert）を取得
				String itemAlert = new String();
				ItemDAO iDao = new ItemDAO();
				ArrayList<AllBeans> list = iDao.select(itemId);
				for (AllBeans a : list) {
					itemAlert = a.getItemAlert();
				}
				System.out.println(itemAlert);

				//残量切れ日+アラート期間（なし=1、即日=2、３日後=3、１週間後=4、２週間後=5、１カ月後=6）を計算、買い替えアラート日（item_alertday）を算出
				if (itemAlert == "3") {
					calendar.add(Calendar.DAY_OF_MONTH, 3);
				} else if (itemAlert == "4") {
					calendar.add(Calendar.DAY_OF_MONTH, 7);
				} else if (itemAlert == "5") {
					calendar.add(Calendar.DAY_OF_MONTH, 14);
				} else if (itemAlert == "6") {
					calendar.add(Calendar.MONTH, 1);
				} else if (itemAlert == "1"){
					calendar.set(Calendar.YEAR, 9999);
					calendar.set(Calendar.MONTH, 11);
					calendar.set(Calendar.DAY_OF_MONTH, 31);
				}

				//Calender型からDate型を取得する
				date = calendar.getTime();
				System.out.println(date);

				//Date型をString型に変換
				itemLostday = new SimpleDateFormat("yyyy-MM-dd").format(lostday);
				itemAlertDay = new SimpleDateFormat("yyyy-MM-dd").format(date);
			}

			//残量切れ日と買い替えアラート日（item_alertday）をセットする
			item.setItemLostday(itemLostday);
			item.setItemAlertday(itemAlertDay);

		} catch (Exception e) {//エラー出たときどうしよう？
			e.printStackTrace();
			item = null;
		}

		//結果を返す
		return item;
	}

}
