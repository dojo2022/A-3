package model;

import java.util.Calendar;
import java.util.Date;




public class Alert {

//	public static void main(String args[]) {
//		aaaaa(1);
//		aaaaa(2);
//		aaaaa(3);
//		aaaaa(4);
//		aaaaa(5);
//	}

	public static void aaaa() {
		//期限日アラート（stock依存）
		//期限日（stock_limit）を取得

		//2日前（stock_alertday1）、当日（stock_alertday2）、2日後（stock_alertday3）、1週間後（stock_alertday4）を計算


		//日時を格納するためのDateクラスを宣言(現在時刻)
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		Date date4 = new Date();

		//Calendar型に変換
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


	public static void aaaaa(int num) {
		//買い替えアラート(item依存)

		//残量切れ日(item_lostday)、アラート期間（item_alert）を取得
		//残量切れ日（残量なしボタンが押された日）の算出
		Date lostday = new Date();

		//Date型をCalendar型に変換（計算のため）
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(lostday);

        //アラート期間の条件を変数numに格納

		//残量切れ日+アラート期間（なし=1、３日後=2、１週間後=3、２週間後=4、１カ月後=5）を計算、買い替えアラート日（item_alertday）を算出
        if (num == 2) {
        	calendar.add(Calendar.DAY_OF_MONTH, 3);
        } else if (num == 3) {
        	calendar.add(Calendar.DAY_OF_MONTH, 7);
        } else if (num == 4) {
        	calendar.add(Calendar.DAY_OF_MONTH, 14);
        } else if (num == 5) {
        	calendar.add(Calendar.MONTH, 1);
        } else {
        	calendar.set(Calendar.YEAR, 9999);
        	calendar.set(Calendar.MONTH, 12);
        	calendar.set(Calendar.DAY_OF_MONTH, 31);
//        	SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
//        	Date date = df.parse("2000/12/31");
//        	calendar.setTime(date);
        }

        //Date型に変換
        lostday = calendar.getTime();
        System.out.println(lostday);

        //SQLDate型に変換
        java.sql.Date alertday = new java.sql.Date(lostday.getTime());
        System.out.println(alertday);


		//買い替えアラート日（item_alertday）を返す（orセットする）
	}

}
