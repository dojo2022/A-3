package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class AccountRegistServlet
 */
@WebServlet("/AccountRegistServlet")
public class AccountRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account_regist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		UserDAO uDao = new UserDAO();
		if (uDao.insert(userId,userPw,userName)) {	// 登録成功
			//ログイン処理をする
			User user = uDao.Login(userId, userPw);
			// セッションスコープにUserBeansを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			// ウェルカムサーブレットにリダイレクトする
			response.sendRedirect("/syokuzaikanri/WelcomeServlet");
		}
		else {												// 登録失敗
			response.sendRedirect("/syokuzaikanri/AccountRegistServlet");
		}


	}

}
