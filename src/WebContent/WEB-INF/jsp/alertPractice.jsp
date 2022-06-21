<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>一覧だよ</h1>
<form method="POST" action="/syokuzaikanri/AlertPracticeServlet">

<input type="text" name="pageId">

 	<input type="submit" name="select" value="検索">
</form>




</body>
</html>