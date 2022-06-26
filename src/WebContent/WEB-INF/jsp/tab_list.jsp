<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/tab_list.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
	<body>
		<div class="tab">
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
			<div class="tab_list">
				<table class="item_list">
 				<c:forEach var="e" items="${allList}" varStatus = "status">
 					<c:if test="${e.itemId == taihi}">
 						<tr>
						  <td>
						  	・
						  </td>
						  <td>
						  	<input type="text" value="${e.stockName}" name="stockName" id="stockName${status.index}" size="0" maxlength="20" onclick="changeStockName(${status.index})">
						  </td>
						  <td>
						  	<label for="stockBuy${status.index}">購入日</label>
						  	<input type="date" value="${e.stockBuy}" name="stockBuy" id="stockBuy${status.index}" onclick="changeStockBuy(${status.index})">
						  </td>
						  <td>
						  	<label for="stockLimit${status.index}">期限日</label>
						  	<input type="date" value="${e.stockLimit}" name="stockLimit" id="stockLimit${status.index}" onclick="changeStockLimit(${status.index})">
						  </td>
						  <td>
							  <c:if test="${e.stockAlert == true}" >
							    <div class="alertlBottun"><!-- オン→オフ場合 -->
							        <label for="alertlOff${status.index}" class="alertlLabel">
							            <img src="/syokuzaikanri/img/alert_on.png" width="25" height="25" id="alertlImage${status.index}" onclick="alertlImage(${status.index})">
							        </label>
							        <input type="checkbox" name="bell" class="alertl"  id="alertlOff${status.index}" onclick="alertlOff(${status.index})">
							    </div>
								  </c:if>
							  <c:if test="${e.stockAlert == false}" >
							    <div class="alertlBottun"><!-- オフ→オン場合 -->
							        <label for="alertOn${status.index}" class="alertlLabel">
							            <img src="/syokuzaikanri/img/alert_off.png" width="25" height="25" id="alertlImage${status.index}" onclick="alertlImage(${status.index})">
							        </label>
							        <input type="checkbox" name="bell" class="alertl"  id="alertOn${status.index}" onclick="alertlOn(${status.index})">
							    </div>
							  </c:if>
						  </td>
							<form method="POST" action="/syokuzaikanri/StockDeleteServlet" id="stockDelete${status.index}">
					    	<input type="hidden" name="stockId" value="${e.stockId}">
							<td><input type="submit" name="stockDelete" value="-"></td></form>
					 	  <td>
					 	  </td>
					  </tr>
 					</c:if>
 					<c:if test="${e.itemId !=taihi}" >
							<!-- 一回目のプラスボタンは見せないようにする -->
 							<c:if test="${status.index!=0 }">
		<!-- ここからが開けるアコーディオン！ ここテストにつかっていいよ-->
 							  <tr>
							  	  <td colspan="7">
							  	  	<input id="stockAdd${status.index}" class="stockAdd" type="checkbox">
									<label class="stockAdd-label" for="stockAdd${status.index}">
										<img src="/syokuzaikanri/img/stockadd_plus.png" width="30" height="35" id="stockAddButton${status.index}" onclick="stockAddButton(${status.index})">
									</label>
									<div class="stockAdd-content">
										<table>
										  <tr>
											  <td>
											  	<input type="text" name="stockName" id="stockName${status.index}" placeholder="名前" size="0" maxlength="20">
											  </td>
											  <td>
											  	<label for="stockBuy">購入日</label>
											  	<input type="date" name="stockBuy" id="stockBuy${status.index}">
											  </td>
											  <td>
											  	<label for="stockLimit">期限日</label>
											  	<input type="date" name="stockLimit" id="stockLimit${status.index}">
											  </td>
											  <div class="stockRegistButton">
										    	<form method="POST" action="/syokuzaikanri/StockRegistServlet" id="stockRegist${status.index}">
										    	<input type="hidden" name="itemId" value="${e.itemId-1}">
												<td><input type="submit" name="stockRegist" value="登録"></td></form>
											  </div>
										  </tr>
										</table>
									</div>
							  	  </td>
					  		  </tr>
		<!-- ここまでが開けるアコーディオン！ ここテストにつかっていいよ-->
					  		</c:if>
								<!-- 大項目------------------------------------------------------ -->
							 <tr>
						 		<td>

							 		<c:if test="${e.itemFavorite == true}" ><!-- おきに入り→お気に入りじゃないの場合 -->
								    <div class="favoriteBottun">
									        <label for="favoriteOff${status.index}" class="favoriteLabel">
									            <img src="/syokuzaikanri/img/favorite_on.png" width="25" height="25" id="favoriteImage${status.index}" onclick="favoriteImage(${status.index})">
									        </label>
									        <input type="checkbox" name="itemFavorite" class="itemFavorite" value="false" id="favoriteOff${status.index}" onclick="favoriteOff(${status.index})">
									    </div>
								</c:if>
								<c:if test="${e.itemFavorite == false}" ><!-- おきに入りじゃない→お気に入り場合 -->
								    <div class="favoriteBottun">
								        <label for="favoriteOn${status.index}" class="favoriteLabel">
								            <img src="/syokuzaikanri/img/favorite_off.png" width="25" height="25" id="favoriteImage${status.index}" onclick="favoriteImage(${status.index})">
								        </label>
								        <input type="checkbox" name="itemFavorite" class="itemFavorite" value="ture" id="favoriteOn${status.index}" onclick="favoriteOn(${status.index})">
								    </div>
								</c:if>
								</td>
						 		<td colspan="2">
						 			${e.itemName}
						 		</td>
							 		<td>
									    <div class="remainBottun">
									        <label for="remainFull${status.index}" class="remainLabel">
									            <img src="/syokuzaikanri/img/remain_full.png" width="25" height="25" class="remainImage" >
									        </label>
									        <input type="radio" name="remain" class="remain" value="3" id="remainFull${status.index}" onclick="remain(${status.index})">
									    </div>
									    <div class="remainBottun">
									        <label for="remainLittle${status.index}" class="remainLabel">
									            <img src="/syokuzaikanri/img/remain_little.png" width="25" height="25" class="remainImage">
									        </label>
									        <input type="radio" name="remain" class="remain" value="2" id="remainLittle${status.index}" onclick="remain(${status.index})">
									    </div>
									    <div class="remainBottun">
									        <label for="remainNone${status.index}" class="remainLabel">
									            <img src="/syokuzaikanri/img/remain_none.png" width="25" height="25" class="remainImage">
									        </label>
									        <input type="radio" name="remain" class="remain" value="1" id="remainNone${status.index}" onclick="remain(${status.index})">
									    </div>
									</td>
							 		<td>
							 		</td>
							 		<td>
							 		</td>
									<td>
									    <div class="editItemButton">
									    	<form method="GET" action="/syokuzaikanri/ItemUpdateDeleteServlet" id="edit${status.index}">
											<input type="hidden" name="itemName" id="itemName${status.index}" value="${e.itemId}"><!-- hiddenで渡したい値をvalueに入れて渡すことが可能 -->
											<input type="submit" name="editItem" id="editItem${status.index}" value="編集/削除"></form>
									    </div>
									</td>
							  </tr>
							  <!-- 小項目----------------------------------- -->
							  <tr>
								  <td>
								  	・${status.index}
								  </td>
								  <td>
								  	<input type="text" value="${e.stockName}" name="stockName" id="stockName${status.index}" size="0" maxlength="20" onclick="changeStockName(${status.index})">
								  </td>
								  <td>
								  	<label for="stockBuy">購入日</label>
								  	<input type="date" value="${e.stockBuy}" name="stockBuy" id="stockBuy${status.index}" onclick="changeStockBuy(${status.index})">
								  </td>
								  <td>
								  	<label for="stockLimit">期限日</label>
								  	<input type="date" value="${e.stockLimit}" name="stockLimit" id="stockLimit${status.index}" onclick="changeStockLimit(${status.index})">
								  </td>
								  <td>
									  <c:if test="${e.stockAlert == true}" >
									    <div class="alertlBottun"><!-- オン→オフ場合 -->
									        <label for="alertOff${status.index}" class="alertlLabel">
									            <img src="/syokuzaikanri/img/alert_on.png" width="25" height="25" id="alertOff${status.index}" onclick="alertlOff('${status.index}')">
									        </label>
									        <input type="hidden" name="stockId" class="stockId" value="${e.stockId}" id="stockId${status.index}">
									        <input type="checkbox" name="bell" class="alertl"  id="alertOff${status.index}" onclick="alertlOff('${status.index}')">
									    </div>
										  </c:if>
									  <c:if test="${e.stockAlert == false}" >
									    <div class="alertlBottun"><!-- オフ→オン場合 -->
									        <label for="alertOn${status.index}" class="alertlLabel">
									            <img src="/syokuzaikanri/img/alert_off.png" width="25" height="25" id="alertOn${status.index}" onclick="alertlOn('${status.index}')">
									        </label>
									        <input type="hidden" name="stockId" class="stockId" value="${e.stockId}" id="stockId${status.index}">
									        <input type="checkbox" name="bell" class="alertl"  id="alertOn${status.index}" onclick="alertlOn('${status.index}')">
									    </div>
									  </c:if>
								  </td>
									<form method="POST" action="/syokuzaikanri/StockDeleteServlet" id="stockDelete${status.index}">
							    	<input type="hidden" name="stockId" id="stockId${status.index}" value="${e.stockId}">
									<td><input type="submit" name="stockDelete" value="-"></td></form>
							 	  <td>
							 	  </td>
							  </tr>
						</c:if>
					<c:set var="taihi" value="${e.itemId}" />
				</c:forEach>
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
								  	<input type="text" name="stockName" id="stockName" placeholder="名前" size="0" maxlength="20">
								  </td>
								  <td>
								  	<label for="stockBuy">購入日</label>
								  	<input type="date" name="stockBuy" id="stockBuy">
								  </td>
								  <td>
								  	<label for="stockLimit">期限日</label>
								  	<input type="date" name="stockLimit" id="stockLimit">
								  </td>
								  <div class="stockRegistButton">
							    	<form method="POST" action="/syokuzaikanri/StockRegistServlet" id="stockRegist">
							    	<input type="hidden" name="itemId" value="${itemId}">
									<td><input type="submit" name="stockRegist" value="登録"></td></form>
								  </div>
							  </tr>
							</table>
						</div>
				  	  </td>
		  		  </tr>
				</table>
			</div>
		</div>
		<script src="javaScript/tab_list.js" charset="utf-8"></script>
	</body>
</html>