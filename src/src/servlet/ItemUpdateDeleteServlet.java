package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import model.Alert;
import model.AllBeans;

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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String itemId = request.getParameter("itemName");

		//ItemDAOから一件だけもらってくる
		ItemDAO iDao = new ItemDAO();
		//if
		ArrayList<AllBeans> itemList = iDao.select(itemId);

		request.setAttribute("itemList", itemList);
		request.setAttribute("flg","切り替えフラグ");
		System.out.println(request.getAttribute("flg"));

		//tab_edit.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp#ddd_content");
		dispatcher.forward(request, response);
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
//		String pageId = request.getParameter("pageId");
//		String itemRemain = request.getParameter("itemRemain");
		String itemLostday = request.getParameter("itemLostday");
		String itemId = request.getParameter("itemId");

		//期限日の計算を行う
		Alert alert = new Alert();
		//期限日が計算されている前提（エラー未想定）
		String itemAlertday = alert.itemAlertEdit(itemLostday, itemAlert);

		if(itemFavorite == null) {
			itemFavorite = String.valueOf(0);
		}
//		if(itemFavorite.equals("0")) {
//			itemFavorite = String.valueOf(1);
//		}

		// 編集または削除を行う
		ItemDAO iDao = new ItemDAO();
		if (request.getParameter("regist").equals("編集")) {
			//update
			if (iDao.editUpdate(itemName, itemFavorite, categoryId, itemAlert, itemAlertday, itemId)) {
				session.setAttribute("usMsg", ("更新成功"));
				System.out.println("更新成功");
			} else {
				session.setAttribute("ufMsg", ("更新失敗"));
				System.out.println("更新失敗");
			}
		} else {
			//delete
			if (iDao.delete(itemId)) {
				session.setAttribute("dsMsg", ("削除成功"));
				System.out.println("削除成功");
			} else {
				session.setAttribute("dfMsg", ("削除失敗"));
				System.out.println("削除失敗");
			}
		}

			// メインサーブレットにリダイレクトする
			response.sendRedirect("/syokuzaikanri/MainServlet");

	}

}
