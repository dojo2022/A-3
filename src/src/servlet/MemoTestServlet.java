package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemoDAO;
import model.Memo;

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
		//ページidだけ取得

		//入力されているテキストボックスのみ値をArrayListで取得
		ArrayList<String> textList = new ArrayList<String>();

		for(int i = 0; i < 20; i++){
			request.setCharacterEncoding("UTF-8");
			if(request.getParameter("in"+i).length() != 0){
				textList.add(request.getParameter("in"+i));
				//System.out.println(request.getParameter("in"+i));

				Memo memo = new Memo();
				memo.setTextList(textList);
			}
		}

		MemoDAO dao = new MemoDAO();
		dao.insert(textList);//,pageId
		System.out.println(textList);
		//登録の判定をするかも？







	}

}
