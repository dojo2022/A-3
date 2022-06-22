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

<a href="/syokuzaikanri/MainServlet">戻る</a>

<!-- この部分にアカウント画像 -->

<div class="menu-wrap">
<form method="POST" action="/syokuzaikanri/">
<input type="hidden" name="accountIcon"value="1">

<label for="acd-menu">画像選択</label>
<input type="checkbox" id="selectIcon">
		<select name="Icon">
			    <option value="1"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="2"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="3"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="4"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="5"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="6"><img src="/syokuzaikanri/img" alt="画像"></option>
			    <option value="7"><img src="/syokuzaikanri/img" alt="画像"></option>
		 </select>
</form>
<form id="registForm" method="POST" action="/syokuzaikanri/AccountEditServlet">
			<table>
			<tr>
			<td>
			<a>ニックネーム　：</a><input type="text" name="userNAME" >
			</td>
			</tr>
	            <tr>
	              <td>
	                <a>ID・メールアドレス　：</a><input type="email" name="userId">
	              </td>
	            </tr>
	            <tr>
	              <td>
	              <a>PASS　：</a><input type="text" name="userPw" id="inputUserPw" ><br>
				</td>
				</tr>
				<tr>
				<td>
				<input type="submit" name="regist" value="変更">
				<input type="submit" name="regist" value="削除">
				</td>
				</tr>
			</table>
		</form>
</div>
</body>
</html>