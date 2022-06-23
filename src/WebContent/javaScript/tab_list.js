//お気に入りボタンの変更(おきに入り→お気に入りじゃないの場合)
var favorite1_img_src = new Array("/syokuzaikanri/img/favorite_on.png","/syokuzaikanri/img/favorite_off.png");
var h = 0;
function favoriteImage1(){
    if (h == 1) {
      h = 0;
    } else {
      h ++;
    }
    document.getElementById("favoriteImage1").src = favorite1_img_src[h];
}
//お気に入りボタンの変更(おきに入りじゃない→お気に入り場合)
var favorite0_img_src = new Array("/syokuzaikanri/img/favorite_off.png","/syokuzaikanri/img/favorite_on.png");
var i = 0;
function favoriteImage0(){
    if (i == 1) {
      i = 0;
    } else {
      i ++;
    }s
    document.getElementById("favoriteImage0").src = favorite0_img_src[i];
}
//お気に入りのAjax


//賞味期限アラートのボタンの変更(On→Off)
var alert1_img_src = new Array("/syokuzaikanri/img/alert_on.png","/syokuzaikanri/img/alert_off.png");
var j = 0;
function alertlImage1(){
    if (j == 1) {
      j = 0;
    } else {
      j ++;
    }
    document.getElementById("alertlImage1").src = alert1_img_src[j];
}
//賞味期限アラートのボタンの変更(Off→On)
var alert0_img_src = new Array("/syokuzaikanri/img/alert_off.png","/syokuzaikanri/img/alert_on.png");
var k = 0;
function alertlImage0(){
    if (k == 1) {
      k = 0;
    } else {
      k ++;
    }
    document.getElementById("alertlImage0").src = alert0_img_src[k];
}
//賞味期限アラートのAjax


//在庫登録アコーディオンのボタンの変更
var stockadd_img_src = new Array("/syokuzaikanri/img/stockadd_plus.png","/syokuzaikanri/img/stockadd_minus.png");
var l = 0;
function stockAddButton(){
    if (l == 1) {
      l = 0;
    } else {
      l ++;
    }
    document.getElementById("stockAddButton").src = stockadd_img_src[l];
}