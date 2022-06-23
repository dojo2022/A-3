package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;
import model.Alert;

/**
 * Servlet implementation class ItemRegistServlet
 */
@WebServlet("/ItemRegistServlet")
public class ItemRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする？
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/syokuzaikanri/LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("itemName");
		String categoryId = request.getParameter("categoryId");
		String itemFavorite = request.getParameter("itemFavorite");
		String itemAlert = request.getParameter("itemAlert");
		String stockName = request.getParameter("stockName");
		String stockBuy = request.getParameter("stockBuy");
		String stockLimit = request.getParameter("stockLimit");
		//ページIDはリクエストパラメータで取得する！！
		String pageId = request.getParameter("pageId");

		//期限日の計算を行う
		Alert alert = new Alert();
		String[] str = alert.stockAlert(stockLimit);

		//期限日が計算されている前提（エラー未想定）
		//stockAlertday1～4を定義
		String stockAlertday1 = str[0];
		String stockAlertday2 = str[1];
		String stockAlertday3 = str[2];
		String stockAlertday4 = str[3];

		//登録処理を行う
		ItemDAO iDao = new ItemDAO();
//		//JSPに返却する値を作成する。値はoutの中に格納する
//		PrintWriter out = response.getWriter();

		if (iDao.insert(itemName, itemFavorite, categoryId, pageId, itemAlert, stockName, stockBuy, stockLimit, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4)) {
//			out.print("登録成功");
		} else {
//			out.print("登録失敗");
		}

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
