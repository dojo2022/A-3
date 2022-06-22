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

import dao.StockDAO;
import dao.UserDAO;
import model.AllBeans;
import model.User;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

		HttpSession session = request.getSession();



		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		session.getAttribute("userId");
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("/syokuzaikanri/LoginServlet");
		return;
		}


		//セッションからuserIdを取得
		User user = (User)session.getAttribute("user");
		user.getUserId();

		String userId = user.getUserId();



		//minpselectメソッドを使ってuser_idが持っているページの中で一番小さいpage_idを取得
		UserDAO uDao = new UserDAO();
		String pageId = null;

		ArrayList<AllBeans> phList = uDao.minpselect(userId);
		for (AllBeans all : phList) {
			 pageId = all.getPageId();
		}


		StockDAO sDao = new StockDAO();
		ArrayList<AllBeans> stocklist = sDao.select(pageId);

		request.setAttribute("stocklist", stocklist);















	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
