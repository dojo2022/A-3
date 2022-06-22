//お気に入りボタンの変更
var img_src = new Array("/syokuzaikanri/img/alert_on.png","/syokuzaikanri/img/alert_off.png");
var i = 0;
function favoriteImage(){
    if (i == 1) {
      i = 0;
    } else {
      i ++;
    }
    document.getElementById("favoriteImage").src = img_src[i];
}
//お気に入りのAjax


//賞味期限アラートのボタンの変更
var img_src = new Array("/syokuzaikanri/img/alert_on.png","/syokuzaikanri/img/alert_off.png");
var i = 0;
function alertlImage(){
    if (i == 1) {
      i = 0;
    } else {
      i ++;
    }
    document.getElementById("alertlImage").src = img_src[i];
}
//賞味期限アラートのAjax


//在庫登録アコーディオンのボタンの変更
var img_src = new Array("/syokuzaikanri/img/stockadd_plus.png","/syokuzaikanri/img/stockadd_minus.png");
var i = 0;
function stockAddButton(){
    if (i == 1) {
      i = 0;
    } else {
      i ++;
    }
    document.getElementById("stockAddButton").src = img_src[i];
}