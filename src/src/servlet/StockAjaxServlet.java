package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StockDAO;
import model.Alert;

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

		// リクエストパラメータ(購入日、期限日、アラート)の取得
		String stockId = request.getParameter("stockId");
		String stockName = request.getParameter("stockName");
		String stockBuy = request.getParameter("stockBuy");
		String stockLimit = request.getParameter("stockLimit");
		String bell = request.getParameter("bell");



		//期限日の計算をする(stockAlertday1 ,stockAlertday2 ,stockAlertday3,stockAlertday4)
		Alert alert = new Alert();
		String[] str = alert.stockAlert(stockLimit);

		//期限日が計算されている前提（エラー未想定）
		//stockAlertday1～4を定義
		String stockAlertday1 = str[0];
		String stockAlertday2 = str[1];
		String stockAlertday3 = str[2];
		String stockAlertday4 = str[3];

		//引数をStockDAOのuptadeメソッドに渡し、stockBuy,stockLimit,bell,stockAlertday1-4をアップデート
		StockDAO sDao = new StockDAO();
		boolean stockUp = sDao.update(stockName, stockBuy, stockLimit, bell, stockId, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4);

//		検索結果をリクエストスコープに格納する(要らないかも？)
//		request.setAttribute("stockUp", stockUp);


		//登録出来なかったらアラート？
		if(stockUp == false) {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", ("登録失敗"));
			System.out.println("登録失敗");
		}




	}

}
