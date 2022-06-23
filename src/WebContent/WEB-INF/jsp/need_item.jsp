<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/need_item.css">
</head>
<body>
<img src="img/pokezo_logo.png">

<h2>必須項目登録画面</h2>
<p>あなたに必要な食材を選んでください</p>

<div id="selectItem">
	<div >
		<ul>
			<li><h3>野菜</h3></li>
			<li><input type="checkbox">キャベツ</li>
			<li><input type="checkbox">レタス</li>
			<li><input type="checkbox">玉ねぎ</li>
			<li><input type="checkbox">人参</li>
			<li><input type="checkbox">ジャガイモ</li>
			<li><input type="checkbox">ブロッコリー</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>肉類</h3></li>
			<li><input type="checkbox">牛肉</li>
			<li><input type="checkbox">豚肉</li>
			<li><input type="checkbox">鶏肉</li>
			<li><input type="checkbox">ひき肉</li>
			<li><input type="checkbox">ウィンナー</li>
			<li><input type="checkbox">ハム</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>魚類</h3></li>
			<li><input type="checkbox">鮭</li>
			<li><input type="checkbox">ホッケ</li>
			<li><input type="checkbox">カレイ</li>
			<li><input type="checkbox">シシャモ</li>
			<li><input type="checkbox">刺身</li>
			<li><input type="checkbox">タイ</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>炭水化物</h3></li>
			<li><input type="checkbox">米</li>
			<li><input type="checkbox">パン</li>
			<li><input type="checkbox">パスタ</li>
			<li><input type="checkbox">うどん</li>
			<li><input type="checkbox">そば</li>
			<li><input type="checkbox">そうめん</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>調味料</h3></li>
			<li><input type="checkbox">醤油</li>
			<li><input type="checkbox">酒</li>
			<li><input type="checkbox">みりん</li>
			<li><input type="checkbox">酢</li>
			<li><input type="checkbox">塩</li>
			<li><input type="checkbox">砂糖</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>飲み物</h3></li>
			<li><input type="checkbox">珈琲</li>
			<li><input type="checkbox">麦茶</li>
			<li><input type="checkbox">緑茶</li>
			<li><input type="checkbox">ココア</li>
			<li><input type="checkbox">マンゴーラッシー</li>
			<li><input type="checkbox">紅茶</li>
		</ul>
	</div>

	<div>
		<ul>
			<li><h3>その他</h3></li>
			<li><input type="checkbox">お菓子</li>
			<li><input type="checkbox">食器用洗剤</li>
			<li><input type="checkbox">ラップ</li>
			<li><input type="checkbox">手洗い石鹸</li>
			<li><input type="checkbox">ゴミ袋</li>
		</ul>
	</div>
</div>

<form method="GET" action="/syokuzaikanri/MainServlet">
	<input type="submit" name="skip" value="スキップ">
</form>
登録




</body>
</html>