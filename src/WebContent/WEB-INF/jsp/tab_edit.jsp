<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/tab_edit.css">
<title></title>
</head>
<body>
<div id="tab_edit">
	<form method="POST" action="/syokuzaikanri/MainServlet">
						 <table class="edit_search">
						 	<tr>
						 		<td>
									<input type="search" id="search" name="search" placeholder="検索">
						 		</td>
						 		<td>
						 			<!-- 検索ボタンを押したらjsで調べたものの表示だけにする -->
									<input type="button" value="検索" onclick="search()">
						 		</td>
						 	</tr>
						 </table>
	</form>

	<c:forEach var="e" items="${itemList}" varStatus = "status">
 	<c:if test="${e.itemId !=taihi}" >
	<form method="POST" action="/syokuzaikanri/ItemUpdateDeleteServlet">

		 <input type="hidden" name="pageId" value="${e.pageId}">
		 <input type="hidden" name="itemId" value="${e.itemId}"><br>
		 <input type="hidden" name="itemRemain" value="${e.itemRemain}"><br>
		 <input type="hidden" name="itemLostday" value="${e.itemLostday}"><br>
		 <input type="hidden" name="itemAlertday" value="${e.itemAlertday}">

		 <p>項目名<input type="text" name="itemName" value="${e.itemName}"></p>
		 <p>分類名<select name="categoryId">
		            <option value="${e.categoryId}">${e.categoryName}</option>
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
	<c:if test="${e.itemFavorite == true}" >
		 お気に入り<input type="checkbox" name="itemFavorite" id="itemFavorite"value="1" checked onclick="clickBtn5()">
	</c:if>
	<c:if test="${e.itemFavorite == false}" >
		 お気に入り<input type="checkbox" name="itemFavorite" id="itemFavorite" value="0" onclick="clickBtn5()">
	</c:if>
		</p>
		 <p>買い替えアラート<select name="itemAlert">
		 			<option value="${e.itemAlert}">${e.itemAlert}</option>
				    <option value="1">なし</option>
				    <option value="2">即日</option>
				    <option value="3">３日後</option>
				    <option value="4">１週間後</option>
				    <option value="5">２週間後</option>
				    <option value="6">１か月後</option>
				  </select><br></p>
	 			<p><input type="submit" name="regist" value="削除">
	 			<input type="submit" name="regist" value="編集"></p>
		</form>
	</c:if>
	<c:set var="taihi" value="${e.itemId}" />
	</c:forEach>
</div>

<script>
  function clickBtn5() {
    const chk3 = document.getElementById("itemFavorite");

    if (chk3.checked) { //(chk3[i].checked === true)と同じ
      document.getElementById("itemFavorite").value = 1;
    } else {
      document.getElementById("itemFavorite").value = 0;
    }
  }
</script>

</body>
</html>