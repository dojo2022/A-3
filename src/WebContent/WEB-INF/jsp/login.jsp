<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログインページ | ポケ蔵</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="/syokuzaikanri/javaScript/login.js"></script>
</head>
<body>
	<div class="wrapper" id="wrap">
	<div class="login">
		<img src="/syokuzaikanri/img/pokezo_logo.png" class="logo" alt="ロゴ">

		<form id="loginForm"  method="POST" action="/syokuzaikanri/LoginServlet">
			<table>
	            <tr>
	              <td>
	                <input type="email" required name="userId" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="ID・メールアドレス">
	              </td>
	            </tr>
	            <tr>
	              <td>
	              <input type="password" required name="userPw" id="inputUserPw"class="validate[required,custom[email]] feedback-input" placeholder="パスワード"><br>
					<label for="inputCheckbox"><input id="inputCheckbox" type="checkbox" name="pwView" value="1"> パスワードを表示する</label>
	              </td>
	            <tr>
	            <tr>
	              <td colspan="2" id="button">
	              	<input type="reset" name="loginReset" value="リセット">
	                <input type="submit"  class="sub" name="login" value="ログイン"><br>
	              <td>
	            </tr>
	        </table>
		</form>
		<table>
            <tr>
            	<td colspan="2">
					<a href="/syokuzaikanri/LoginServlet">パスワードを忘れた方はこちら</a>
            	<td>
            </tr>
            <form method="POST" action="/syokuzaikanri/AccountRegistServlet" id=AccountRegist">
            	<tr>
              		<td colspan="2">
               			<input type="submit" name="newRegistLink" value="新規登録">
              		<td>
            	</tr>
            </form>
	     </table>
	     </div>
	     <!-- フッター（ここから） -->
	     <div id="foot">
	     	<p>&copy;Copyright KANRANSHA . All rights reserved.</p>
	     </div>
	     <!-- フッター（ここまで） -->
	</div>
</body>
</html>


