package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import model.Alert;
import model.User;

/**
 * Servlet implementation class ItemUpdateDeleteServlet
 */
@WebServlet("/ItemUpdateDeleteServlet")
public class ItemUpdateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.getAttribute("user");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/syokuzaikanri/LoginServlet");
			return;
		}

		//セッションからitemidを取得
		User user = (User)session.getAttribute("user");
		String itemId = user.getUserId();



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.getAttribute("user");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/syokuzaikanri/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("itemName");
		String categoryId = request.getParameter("categoryId");
		String itemFavorite = request.getParameter("itemFavorite");
		String itemAlert = request.getParameter("itemAlert");
		String stockName = request.getParameter("stockName");
		String stockBuy = request.getParameter("stockBuy");
		String stockLimit = request.getParameter("stockLimit");
		//inout type=hiddenもリクエストパラメータで取得する！！
		String pageId = request.getParameter("pageId");
		String itemRemain = request.getParameter("itemRemain");
		String itemLostday = request.getParameter("itemLostday");
		String itemId = request.getParameter("itemId");

		//期限日の計算を行う
		Alert alert = new Alert();
		String[] str = alert.stockAlert(stockLimit);

		//期限日が計算されている前提（エラー未想定）
		//stockAlertday1～4を定義
		String stockAlertday1 = str[0];
		String stockAlertday2 = str[1];
		String stockAlertday3 = str[2];
		String stockAlertday4 = str[3];

		// 編集または削除を行う
		ItemDAO iDao = new ItemDAO();
		if (request.getParameter("SUBMIT").equals("編集ボタン")) {
			//一件だけ検索してくるメソッドを呼び出す（一覧タブ空の編集ボタン）
			//これからメソッドを作るらしいので保留

			if (iDao.update(itemName, itemFavorite, categoryId, pageId, itemAlert, stockName, stockBuy, stockLimit,
					itemRemain, itemLostday, itemId, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4,itemId,stockId)) {
				//			out.print("編集成功");
				System.out.println("編集成功");
			} else {
				//			out.print("編集失敗");
				System.out.println("遷移失敗");
			}
			//tab_edit.japにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/tab_edit.jsp");
			dispatcher.forward(request, response);

		} else if (request.getParameter("SUBMIT").equals("編集/削除")) {
			//update
			if (iDao.update(itemName, itemFavorite, categoryId, pageId, itemAlert, stockName, stockBuy, stockLimit,
					itemRemain, itemLostday, itemId, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4,itemId ,stockId)) {
				//			out.print("編集成功");
				System.out.println("編集成功");
			} else {
				//			out.print("編集失敗");
				System.out.println("編集失敗");
			}
		} else {
			//delete
			if (iDao.delete(itemName, itemFavorite, categoryId, pageId, itemAlert, stockName, stockBuy, stockLimit,
					itemRemain, itemLostday, itemId, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4)) {
				//			out.print("削除成功");
				System.out.println("削除成功");
			} else {
				//			out.print("削除失敗");
				System.out.println("削除失敗");
			}
		}

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
