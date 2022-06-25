package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlertSelect {

	public static void main (String[] args){

		String[] stockAlert  = stockAlert();

		for(String s : stockAlert) {
			System.out.println(s);
		}
}

		//今日の日付から賞味期限アラートの対象となる日付を計算する
		public static String[] stockAlert(){
			//配列を用意
			String[] stockAlert = new String[8];

			//今日の日付を取得
			Date stockAlert0_0 = new Date();
			Date stockAlert0_1 = new Date();
			Date stockAlert1_0 = new Date();
			Date stockAlert1_1 = new Date();
			Date stockAlert2_0 = new Date();
			Date stockAlert2_1 = new Date();
			Date stockAlert3_0 = new Date();
			Date stockAlert3_1 = new Date();

			//Date型をCalendar型に変換（計算のため）
		    Calendar calendar0_0 = Calendar.getInstance();
		    calendar0_0.setTime(stockAlert0_0);
		    Calendar calendar0_1 = Calendar.getInstance();
		    calendar0_1.setTime(stockAlert0_1);
		    Calendar calendar1_0 = Calendar.getInstance();
		    calendar1_0.setTime(stockAlert1_0);
		    Calendar calendar1_1 = Calendar.getInstance();
		    calendar1_1.setTime(stockAlert1_1);
		    Calendar calendar2_0 = Calendar.getInstance();
		    calendar2_0.setTime(stockAlert2_0);
		    Calendar calendar2_1 = Calendar.getInstance();
		    calendar2_1.setTime(stockAlert2_1);
		    Calendar calendar3_0 = Calendar.getInstance();
		    calendar3_0.setTime(stockAlert3_0);
		    Calendar calendar3_1 = Calendar.getInstance();
		    calendar3_1.setTime(stockAlert3_1);

		    //賞味期限2日前（stockAlert0_0、stockAlert0_1）を計算
		    calendar0_0.add(Calendar.DAY_OF_MONTH, 2);
		    calendar0_1.add(Calendar.DAY_OF_MONTH, 1);

		    //賞味期限当日（stockAlert1_0、stockAlert1_1）を計算
		    calendar1_1.add(Calendar.DAY_OF_MONTH, -1);

		    //賞味期限2日後（stockAlert2_0、stockAlert2_1）を計算
		    calendar2_0.add(Calendar.DAY_OF_MONTH, -2);
		    calendar2_1.add(Calendar.DAY_OF_MONTH, -3);

		  //賞味期限2日後（stockAlert3_0、stockAlert3_1）を計算
		    calendar3_0.add(Calendar.DAY_OF_MONTH, -7);
		    calendar3_1.add(Calendar.DAY_OF_MONTH, -8);

		    //Calender型からDate型を取得する
		    stockAlert0_0 = calendar0_0.getTime();
		    stockAlert0_1 = calendar0_1.getTime();
		    stockAlert1_0 = calendar1_0.getTime();
		    stockAlert1_1 = calendar1_1.getTime();
		    stockAlert2_0 = calendar2_0.getTime();
		    stockAlert2_1 = calendar2_1.getTime();
		    stockAlert3_0 = calendar3_0.getTime();
		    stockAlert3_1 = calendar3_1.getTime();

		  //Date型をString型に変換
		    String stockAlert00= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert0_0);
		    String stockAlert01= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert0_1);
		    String stockAlert10= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert1_0);
		    String stockAlert11= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert1_1);
		    String stockAlert20= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert2_0);
		    String stockAlert21= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert2_1);
		    String stockAlert30= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert3_0);
		    String stockAlert31= new SimpleDateFormat("yyyy-MM-dd").format(stockAlert3_1);

		  //期限アラート日をarrayにセットする
		    stockAlert[0]= stockAlert00;
		    stockAlert[1]= stockAlert01;
		    stockAlert[2]= stockAlert10;
		    stockAlert[3]= stockAlert11;
		    stockAlert[4]= stockAlert20;
		    stockAlert[5]= stockAlert21;
		    stockAlert[6]= stockAlert30;
		    stockAlert[7]= stockAlert31;

		  //結果を返す
		    return stockAlert;

		}



		// 買い替えアラート
		public static String itemAlert() {
			//変数を用意
			String itemAlert = "0";

			//今日の日付を取得
			Date today = new Date();

			//Date型をString型に変換
		    itemAlert = new SimpleDateFormat("yyyy-MM-dd").format(today);

			return itemAlert;

			}
}
