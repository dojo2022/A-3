package model;

import java.util.Calendar;
import java.util.Date;




public class Alert {

	public static void main(String args[]) {
		aaaa();
	}

	public static void aaaa() {
		//期限日アラート（stock依存）
		//期限日（stock_limit）を取得

		//2日前（stock_alertday1）、当日（stock_alertday2）、2日後（stock_alertday3）、1週間後（stock_alertday4）を計算


		//日時を格納するためのDateクラスを宣言(現在時刻)
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		Date date4 = new Date();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date2);
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(date2);

        //Date型の持つ日時を表示
        System.out.println(date2);

        //Date型の持つ日時の4年後を表示(日時の加算)
        calendar1.add(Calendar.DAY_OF_MONTH, -2);
        calendar3.add(Calendar.DAY_OF_MONTH, 2);
        calendar4.add(Calendar.DAY_OF_MONTH, 7);

        //Calender型からDate型を取得する
        date1 = calendar1.getTime();
        date3 = calendar3.getTime();
        date4 = calendar4.getTime();

        //Date型からSQLDate型を取得する
        java.sql.Date alert1 = new java.sql.Date(date1.getTime());
        java.sql.Date alert2 = new java.sql.Date(date2.getTime());
        java.sql.Date alert3 = new java.sql.Date(date3.getTime());
        java.sql.Date alert4 = new java.sql.Date(date4.getTime());

        System.out.println(alert1);
        System.out.println(alert2);
        System.out.println(alert3);
        System.out.println(alert4);



		//期限アラート日を返す（orセットする）

	}

	public void aaaaa() {
		//買い替えアラート(item依存)
		//残量切れ日(item_lostday)、アラート期間（item_alert）を取得

		//残量切れ日+アラート期間を計算、買い替えアラート日（item_alertday）を算出

		//買い替えアラート日（item_alertday）を返す（orセットする）
	}

}
