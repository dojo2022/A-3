package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import model.Alert;
import model.Item;

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
		String itemFavorite = request.getParameter("itemFavorite");//StockDAOのupdateメソッドでstock_nameもアップデート出来るようにする
		String itemRemain = request.getParameter("remain");
		String itemId = request.getParameter("itemName");

		//残量切れ日（item_lostday）と買い替えアラート日（item_alert）の算出
		Alert alert = new Alert();
		Item item = alert.itemAlertButton(itemRemain, itemId);

		//残量切れ日と買い替えアラートの取得
		String itemLostday = item.getItemLostday();
		String itemAlertDay = item.getItemAlertday();

		//updateメソッドの呼び出し
		//在庫切れ日や買い替えアラート日は計算時（Alert.java）に条件分岐済み
		ItemDAO iDao = new ItemDAO();
		Boolean result = iDao.ajaxUpdate(itemFavorite, itemRemain, itemLostday, itemAlertDay, itemId);

		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("usMsg", ("更新成功"));
			System.out.println("更新成功");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("ufMsg", ("更新失敗"));
			System.out.println("更新失敗");
		}

//		if(itemRemain.equals("1")) {
//			//itemRemainの値が1の時のupdate
//			boolean itemUp = iDao.update(itemFavorite, itemRemain, itemLostday, itemAlertday, itemId);
//			if(itemUp == false) {
//				HttpSession session = request.getSession();
//				session.setAttribute("errMsg", ("登録失敗"));
//				System.out.println("登録失敗");
//			}
//		}else {
//			//itemRemainの値が2、3の時のupdate
//			boolean itemFRup = iDao.itemFRupdate(itemFavorite,itemRemain,itemId);
//			if(itemFRup == false) {
//				HttpSession session = request.getSession();
//				session.setAttribute("errMsg", ("登録失敗"));
//				System.out.println("登録失敗");
//			}
//		}



	}

}
