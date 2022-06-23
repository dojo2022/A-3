<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="javaScript/tab_list.js" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/tab_list.css">
</head>
	<body>
		<div class="tab">
			<div class="tab_list">
			 	<form id="searchbox" method="POST" action="/syokuzaikanri/MainServlet">
					 <table>
					 	<tr>
					 		<td>
								<input type="search" id="search" name="search" placeholder="検索">
					 		</td>
					 		<td>
					 			<!-- 検索ボタンを押したらjsで調べたものの表示だけにする -->
								<input type="button" value="検索" onclick="search()">
					 		</td>
					 </table>
			 		<input type="submit" name="returnList" value="一覧に戻す">
			 	</form>
				<table class="item_list">
 				<c:forEach var="e" items="${allList}" >
					 <tr>
				 		<td>
				 		<c:if test="${itemFavorite} = 1" ><!-- おきに入り→お気に入りじゃないの場合 -->
						    <div class="favoriteBottun">
						        <label for="favoriteOff" class="favoriteLabel">
						            <img src="/syokuzaikanri/img/favorite_on.png" width="25" height="25" id="favoriteImage1" onclick="favoriteImage1()">
						        </label>
						        <input type="checkbox" name="itemFavorite" class="itemFavorite" value="${itemFavorite}" id="favoriteOff" onclick="favoriteOff()">
						    </div>
						</c:if>
						<c:if test="${itemFavorite} = 0" ><!-- おきに入りじゃない→お気に入り場合 -->
						    <div class="favoriteBottun">
						        <label for="favoriteOn" class="favoriteLabel">
						            <img src="/syokuzaikanri/img/favorite_off.png" width="25" height="25" id="favoriteImage0" onclick="favoriteImage0()">
						        </label>
						        <input type="checkbox" name="itemFavorite" class="itemFavorite" value="${itemFavorite}" id="favoriteOn" onclick="favoriteOn()">
						    </div>
						</c:if>
						</td>
				 		<td colspan="2">
				 			項目名${itemName}
				 		</td>
					 	<div id="remainBottun">
					 		<td>
							    <div class="remainBottun">
							        <label for="remainFull" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_full.png" width="25" height="25" class="remainImage" >
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainFull" onclick="remain()">
							    </div>
							    <div class="remainBottun">
							        <label for="remainLittle" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_little.png" width="25" height="25" class="remainImage">
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainLittle" onclick="remain()">
							    </div>
							    <div class="remainBottun">
							        <label for="remainNone" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_none.png" width="25" height="25" class="remainImage">
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainNone" onclick="remain()">
							    </div>
							</td>
						</div>
					 		<td>
					 		</td>
					 		<td>
					 		</td>
							<td>
							    <div class="editItemButton">
							    	<form method="POST" action="/syokuzaikanri/ItemUpdateDeleteServlet" id="edit">
									<input type="hidden" name="itemName" value="${itemName}"><%-- hiddenで渡したい値をvalueに入れて渡すことが可能 --%>
									<input type="submit" name="editItem" value="編集"></form>
							    </div>
							</td>
					  </tr>
					  <tr>
						  <td>
						  </td>
						  <td>
						  	・在庫名が入ります${stockName}
						  </td>
						  <td>
						  	<label for="stockBuy">購入日</label>
						  	<input type="date" value="${stockBuy}" name="stockBuy" id="stockBuy" onclick="changeStockBuy()">
						  </td>
						  <td>
						  	<label for="stockLimit">期限日</label>
						  	<input type="date" value="${stockLimit}" name="stockLimit" id="stockLimit" onclick="changeStockLimit()">
						  </td>
						  <td>
							  <c:if test="${stockAlert} = 1" >
							    <div class="alertlBottun"><!-- オン→オフ場合 -->
							        <label for="alertlOff" class="alertlLabel">
							            <img src="/syokuzaikanri/img/alert_on.png" width="25" height="25" id="alertlImage1" onclick="alertlImage1()">
							        </label>
							        <input type="checkbox" name="bell" class="alertl" value="${stockAlert}" id="alertlOff" onclick="alertlOff()">
							    </div>
							  </c:if>
							  <c:if test="${stockAlert} = 0" >
							    <div class="alertlBottun"><!-- オフ→オン場合 -->
							        <label for="alertlOn" class="alertlLabel">
							            <img src="/syokuzaikanri/img/alert_off.png" width="25" height="25" id="alertlImage0" onclick="alertlImage0()">
							        </label>
							        <input type="checkbox" name="bell" class="alertl" value="${stockAlert}" id="alertlOn" onclick="alertlOff()">
							    </div>
							  </c:if>
						  </td>
						  <td>
								<input type="button" value="-" onclick="stockDelete()">
					 	  </td>
					 	  <td>
					 	  </td>
					  </tr>
					  <tr>
					  	  <td colspan="7">
					  	  	<input id="stockAdd" class="stockAdd" type="checkbox">
							<label class="stockAdd-label" for="stockAdd">
								<img src="/syokuzaikanri/img/stockadd_plus.png" width="30" height="35" id="stockAddButton" onclick="stockAddButton()">
							</label>
							<div class="stockAdd-content">
								<table>
								  <tr>
									  <td>
									  	<input type="text" name="stockName" placeholder="名前" size="0" maxlength="20">
									  </td>
									  <td>
									  	<label for="stockBuy">購入日</label>
									  	<input type="date" name="stockBuy" id="stockBuy">
									  </td>
									  <td>
									  	<label for="stockLimit">期限日</label>
									  	<input type="date" name="stockLimit" id="stockLimit">
									  </td>
									  <td>
								      <div class="stockRegistButton">
								    	<form method="POST" action="/syokuzaikanri/StockRegistServlet" id="stockRegist">
										<input type="submit" name="stockRegist" value="登録"></form>
	    							  </div>
									  </td>
								  </tr>
								</table>
							</div>
					  	  </td>
					  </tr>
					   				</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>