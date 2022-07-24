<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Авторизация</title>
		<link type="text/css" rel="stylesheet" href="web-resources/css/authorizze.css">
	</head>
		<body>
			<div class="wind">
				<div id="cont">
					<div id="heading">Авторизация</div>
					<div id="data">
						<form method="post" action="/notes/authorize">
							<div id="inputs">
								<input name="login" placeholder="Логин" id="login">
								<input name="password" type="password" placeholder="Пароль" id="password">
							</div>
								<input class="b" id="sign_in" type="submit" value="Войти">
						</form>
								<button class="b" id="sign_up" onclick="document.location='/notes/sign_up'">Регистрация</button>
								<label id="error">Неверный логин или пароль</label>
					</div>
				</div>
			</div>
		</body>
</html>