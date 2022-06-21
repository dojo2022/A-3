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
import model.AllBeans;


@WebServlet("/AlertPracticeServlet")
public class AlertPracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/alertPractice.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		//リクエストスコープからデータを取得
		request.setCharacterEncoding("UTF-8");
		String pageId  = request.getParameter("pageId");

		//StockDAOを実体化
		StockDAO sDAO = new StockDAO();
		ArrayList<AllBeans> stockList = sDAO.select(pageId);

		session = request.getSession();//sessionスコープは毎回インスタンスが必要
		session.setAttribute("stockLidt", stockList);

		// メニューページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/alertPractice2.jsp");
		dispatcher.forward(request, response);

		}

}
