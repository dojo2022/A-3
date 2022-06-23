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