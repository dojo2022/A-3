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
import dao.StockDAO;
import model.AlertSelect;
import model.AllBeans;
import model.Memo;
import model.Message;

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

		//登録成功のメッセージのセット
		if(session.getAttribute("msg") != null){
			request.setAttribute("registMsg", session.getAttribute("msg"));
			session.removeAttribute("msg");
		}
		//登録失敗のメッセージのセット
		if(session.getAttribute("errMsg") != null){
			request.setAttribute("errorMsg", session.getAttribute("errMsg"));
			session.removeAttribute("errMsg");
		}

		//更新成功のメッセージのセット
		if(session.getAttribute("usMsg") != null){
			request.setAttribute("updateSuccessMsg", session.getAttribute("usMsg"));
			session.removeAttribute("usMsg");
		}
		//更新失敗のメッセージのセット
		if(session.getAttribute("ufMsg") != null){
			request.setAttribute("updateFailureMsg", session.getAttribute("ufMsg"));
			session.removeAttribute("ufMsg");
		}

		//削除成功のメッセージのセット
		if(session.getAttribute("dsMsg") != null){
			request.setAttribute("deleteSuccessMsg", session.getAttribute("dsMsg"));
			session.removeAttribute("dsMsg");
		}
		//削除失敗のメッセージのセット
		if(session.getAttribute("dfMsg") != null){
			request.setAttribute("deleteFailureMsg", session.getAttribute("dfMsg"));
			session.removeAttribute("dfMsg");
		}

//		//user_idが持つ一番小さいpage_idでitemとstockを全件検索
//		ArrayList<AllBeans> pList = (ArrayList<AllBeans>)session.getAttribute("phList");
//		AllBeans aB1 = pList.get(0);
//		String pageId= aB1.getPageId();

		//pageIdをセッションから取り出す
		String pageId = new String();;

		if (request.getParameter("pageId") != null) {
			pageId = request.getParameter("pageId");
			session.setAttribute("pageId", pageId);
		}
		pageId = (String)session.getAttribute("pageId");
		System.out.println("今のページIDは"+ pageId);

		//一覧に表示するリストをselect
		StockDAO sDao = new StockDAO();
		ArrayList<AllBeans> allList = sDao.select(pageId);


		// 検索結果をセッションスコープに格納する
		session.setAttribute("allList", allList);

		//アラート日時をselect
		ArrayList<AllBeans> alertList = sDao.selectAlert(pageId);
		//アラート内容を取得
		AlertSelect selectMessage = new AlertSelect();
		ArrayList<Message> message = selectMessage.alertDay(alertList);
		//結果をセッションに保存する
		session.setAttribute("message", message);

		//お気に入りタブに表示するリストをselect
		StockDAO sDAO = new StockDAO();
		ArrayList<AllBeans> favoriteList = sDAO.favoriteselect(pageId);

		// 検索結果をセッションスコープに格納する
		session.setAttribute("favoriteList", favoriteList);

		//memoをselect
		MemoDAO mDao = new MemoDAO();
		ArrayList<Memo> memoList = mDao.select(pageId);
		// 検索結果をセッションスコープに格納する
		session.setAttribute("memoList", memoList);





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
