<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="web-resources/css/registration.css">
    </head>
    <body>
        <div id="wind">
            <div class="cont">
                <div id="heading">Регистрация</div>
                <div class="forms">
                    <form method="post" action="/notes/registr">
                        <div id="fields">
                            <input name="name" placeholder="Name" class="field">
                            <input name="login" placeholder="Login" class="field">
                            <input name="password" placeholder="password" type="password" class="field">
                        </div>
                        <p id="error">Введеный логин уже зарегистрирован</p>
                        <input type="submit" value="Зарегистрироваться" id="submit">
                    </form>
                </div>
                <div id="link_b">
                    <a href="/notes/signin">Авторизация</a>
                </div>
            </div>
        </div>
    </body>
</html>