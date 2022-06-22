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
<div class="wrapper">
${user.userName}
${stocklist.ItemName}

<!-- nav  -->
<!-- <hr> 水平に線を引くためのタグ -->
<div id="nav">

<div class="item1">ham</div>
<div class="item2"><img src="img/pokezo_logo.png"></div>
<div class="item3">日付</div>
<div class="item4">ニックネーム</div>
<div class="item5"><img src="img/icon.png"></div>
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

			<label class="tab_item" for="ddd">編集/削除</label>


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
			<div class="tab_content" id="ddd_content">
				<%@ include file="tab_edit.jsp" %>
			</div>
	</div>
</div>


    <div class="grid_test-child"><!-- grit 子要素③  -->
        これは仮の背景だよ
    </div>
    <div class="grid_test-child"><!-- grit 子要素④  -->
        コンテンツが入ります
    </div>
</div>

  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright KANRANSHA . All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
</body>


</html>
