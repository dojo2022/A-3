package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;

/**
 * Servlet implementation class ItemAjaxServlet
 */
@WebServlet("/ItemAjaxServlet")
public class ItemAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");

		// リクエストパラメータ(購入日、期限日、アラート)の取得
		String itemFavorite = request.getParameter("");//StockDAOのupdateメソッドでstock_nameもアップデート出来るようにする
		String itemRemain = request.getParameter("");
		String itemId = request.getParameter("");

		//itemRemainの値が1に更新されたときはitemLostday,itemAlertdayを計算
		if(itemRemain.equals("1")) {

		}

		//updateメソッドの呼び出し

		ItemDAO iDao = new ItemDAO();

		if(itemRemain.equals("1")) {
			//itemRemainの値が1の時のupdate
			boolean itemUp = iDao.update(itemFavorite, itemRemain, itemLostday, itemAlertday, itemId);
			if(itemUp == false) {
				HttpSession session = request.getSession();
				session.setAttribute("errMsg", ("登録失敗"));
				System.out.println("登録失敗");
			}
		}else {
			//itemRemainの値が2、3の時のupdate
			boolean itemFRup = iDao.itemFRupdate(itemFavorite,itemRemain,itemId);
			if(itemFRup == false) {
				HttpSession session = request.getSession();
				session.setAttribute("errMsg", ("登録失敗"));
				System.out.println("登録失敗");
			}
		}



	}

}
