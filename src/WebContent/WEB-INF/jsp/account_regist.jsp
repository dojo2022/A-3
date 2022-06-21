<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="/syokuzaikanri/img/pokezo_logo.png" alt="ロゴ">
		<form id="registForm" method="POST" action="/syokuzaikanri/AccountRegistServlet">
			<table>
			<tr>
			<td>
			<input type="text" name="userNAME" placeholder="ニックネーム">
			</td>
			</tr>
	            <tr>
	              <td>
	                <input type="email" name="userId" placeholder="ID・メールアドレス">
	              </td>
	            </tr>
	            <tr>
	              <td>
	              <input type="password" name="userPw" id="inputUserPw" placeholder="パスワード"><br>
				</td>
				</tr>
				<tr>
				<td>
				<input type="submit" name="regist" value="新規登録">
				</td>
				</tr>
			</table>
		</form>
		<a href="/syokuzaikanri/LoginServlet">ログイン画面に戻る</a>
</body>
</html>