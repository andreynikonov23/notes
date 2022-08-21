<%@page import="nick.pack.data.EntityList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="nick.pack.models.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="web-resources/css/main-style.css">
</head>
<body>
    <div class="add-popup">
        <div class="add-popup-content">
            <div class="popup-container">
                <input type="text" class="name-field" placeholder="Название">
                <textarea placeholder="Описание"></textarea>
                <div class="button-block">
                    <button class="cencel">Отмена</button>
                    <button class="ok">ОК</button>
                </div>
            </div>
            
        </div>
    </div>
	<div id="container">
        <nav>
            <div class="search-block">
                <form method="post" action="/notes/main">
                    <input name="search" id="search-field" type="search" placeholder="Поиск">
                    <input id="search-button" type="submit" value="Найти">
                </form>
            </div>
            <div class="user">
                <div class="visible">
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
                <div class="hover-block">
                    <div class="arrow-border"></div>
                    <div class="arrow"></div>
                    <div class="exit-container">
                        <button id="exit" onclick="document.location='/notes/signin'">Выход</button>
                    </div>
                </div>
            </div>
        </nav>
        <aside>
           <div class="add-note">
           		<div id="plus">+</div>
           </div>
           <%
           		List<Note> noteList = user.getNotes();
           		for(Note note : noteList){
           			String name = note.getName();
           			String text = note.getText();
           %>
           		<div class="note">
                    <div class="heading">
                        <div class="name">
                            <%=name %>
                        </div>
                        <div class="update-delete">
                            <div class="fa fa-pencil fa-lg"></div>
                            <div class="fa fa-trash fa-lg"></div>
                        </div>
                    </div>
                    <div class="info">
                    	<%=text %>
                    </div>
                </div>
         <%
           		}
         %>
        </aside>
    </div>
</body>
</html>