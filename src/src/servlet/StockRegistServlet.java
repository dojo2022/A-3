package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StockDAO;
import model.Alert;

/**
 * Servlet implementation class StockRegistServlet
 */
@WebServlet("/StockRegistServlet")
public class StockRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする？
//		HttpSession session = request.getSession();
//		if (session.getAttribute("user") == null) {
//			response.sendRedirect("/syokuzaikanri/LoginServlet");
//			return;
//		}

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String stockName = request.getParameter("stockName");
		String stockBuy = request.getParameter("stockBuy");
		String stockLimit = request.getParameter("stockLimit");
		String itemId = request.getParameter("itemId");

		//期限日の計算を行う
		Alert alert = new Alert();
		String[] str = alert.stockAlert(stockLimit);

		//期限日が計算されている前提（エラー未想定）
		//stockAlertday1～4を定義
		String stockAlertday1 = str[0];
		String stockAlertday2 = str[1];
		String stockAlertday3 = str[2];
		String stockAlertday4 = str[3];

		//登録処理を行う
		StockDAO sDao = new StockDAO();

		if (sDao.insert(stockName, stockBuy, stockLimit, itemId, stockAlertday1, stockAlertday2, stockAlertday3, stockAlertday4)) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", ("登録成功"));
			System.out.println("登録成功");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", ("登録失敗"));
			System.out.println("登録失敗");
		}

		// メインサーブレットにリダイレクトする
		response.sendRedirect("/syokuzaikanri/MainServlet");

	}

}
