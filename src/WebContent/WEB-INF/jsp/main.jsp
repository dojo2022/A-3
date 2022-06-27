<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ | ポケ蔵</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/tabStyle.js"></script>
<meta  name=”viewport” content=”width=device-width,initial-scale=1.0″>
</head>


<body>
	<!-- 登録完了アラート  -->
	<c:if test="${registMsg  != null }">
		<script>alert("登録しました")</script>
	</c:if>
	<c:if test="${errorMsg  != null }">
		<script>alert("登録できませんでした")</script>
	</c:if>

	<!-- 更新完了アラート  -->
	<c:if test="${updateSuccessMsg  != null }">
	<script>alert("更新しました")</script>
	</c:if>
	<c:if test="${updateFailureMsg  != null }">
		<script>alert("更新できませんでした")</script>
	</c:if>

	<!-- 削除完了アラート  -->
	<c:if test="${deleteSuccessMsg  != null }">
		<script>alert("削除しました")</script>
	</c:if>
	<c:if test="${deleteFailureMsg  != null }">
		<script>alert("削除できませんでした")</script>
	</c:if>

<div class="wrapper">



<!-- nav  -->
<!-- <hr> 水平に線を引くためのタグ -->
<div id="nav">

	<div class="ham" id="ham">
		<!-- span 特に意味がないタグ、背景を黒にすることで線にしている -->
		<span class="ham_line ham_line1"></span>
		<span class="ham_line ham_line2"></span>
		<span class="ham_line ham_line3"></span>
	</div>
		<!-- ハンバーガーメニューの中身 -->
		<div class="menu_wrapper" id="menu_wrapper">
	            <div class="menu">
	                <ul  class="pageList">
		                <c:forEach var="page" items="${phList}" varStatus = "status">
			                <form method="GET" action="/syokuzaikanri/MainServlet" >
			                    <li><input type="hidden"name="pageId" value="${page.pageId}"><input type="submit" value="${page.pageTitle}" class="pageButton"></li>
							</form>
		                </c:forEach>
	                </ul>
	            </div>
	        </div>


<div class="item2"><img src="img/pokezo_logo.png"></div>
<div id="clock" class="item3" >日付</div>
<div class="item4">ヘルプ</div>
<div class="item4"><a href="/syokuzaikanri/LogoutServlet" class="logout">ログアウト</a></div>
<div class="item5">${user.userName}</div>
<div class="item6"><a href="/syokuzaikanri/AccountEditServlet"><img src="img/ishii.png"></a></div>

</div>
<!-- nav ここまで -->

<div class="grid_test"><!-- grit 親要素  -->
    <div class="grid_test-child"><!-- grit 子要素①  -->
	${pageTitle}
    </div>


    <div class="grid_test-child"><!-- grit 子要素②  -->
<div class="tabs">
		<input id="all" type="radio" name="tab_item" checked>
		<!-- ここからタブ -->
			<label class="tab_item" for="all">一覧</label>
			<input id="aaa" type="radio" name="tab_item">

			<label class="tab_item"	for="aaa">分類別</label>
			<input id="bbb" type="radio"	name="tab_item">

			<label class="tab_item" for="bbb">お気に入り</label>
			<input id="ccc" type="radio"	name="tab_item">

			<label class="tab_item" for="ccc">登録</label>
			<input id="ddd" type="radio"	name="tab_item">

			<label class="tab_item" for="ddd" id ="edit">編集/削除</label>


			<input type="hidden" id="flg" value="${flg}">






		<!-- ここから内容 -->
			<div class="tab_content" id="all_content">
				<%@ include file="tab_list.jsp" %>
			</div>

			<div class="tab_content" id="aaa_content">
				<%@ include file="tab_category.jsp" %>
			</div>

			<div class="tab_content" id="bbb_content">
				<%@ include file="tab_favorite.jsp" %>
			</div>

				<div class="tab_content" id="ccc_content">
				<%@ include file="tab_regist.jsp" %>
			</div>

			<div class="tab_content" id="ddd_content" >
				<%@ include file="tab_edit.jsp" %>

			</div>
	</div>
</div>


    <div class="grid_test-child"><!-- grit 子要素③  -->
	        <div class=alertTitle>賞味期限アラート</div>
	        <div class="stockAlert">
	        <c:forEach var="e" items="${message}"><br>
	        	<c:if test="${e.stockMessage != null}">${e.stockMessage}</c:if>
	        </c:forEach>
        </div>
	         <div class=alertTitle>買い替えアラート</div>
	    <div class="itemAlert">
	         <c:forEach var="e" items="${message}"><br>
	        	<c:if test="${e.itemMessage != null}">${e.itemMessage}</c:if>
	        </c:forEach>
        </div>
    </div>

    <div class="grid_test-child"><!-- grit 子要素④  -->
	<div class= memoitem>
	   <form id = memo method="POST" action="/syokuzaikanri/MemoTestServlet">

<!-- memoListに入っているmemoItemの値を出力する -->
<%-- 	   <c:forEach var="list" items="${memoList}">
				<c:out value="${list.memoItem}"/>
		</c:forEach> --%>

		<div class=memotitle>買い物メモ</div><br>
			<c:forEach begin="0" end="19" step="1" varStatus="status">
				●<input type="text" class= memotext size="28" name="in${status.index}" value = "${memoList[status.index].memoItem}"<%-- placeholder="in${status.index}" --%>>
				<input  type="checkbox" class = memocheck name = memocheck><br>
				<!-- index：<c:out value="${status.index}"/><br> -->
				<!--「name""」の位置は？ "in"${status.index} or "in${status.index}" -->
			</c:forEach>
		<div class = memobutton>
			<input  type="submit" class=memob name="regist" value="削除">
			&emsp;
			<input  type="submit" class=memob name="regist" value="保存">

		</div>
		</form>
	</div>
    </div>
</div>

  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright KANRANSHA . All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
<script>
window.onload = function(){
	let flg = document.getElementById("flg");
	if(flg.value=="切り替えフラグ"){
		document.getElementById("edit").click();
	}
}

function recalc(){
    const now = new Date

    let dayOfWeek=['日','月','火','水','木','金','土']
    const year = now.getFullYear();
    const month = now.getMonth()+1;
    const date = now.getDate();
    const hour = now.getHours();
    const min = now.getMinutes();


    document.getElementById('clock').textContent
    =year+'年'+' '+month+'月'+date+'日'+' '+'('+dayOfWeek[now.getDay()]+')';

    refresh();
}
    function refresh(){
   setTimeout(recalc,1000);
    }

recalc();

</script>
</body>
<!-- メインページ共通のjsファイルを読み込んでみた -->
<script type="text/javascript" src="javaScript/main.js" charset="utf-8"></script>

</html>
