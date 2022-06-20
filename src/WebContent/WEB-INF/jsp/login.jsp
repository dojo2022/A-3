<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ポケ蔵～POKEZO～</title>
</head>
<body>
	<div class="login">
		<img src="/syokuzaikanri/img/pokezo_logo.png" alt="ロゴ">
		<form id="login_form" method="POST" action="/syokuzaikanri/LoginServlet">
			<table>
	            <tr>
	              <td>
	                <input type="email" name="userId" placeholder="ID・メールアドレス">
	              </td>
	            </tr>
	            <tr>
	              <td>
	                <input type="password" name="userPw" placeholder="パスワード">
	              </td>
	            <tr>
	            <tr>
	              <td colspan="2">
	                <input type="submit" name="login" value="ログイン">
	                <input type="reset" name="loginReset" value="リセット"><br>
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
</body>
</html>