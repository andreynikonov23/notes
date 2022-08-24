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
<link type="text/css" rel="stylesheet" href="web-resources/css/main.css">
<script type="text/javascript" src="web-resources/js/script.js"></script>
</head>
<body>
    <div id="add-popup">
        <div class="popup-content">
            <div class="popup-container">
                <div class="cencel">
                    <div class="cross" onclick="closeAddPopup()">X</div>
                </div>
                <form method="post" action="/notes/add">
		            <input name="name" type="text" class="name-field" placeholder="Название">
		            <textarea name="text" placeholder="Описание"></textarea>
                    <div class="button">
                        <input id="send" class="popup-btn ok" type="submit" formaction="/notes/add" formmethod="post" value="OK">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="edit-popup">
        <div class="popup-content">
            <div class="popup-container">
                <div class="cencel">
                    <div class="cross" onclick="closeUpdatePopup()">X</div>
                </div>
                <form method="post" action="/notes/edit">
                    <input type="hidden" name="id" id="identify">
		            <input name="name" type="text" class="name-field" id="edit-name" placeholder="Название">
		            <textarea name="text" id="edit-text" placeholder="Описание"></textarea>
                    <div class="button">
                        <input id="send" class="popup-btn ok" type="submit" value="OK">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="delete-popup">
        <div class="delete-popup-content">
            <div class="popup-container">
                <div class="question">Вы действительно хотите удалить эту заметку?</div>
                <form method="post" action="/notes/delete">
                    <input type="hidden" id="id-delete" name="id">
                    <input class="popup-btn" type="submit" value="Да">
                </form>
                <button class="popup-btn" onclick="closeDeletePopup()">Нет</button>
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
           <button id="add-note" onclick="openAddPopup()">
           		<div id="plus">+</div>
           </button>
           <%
           		List<Note> noteList = user.getNotes();
           		for(Note note : noteList){
                    int id = note.getId();
           			String name = note.getName();
           			String text = note.getText();
           %>
           		<div class="note">
                    <div class="heading">
                        <div class="name">
                            <%=name %>
                        </div>
                        <div class="id">
                            <%=id %>
                        </div>
                        <div class="update-delete">
                            <div class="fa fa-pencil fa-lg" onclick="openUpdatePopup(<%=id %>, '<%=name %>', '<%=text %>')"></div>
                            <div class="fa fa-trash fa-lg" onclick="openDeletePopup(<%=id %>)"></div>
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