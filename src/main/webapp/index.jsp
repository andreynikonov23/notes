<html>
<body>
<h2>Hello World!</h2>
<%
	getServletContext().getRequestDispatcher("/init").forward(request, response);
%>
</body>
</html>
