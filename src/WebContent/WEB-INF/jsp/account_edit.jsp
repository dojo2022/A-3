<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="javaScript/account_edit.js" charset="utf-8"></script>
	<link rel="stylesheet" type="text/css" href="css/account_edit.css">
</head>
<body>
	<img src="/syokuzaikanri/img/pokezo_logo.png" alt="ロゴ">
	<a href="/syokuzaikanri/MainServlet">戻る</a>
	<!-- この部分にアカウント画像 -->
	<div class="accordionIcon">

	  	<input id="accordionIcon-check" class="accordionIcon-check" type="checkbox">
		<label class="accordionIcon-label" for="accordionIcon-check">
			画像選択
		</label>
		<div class="accordionIcon-content">
			<table>
			  <tr>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage1" class="iconLabel1">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="1" id="iconImage1" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage2" class="iconLabel2">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="2" id="iconImage2" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage3" class="iconLabel3">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="3" id="iconImage3" onclick="iconChange()">
				    </div>
				  </td>
			  </tr>
			  <tr>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage4" class="iconLabel4">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="1" id="iconImage4" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage5" class="iconLabel5">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="2" id="iconImage5" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage6" class="iconLabel6">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="3" id="iconImage6" onclick="iconChange()">
				    </div>
				  </td>
			  </tr>
			  <tr>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage7" class="iconLabel7">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="1" id="iconImage7" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage8" class="iconLabel8">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="2" id="iconImage8" onclick="iconChange()">
				    </div>
				  </td>
				  <td>
	  				<div class="iconImageChange">
				        <label for="iconImage9" class="iconLabel9">
				            <img src="/syokuzaikanri/img/icon.png" width="100" height="100" class="iconImage" >
				        </label>
				        <input type="radio" name="selectIcon" class="selectIcon" value="3" id="iconImage9" onclick="iconChange()">
				    </div>
				  </td>
			  </tr>
			</table>
		</div>

<!-- 		<form method="POST" action="/syokuzaikanri/">
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
 -->

	<div class="userDate">
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