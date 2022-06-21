<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
編集/削除タブ


<!-- 使ってね！齊藤 -->

<form method="POST" action="/syokuzaikanri/ItemRegistServlet">
				<input type="hidden" name="pageId" value="1">
	 <p>項目名<input type="text" name="itemName"></p>
	 <p>分類名<select name="categoryId">
			    <option value="1">野菜</option>
			    <option value="2">肉類</option>
			    <option value="3">魚類</option>
			    <option value="4">炭水化物</option>
			    <option value="5">調味料</option>
			    <option value="6">飲み物</option>
			    <option value="7">その他</option>
		  </select>
	 お気に入り<input type="checkbox" name="itemFavorite" value="1"></p>
	 <p>買い替えアラート<select name="itemAlert">
			    <option value="1">なし</option>
			    <option value="2">３日後</option>
			    <option value="3">１週間後</option>
			    <option value="4">２週間後</option>
			    <option value="5">１か月後</option>
			  </select><br></p>
	 <p>在庫名<input type="text" id="datepicker"><p>
	 <p>購入日 <input type="date" name="stockBuy">
	 期限日<input type="date" name="stockBuy"></p>

 			<p><input type="submit" name="regist" value="新規登録"></p>




</form>
</body>
</html>