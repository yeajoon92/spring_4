<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Update Page</h1>
	
	<form action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${dto.num}">
		Title : <input type="text" name="title" value="${dto.title}">
		Writer : <input type="text" name="writer" value="${dto.writer}">
		Contents : <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
		
		<button>UPDATE</button>
	</form>
	
</body>
</html>