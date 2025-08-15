<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FindAttribute Sample</title>
</head>
<body>
	<% 
		pageContext.setAttribute("msg", "ページスコープ");
		request.setAttribute("msg", "リクエストスコープ");
		session.setAttribute("msg", "セッションスコープ");
		application.setAttribute("msg", "アプリケーションスコープ");
	%>
	
	<h1><%= pageContext.findAttribute("msg") %></h1>
</body>
</html>