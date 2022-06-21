<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="tab_regist.js" charset="utf-8"></script>
</head>
<body>
登録タブ

<form method="POST" action="/syokuzaikanri/ItemRegistServlet">

	 項目名<input type="text" name="itemName"><br>
	 分類名<select name="categoryId">
			    <option value="1">野菜</option>
			    <option value="2">肉類</option>
			    <option value="3">魚類</option>
			    <option value="4">炭水化物</option>
			    <option value="5">調味料</option>
			    <option value="6">飲み物</option>
			    <option value="7">その他</option>
		  </select>
	 お気に入り<input type="checkbox" name="itemFavorite" value="1"><br>
	 買い替えアラート<select name="itemAlert">
			    <option value="1">なし</option>
			    <option value="2">３日後</option>
			    <option value="3">１週間後</option>
			    <option value="4">２週間後</option>
			    <option value="5">１か月後</option>
			  </select><br>
	 在庫名<input type="text" name="itemName"><br>
	 購入日<!--<input type="text" cmanCLDat="USE:ON" style="width:150px;"><br>  -->
	       <input type="text" name="stockBuy">
	 期限日<!--<input type="text" cmanCLDat="USE:ON" style="width:150px;"><br> -->
			<input type="text" name="stockBuy"><br>

 			<input type="submit" name="regist" value="新規登録">




</form>
</body>
</html>