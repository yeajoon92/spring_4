<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		}
		
		$("#del").click(function() {
			("#frm").submit();
		});
	});
</script>
</head>
<body>
<h1>${board} Select Page</h1>
	
	<h3>Title : ${boardDTO.title}</h3>
	<h3>Writer : ${boardDTO.writer}</h3>
	<h3>Contents : ${boardDTO.contents}</h3>
	
	<a href="./${board}List">LIST</a>
	<a href="./${board}Update?num=${boardDTO.num}">UPDATE</a>
	<span id="del">delete</span>
	<form id="frm" action="./${board}Delete" method="post">
		<input type="hidden" name="num" value="1">
	</form>
	
	<c:if test="${board ne 'notice'}">
		<a href="./${board}Reply?num=${boardDTO.num}">REPLY</a>
	</c:if>
</body>
</html>