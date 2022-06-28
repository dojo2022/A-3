<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/tab_regist.css">
</head>
<body>

<div class="form">
<form method="POST" action="/syokuzaikanri/ItemRegistServlet">
				<input type="hidden" name="pageId" value="${pageId}">
	 <p>項目名<input type="text" required name="itemName"></p>
	 <p>分類名<select name="categoryId">
			    <option value="1">野菜</option>
			    <option value="2">肉</option>
			    <option value="3">魚</option>
			    <option value="4">卵</option>
			    <option value="5">炭水化物</option>
			    <option value="6">乳製品</option>
			    <option value="7">大豆製品</option>
			    <option value="8">乾物</option>
			    <option value="9">調味料</option>
			    <option value="10">粉もの</option>
			    <option value="11">飲み物</option>
			    <option value="12">果物</option>
			    <option value="13">菓子</option>
			    <option value="14">レトルト食品</option>
			    <option value="15">インスタント食品</option>
			    <option value="16">冷凍食品</option>
			    <option value="17">その他</option>
		  </select>
	 お気に入り<input type="checkbox" name="itemFavorite" value="1"></p>
	 <p>買い替えアラート<select name="itemAlert">
			    <option value="1">なし</option>
			    <option value="2">即日</option>
			    <option value="3">３日後</option>
			    <option value="4">１週間後</option>
			    <option value="5">２週間後</option>
			    <option value="6">１か月後</option>
			  </select><br></p>
	 <p>在庫名<input type="text" name="stockName"><p>
	 <p>購入日 <input type="date" name="stockBuy">
	 期限日<input type="date" name="stockLimit"></p>

 			<p><input type="submit" name="regist" value="新規登録"></p>




</form>
</div>
</body>

</html>