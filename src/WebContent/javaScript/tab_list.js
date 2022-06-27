//お気に入りボタンの変更
function favoriteOff(favoriteOffIndexNo){
	alert("functionはいったよ！");
	var itemFavorite = false;
	var itemRemain = document.getElementById('nowRemain' + favoriteOffIndexNo).value ;
	var itemId = document.getElementById('itemName' + favoriteOffIndexNo).value ;

	console.log(itemFavorite);
	console.log(itemRemain);
	console.log(itemId);

	let postData = {itemFavorite:itemFavorite,remain:itemRemain,itemName:itemId}
	console.log(postData);

/*		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/ItemAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
    document.getElementById('favoriteOff' + favoriteOffIndexNo).src = "/syokuzaikanri/img/favorite_off.png";
}
function favoriteOn(favoriteOnIndexNo){
	alert("functionはいったよ！");
	var itemFavorite = true;
	var itemRemain = document.getElementById('nowRemain' + favoriteOnIndexNo).value ;
	var itemId = document.getElementById('itemName' + favoriteOnIndexNo).value ;

	console.log(itemFavorite);
	console.log(itemRemain);
	console.log(itemId);

	let postData = {itemFavorite:itemFavorite,remain:itemRemain,itemName:itemId}
	console.log(postData);

/*		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/ItemAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
    document.getElementById('favoriteOn' + favoriteOnIndexNo).src = "/syokuzaikanri/img/favorite_on.png";
}


//残量の更新
function favoriteOff(favoriteOffIndexNo){
	alert("functionはいったよ！");
	var itemFavorite = false;
	var itemRemain = document.getElementById('nowRemain' + favoriteOffIndexNo).value ;
	var itemId = document.getElementById('itemName' + favoriteOffIndexNo).value ;

	console.log(itemFavorite);
	console.log(itemRemain);
	console.log(itemId);

	let postData = {itemFavorite:itemFavorite,remain:itemRemain,itemName:itemId}
	console.log(postData);

/*		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/ItemAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
    document.getElementById('favoriteOff' + favoriteOffIndexNo).src = "/syokuzaikanri/img/favorite_off.png";
}




//在庫の更新
function updateStock(stockIndexNo){
	alert("functionはいったよ！");
	var stockId = document.getElementById('stockId' + stockIndexNo).value ;
	var stockName = document.getElementById('stockName' + stockIndexNo).value ;
	var stockBuy = document.getElementById('stockBuy' + stockIndexNo).value ;
	var stockLimit = document.getElementById('stockLimit' + stockIndexNo).value ;
	var bell = document.getElementById('alertlOff' + stockIndexNo);

	console.log(stockId);
	console.log(stockName);
	console.log(stockBuy);
	console.log(stockLimit);
	console.log(bell);

/*	if (document.getElementById('alertlOff' + stockIndexNo) == true) {
      var bell = true;
    } else {
      l ++;
    }

	console.log(stockId);
	console.log(stockName);
	console.log(stockBuy);
	console.log(stockLimit);
	console.log(bell);

	let postData = {stockId:stockId,stockName:stockName,stockBuy:stockBuy,stockLimit:stockLimit,bell:bell}
	console.log(postData);

		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/StockAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
}


//賞味期限アラート
function alertlOff(alertlOffIndexNo){
	alert("functionはいったよ！");
	var stockId = document.getElementById('stockId' + alertlOffIndexNo).value ;
	var stockName = document.getElementById('stockName' + alertlOffIndexNo).value ;
	var stockBuy = document.getElementById('stockBuy' + alertlOffIndexNo).value ;
	var stockLimit = document.getElementById('stockLimit' + alertlOffIndexNo).value ;
	var bell = false ;

	console.log(stockId);
	console.log(stockName);
	console.log(stockBuy);
	console.log(stockLimit);
	console.log(bell);

	let postData = {stockId:stockId,stockName:stockName,stockBuy:stockBuy,stockLimit:stockLimit,bell:bell}
	console.log(postData);

/*		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/StockAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
    document.getElementById('alertlOff' + alertlOffIndexNo).src = "/syokuzaikanri/img/alert_off.png";
}
function alertlOn(alertlOnIndexNo){
	alert("functionはいったよ！");
	var stockId = document.getElementById('stockId' + alertlOnIndexNo).value ;
	var stockName = document.getElementById('stockName' + alertlOnIndexNo).value ;
	var stockBuy = document.getElementById('stockBuy' + alertlOnIndexNo).value ;
	var stockLimit = document.getElementById('stockLimit' + alertlOnIndexNo).value ;
	var bell = true ;

	console.log(stockId);
	console.log(stockName);
	console.log(stockBuy);
	console.log(stockLimit);
	console.log(bell);

	let postData = {stockId:stockId,stockName:stockName,stockBuy:stockBuy,stockLimit:stockLimit,bell:bell}
	console.log(postData);

/*		//非同期通信始めるよ
	$.ajaxSetup({scriptCharset:'utf-8'});
	$.ajax({
		//どのサーブレットに送るか
		//ajaxSampleのところは自分のプロジェクト名に変更する必要あり。
		url: '/syokuzaikanri/StockAjaxServlet',
		//どのメソッドを使用するか
		type:"POST",
		//何をサーブレットに飛ばすか（変数を記述）
		data: postData,
		//この下の２行はとりあえず書いてる（書かなくても大丈夫？）
		processDate:false,
		timeStamp: new Date().getTime()
	})*/
	document.getElementById('alertlOn' + alertlOnIndexNo).src = "/syokuzaikanri/img/alert_on.png";
}


//在庫登録アコーディオンのボタンの変更
var stockadd_img_src = new Array("/syokuzaikanri/img/stockadd_plus.png","/syokuzaikanri/img/stockadd_minus.png");
var l = 0;
var m = 0;
function stockAddButton(stockaddIndexNo){
    if (l == 1) {
      l = 0;
    } else {
      l ++;
    }
    document.getElementById("stockAddButton" + stockaddIndexNo).src = stockadd_img_src[l];
}
function stockAddOutButton(){
    if (m == 1) {
      m = 0;
    } else {
      m ++;
    }
    document.getElementById("stockAddOutButton").src = stockadd_img_src[m];
}