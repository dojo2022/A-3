//お気に入りボタンの変更
var favorite_img_src = new Array("/syokuzaikanri/img/favorite_off.png","/syokuzaikanri/img/favorite_on.png");
var i = 0;
function favoriteImage(){
    if (i == 1) {
      i = 0;
    } else {
      i ++;
    }
    document.getElementById("favoriteImage").src = favorite_img_src[i];
}
//お気に入りのAjax


//賞味期限アラートのボタンの変更
var alert_img_src = new Array("/syokuzaikanri/img/alert_on.png","/syokuzaikanri/img/alert_off.png");
var j = 0;
function alertlImage(){
    if (j == 1) {
      j = 0;
    } else {
      j ++;
    }
    document.getElementById("alertlImage").src = alert_img_src[j];
}
//賞味期限アラートのAjax


//在庫登録アコーディオンのボタンの変更
var stockadd_img_src = new Array("/syokuzaikanri/img/stockadd_plus.png","/syokuzaikanri/img/stockadd_minus.png");
var k = 0;
function stockAddButton(){
    if (k == 1) {
      k = 0;
    } else {
      k ++;
    }
    document.getElementById("stockAddButton").src = stockadd_img_src[k];
}