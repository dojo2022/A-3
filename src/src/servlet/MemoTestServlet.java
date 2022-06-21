package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemoTestServlet
 */
@WebServlet("/MemoTestServlet")
public class MemoTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//memo_test.jspにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/memo_test.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//入力されているテキストボックスのみ値をArrayListで取得
		ArrayList<String> textList = new ArrayList<>();

		for(int i = 0; i < 20; i++){
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("in"+i).length() != 0){
				textList.add(request.getParameter("in"+i));
				System.out.println(request.getParameter("in"+i));
			}
		}
	}

}
