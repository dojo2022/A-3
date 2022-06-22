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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		// ログイン処理を行う
				UserDAO iDao = new UserDAO();
				User user = iDao.Login(userId,userPw);
				if (user!=null) {	// ログイン成功
					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					session.setAttribute("user",user);

					// メニューサーブレットにリダイレクトする
					response.sendRedirect("/syokuzaikanri/MainServlet");
				}
				else {									// ログイン失敗
					// 結果ページにフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
				}
//				User user = (User)session.getAttribute("user");
//				user.getUserName();
//
//				${user.userName}←JSP
			}
		}
