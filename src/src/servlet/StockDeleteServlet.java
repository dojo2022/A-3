package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StockDAO;

/**
 * Servlet implementation class StockDeleteServlet
 */
@WebServlet("/StockDeleteServlet")
public class StockDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//もしもログインしていなかったらログインサーブレットにリダイレクトする？
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user") == null) {
//			response.sendRedirect("/syokuzaikanri/LoginServlet");
//			return;
//		}

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String stockId = request.getParameter("stockId");

		//削除処理を行う
		StockDAO sDao = new StockDAO();

		//削除の結果をメインページに返す
		if (sDao.delete(stockId)) {
			HttpSession session = request.getSession();
			session.setAttribute("dsMsg", ("削除成功"));
			System.out.println("削除成功");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("dfMsg", ("削除失敗"));
			System.out.println("削除失敗");
		}

		// メインサーブレットにリダイレクトする
		response.sendRedirect("/syokuzaikanri/MainServlet");

	}

}
