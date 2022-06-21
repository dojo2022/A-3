<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
	<body>
		<div class="tab">
			<div class="tab_list">
			 	<form id="searchbox" method="POST" action="/syokuzaikanri/MainServlet">
					 <table>
					 	<tr>
					 		<td>
								<input type="search" name="search" placeholder="検索">
					 		</td>
					 		<td>
					 			<!-- 検索ボタンを押したらjsで調べたものの表示だけにする -->
								<input type="button" value="検索" onclick="search()">
					 		</td>
					 </table>
			 		<input type="submit" name="returnList" value="一覧に戻す">
			 	</form>

				<table>
					 <tr>
					 	<div id="remainBottun">
					 		<td>
							    <div class="favoriteBottun">
							        <label for="favoriteOn" class="favoriteLabel">
							            <img src="/syokuzaikanri/img/favorite_off.png" width="25" height="25" class="favoriteImage">
							        </label>
							        <input type="checkbox" name="favorite" class="favorite" value="${itemFavorite}" id="favoriteOn">
							    </div>
							</td>
					 		<td>
					 			<p>ここには項目名が入ります${itemName}</p>
					 		</td>
					 		<td>
							    <div class="remainBottun">
							        <label for="remainFull" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_full.png" width="25" height="25" class="remainImage">
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainFull">
							    </div>
							</td>
					 		<td>
							    <div class="remainBottun">
							        <label for="remainLittle" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_little.png" width="25" height="25" class="remainImage">
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainLittle">
							    </div>
							</td>
							<td>
							    <div class="remainBottun">
							        <label for="remainNone" class="remainLabel">
							            <img src="/syokuzaikanri/img/remain_none.png" width="25" height="25" class="remainImage">
							        </label>
							        <input type="radio" name="remain" class="remain" value="${itemRemain}" id="remainNone">
							    </div>
							</td>
						</div>
					  </tr>
				</table>

			</div>
		</div>
	</body>
</html>