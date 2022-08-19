<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="nick.pack.models.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="web-resources/css/main.css">
</head>
<body>
	<div id="container">
        <nav>
            <div class="search-block">
                <form method="post" action="/notes/main">
                    <input name="search" id="search-field" type="search" placeholder="Поиск">
                    <input id="search-button" type="submit" value="Найти">
                </form>
            </div>
            <div class="user">
                <div id="circle">
                    <div class="fa fa-user fa-lg"></div>
                </div>
                <div id="username">
                	<%
                		User user = (User) session.getAttribute("user");
                	%>
                	<%=user.getLogin() %>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>