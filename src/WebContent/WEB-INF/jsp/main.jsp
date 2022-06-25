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

<div class="item1">ham</div>
<div class="item2"><img src="img/pokezo_logo.png"></div>
<div class="item3">日付</div>
<div class="item4">ヘルプ</div>
<div class="item5">${user.userName}</div>
<div class="item6"><a href="/syokuzaikanri/AccountEditServlet"><img src="img/icon.png"></a></div>
</div>
<!-- nav ここまで -->

<div class="grid_test"><!-- grit 親要素  -->
    <div class="grid_test-child"><!-- grit 子要素①  -->
        メインページ
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
        これは仮の背景だよ
    </div>
    <div class="grid_test-child"><!-- grit 子要素④  -->
	<div class= memoitem>
	   <form id = memo method="POST" action="/syokuzaikanri/MemoTestServlet">
		<div class=memotitle>買い物メモ</div><br>
			<c:forEach begin="0" end="19" step="1" varStatus="status">
				●<input type="text" class= memotext size="28" name="in${status.index}" <%-- placeholder="in${status.index}" --%>>
				<input class = memocheck type="checkbox"><br>
				<!-- index：<c:out value="${status.index}"/><br> -->
				<!--「name""」の位置は？ "in"${status.index} or "in${status.index}" -->
			</c:forEach>
		<div class = memobutton>
			<input type="reset" class=memob name="memoReset" value="リセット">
			&emsp;
			<input  type="submit" class=memob name="SUBMIT" value="更新">
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
</script>
</body>


</html>
