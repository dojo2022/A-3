package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//itemFavoriteの値が1に更新されたときはitemLostday,itemAlertdayを計算

		//itemFavoriteの値が2、3の時のuptate

		//itemFavoriteの値が1の時のupdate

	}

}
