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
			 <table>
			 	<tr>
			 		<form id="searchbox" method="POST" action="/syokuzaikanri/MainServlet">
			 		<td>
						<input type="search" name="searchWord" placeholder="検索">
			 		</td>
			 		<td>
						<input type="submit" name="search" value="検索">
			 		</td>
			 </table>
			 		<input type="submit" name="returnList" value="一覧に戻す">
			 		</form>


			 		<div id="remainBottun">
					    <div class="remainBottun">
					        <label for="remainFull" class="remainLabel">
					            <img src="/syokuzaikanri/img/remain_full.png" width="25" height="25" class="remainImage">
					        </label>
					        <input type="radio" name="remain" class="remain" value="3" id="remain3">
					    </div>
					    <div class="remainBottun">
					        <label for="remainLittle" class="remainLabel">
					            <img src="/syokuzaikanri/img/remain_little.png" width="25" height="25" class="remainImage">
					        </label>
					        <input type="radio" name="remain" class="remain" value="2" id="remain2">
					    </div>
					    <div class="remainBottun">
					        <label for="remainNone" class="remainLabel">
					            <img src="/syokuzaikanri/img/remain_none.png" width="25" height="25" class="remainImage">
					        </label>
					        <input type="radio" name="remain" class="remain" value="1" id="remain1">
					    </div>
					</div>


			 	</tr>
			</div>
		</div>
	</body>
</html>