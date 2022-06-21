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

<form id = memo method="POST" action="/syokuzaikanri/MemoTestServlet">
<c:forEach begin="0" end="19" step="1" varStatus="status">
<input type="text" name="in${status.index}" placeholder="in${status.index}">
<input type="checkbox">
index：<c:out value="${status.index}"/><br>
<!--「""」の位置は？ "in"${status.index} or "in${status.index}" -->
</c:forEach>
<!-- begin  : 初期値
end : ～になるまで
step ; ずつ増やす -->

<input  type="submit" name="SUBMIT" value="更新">
</form>


</body>
</html>