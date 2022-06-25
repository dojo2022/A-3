<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買い物メモ</title>
</head>
<body>
	${memoList}
	<div class= memoitem>
	   <form id = memo method="POST" action="/syokuzaikanri/MemoTestServlet">
		<div class=memotitle>買い物メモ</div><br>
			<c:forEach begin="0" end="19" step="1" varStatus="status">
				●<input type="text" class= memotext size="28" name="in${status.index}" <%-- placeholder="in${status.index}" --%>>
				<input  type="checkbox" class = memocheck name = memocheck><br>
				<!-- index：<c:out value="${status.index}"/><br> -->
				<!--「name""」の位置は？ "in"${status.index} or "in${status.index}" -->
			</c:forEach>
		<div class = memobutton>

			<input type="reset" class=memob name="memoReset" value="リセット">
			&emsp;
			<input  type="submit" class=memob name="regist" value="保存"><br>

			<input  type="submit" class=memob name="regist" value="削除">
		</div>
		</form>
	</div>


</body>
</html>