<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Reply Page</h1>
	
	<form action="./${board}Reply" method="post">
		<input type="hidden" name="num" value="${num}">
		Title : <input type="text" name="title">
		Writer : <input type="text" name="writer">
		Contents : <textarea rows="" cols="" name="contents"></textarea>
		
		<button>REPLY</button>
	</form>
	
</body>
</html>