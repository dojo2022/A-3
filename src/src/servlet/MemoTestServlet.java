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

import dao.MemoDAO;

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

				//Memo memo = new Memo();
				//memo.setTextList(textList);
			}
		}

		HttpSession session = request.getSession();
		String pageId = (String)session.getAttribute("pageId");

		MemoDAO dao = new MemoDAO();
		int ans = 0;
		for(String str : textList) {
			ans += dao.insert(str,pageId);//pageIdの引数どうやって渡す…？
		}


		//成功
		if(textList.size()==ans) {
			System.out.println("成功");
		//失敗
		}else {
			System.out.println("失敗");
		}

		System.out.println(textList);
		//登録の判定をするかも？


		//メモのデータベースに保存したデータをjspに表示したい
		//削除ボタンを作って同じpageIdをすべて削除する
		//保存した後にページを遷移（値をjspに持っていくならメインサーブレットにリダイレクト）
		//セッションにメモ内容を保存すればフォワードかも？






	}

}
