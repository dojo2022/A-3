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

<c:forEach var="e" items="${stockList}">

<form method="POST" action="/syokuzaikanri/ItemRegistServlet">

		<input type="hidden" name="pageId" value="${e.pageId}">
	 <input type="hidden" name="itemId" value="${e.itemId}"><br>
	 <input type="hidden" name="itemRemain" value="${e.itemRemain}"><br>
	 <input type="hidden" name="itemLostday" value="${e.itemLostday}"><br>
	 <p>項目名<input type="text" name="${e.itemName}"></p>
	 <p>分類名<select name="categoryId">
	            <option value="${ecategoryId}">${e.categoryName}</option>
			    <option value="1">野菜</option>
			    <option value="2">肉類</option>
			    <option value="3">魚類</option>
			    <option value="4">炭水化物</option>
			    <option value="5">調味料</option>
			    <option value="6">飲み物</option>
			    <option value="7">その他</option>
		  </select>
	 お気に入り<input type="checkbox" name="itemFavorite" value="${e.itemFavorite}"></p>
	 <p>買い替えアラート<select name="itemAlert">
	 			<option value="${e.itemAlert}">${e.itemAlert}</option>
			    <option value="1">なし</option>
			    <option value="2">３日後</option>
			    <option value="3">１週間後</option>
			    <option value="4">２週間後</option>
			    <option value="5">１か月後</option>
			  </select><br></p>
	 <p>在庫名<input type="text" name="${e.stockName}"><p>
	 <p>購入日 <input type="date" name="${e.stockBuy}">
	 期限日<input type="date" name="${e.stockLimit}"></p>

    <input type="hidden" name="stockId" value="${e.stockId}"><br>
	<input type="hidden" name="itemAlertday" value="${e.itemAlertday}">
	<input type="hidden" name="stockAlert" value="${e.stockAlert}"><br>
	<input type="hidden" name="stockAlertday1" value="${e.stockAlertday1}"><br>
    <input type="hidden" name="stockAlertday2" value="${e.stockAlertday2}"><br>
	<input type="hidden" name="stockAlertday3" value="${e.stockAlertday3}"><br>
	<input type="hidden" name="stockAlertday4" value="${e.stockAlertday4}"><br>



 			<p><input type="submit" name="regist" value="削除">
 			<input type="submit" name="regist" value="編集"></p>
	</form>
</c:forEach>



</body>
</html>