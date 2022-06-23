package dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Stock;

/**
 * Servlet implementation class StockAjaxServlet
 */
@WebServlet("/StockAjaxServlet")
public class StockAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");

		// 送信されたデータ(購入日、期限日、アラート)の取得
		String stockBuy = request.getParameter("stockBuy");
		String stockLimit = request.getParameter("stockLimit");
		String bell = request.getParameter("bell");

		//ArrayListをインスタンス化
		ArrayList<Stock> list = new ArrayList<>();

		//適当な値を突っ込む
		for(int i=0;i<5;i++) {
			Stock jub = new Stock();
			jub.setStockBuy(stockBuy);
			jub.setStockLimit(stockLimit);
			jub.setStockAlert(bell);

			list.add(jub);
		}

		//期限日の計算をする(stockAlertday1 ,stockAlertday2 ,stockAlertday3,stockAlertday4)


		//引数をStockDAOのuptadeメソッドに渡し、stockBuy,stockLimit,bell,stockAlertday1-4をアップデート


		ObjectMapper mapper = new ObjectMapper();

		try {
            //JavaオブジェクトからJSONに変換
            String testJson = mapper.writeValueAsString(list);
            //JSONの出力
            response.getWriter().write(testJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

		//文字コードの設定（めんどいのでコピペでOK）
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");

//		//JSPに返却する値を作成する。値はoutの中に格納する
//		PrintWriter out = response.getWriter();
//		//outの中に持ってきたデータを連結したものを入れる
//		//勝手にJSPに渡り、dataという名前で使用することができる
//		out.print(data1+","+data2+","+data3);
//
//        return;

	}

}
