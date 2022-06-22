<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<c:forEach var="e" items="${stockList}" varStatus="status">

		<c:if test="${status.index % 2==0}" >
			<tr>
				</c:if>

					<td>
						項目ID 　: ${e.itemId}<input type="hidden" name="itemId" value="${e.itemId}"><br>
						項目名 　: ${e.itemName}<input type="hidden" name="itemName" value="${e.itemName}"><br>
						お気に入り : ${e.itemFavorite}<input type="hidden" name="itemFavorite" value="${e.itemFavorite}"><br>
						残量 　: ${e.itemRemain}<input type="hidden" name="itemRemain" value="${e.itemRemain}"><br>
						残量切れ日 　: ${e.itemLostday}<input type="hidden" name="itemLostday" value="${e.itemLostday}"><br>
						分類名 : ${e.categoryId}<input type="hidden" name="categoryId" value="${ecategoryId}"><br>
						pageId 　: ${e.pageId}<input type="hidden" name="pageId" value="${e.pageId}"><br>
						アラート期間　: ${e.itemAlert}<input type="hidden" name="itemAlert" value="${e.itemAlert}"><br>
						アラート日 　: ${e.itemAlertday}<input type="hidden" name="itemAlertday" value="${e.itemAlertday}"><br>
						在庫ID 　: ${e.stockId}<input type="hidden" name="stockId" value="${e.stockId}"><br>
						在庫名 : ${e.stockBuy}<input type="hidden" name="stockName" value="${e.stockName}"><br>
						購入日 　: ${e.zipcode}<input type="hidden" name="stockBuy" value="${e.stockBuy}"><br>
						期限日 　: ${e.stockLimit}<input type="hidden" name="stockLimit" value="${e.stockLimit}"><br>
						期限日アラート : ${e.stockAlert}<input type="hidden" name="stockAlert" value="${e.stockAlert}"><br>
						期限日二日前 　: ${e.stockAlertday1}<input type="hidden" name="stockAlertday1" value="${e.stockAlertday1}"><br>
						期限日当日 　: ${e.stockAlertday2}<input type="hidden" name="stockAlertday2" value="${e.stockAlertday2}"><br>
						期限日二日後 　: ${e.stockAlertday3}<input type="hidden" name="stockAlertday3" value="${e.stockAlertday3}"><br>
						期限日一週間後 　: ${e.stockAlertday4}<input type="hidden" name="stockAlertday4" value="${e.stockAlertday4}"><br>
						分類名 　: ${e.categoryName}<input type="hidden" name="categoryName" value="${e.categoryName}"><br>
						<input type="submit" name="SUBMIT" value="編集" class="hennshuu">


				<c:if test="${status.index % 2 !=0}" >
					</tr>
		</c:if>
	</c:forEach>
</table>
</body>
</html>