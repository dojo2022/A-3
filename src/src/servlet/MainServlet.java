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


		HttpSession session = request.getSession();
		session.getAttribute("user");

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		if (session.getAttribute("user") == null) {
			response.sendRedirect("/syokuzaikanri/LoginServlet");
		return;
		}

		//登録完了のメッセージのセット
		if(session.getAttribute("msg") != null){
			request.setAttribute("registMsg", session.getAttribute("msg"));
			session.removeAttribute("msg");
		}
		//登録完了のメッセージのセット
		if(session.getAttribute("errMsg") != null){
			request.setAttribute("errMsg", session.getAttribute("errMsg"));
			session.removeAttribute("errMsg");
		}



		//セッションからuserIdを取得
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();


		//page_idとpage_titleをセッションに保存
		UserDAO uDao = new UserDAO();
		ArrayList<AllBeans> phList = uDao.upselect(userId);
		session.setAttribute("phList",phList);

		//user_idが持つ一番小さいpage_idでitemとstockを全件検索
		ArrayList<AllBeans> pList = (ArrayList<AllBeans>)session.getAttribute("phList");
		AllBeans aB1 = pList.get(0);
		String pageId= aB1.getPageId();

		session.setAttribute("pageId", pageId);

		//一覧に表示するリストをselect
		StockDAO sDao = new StockDAO();
		ArrayList<AllBeans> allList = sDao.select(pageId);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("allList", allList);


		//allListからstockを抽出する
//		ArrayList<Stock> stockList = new ArrayList<Stock>();
//		for(int i = 0; i < allList.size(); i++) {
//			AllBeans aB2 = allList.get(i);
//			Stock st = new Stock();
//			st.setStockId(aB2.getStockId());
//			st.setStockName(aB2.getStockName());
//			st.setStockBuy(aB2.getStockBuy());
//			st.setStockLimit(aB2.getStockLimit());
//			st.setStockAlert(aB2.getStockAlert());
//			st.setItemId(aB2.getItemId());
//			stockList.add(st);
//		}
//
//		//AllListから重複するitem行を削除する
//		int i = 0;
//		int k = 1;
//		while (i < allList.size()) {
//			while (k < allList.size()) {
//				if (allList.get(i).getItemId() == allList.get(k).getItemId()) {
//					allList.remove(k);
//				} else {
//					i++;
//					k++;
//				}
//			}
//			System.out.println(allList);
//			break;
//		}
//
//
//		//リクエストスコープにlistを"timelineList"という名前を付けて入れる
//		request.setAttribute("itemList", allList);
//		request.setAttribute("stockList", stockList);









//		StockDAO sDao = new StockDAO();
//		ArrayList<AllBeans> stocklist = sDao.select(pageId);
//
//		request.setAttribute("stocklist", stocklist);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);







	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
