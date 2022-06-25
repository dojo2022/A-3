
/*ハンバーガーメニュー*/
const ham = document.getElementById('ham');
const menu_wrapper = document.getElementById('menu_wrapper');
ham.addEventListener('click', function() {
    /*ハンバーガーメニューをクリックしたら×になる*/
	ham.classList.toggle('clicked');
    /*ハンバーガーメニューをクリックしたらメニューが出る*/
	menu_wrapper.classList.toggle('clicked');
});