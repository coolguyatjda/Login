<%@page import="com.jda.model.UserModel"%>
<html>
<head>
</head>
<body>
	<%
		String username = "";
		response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
		if (session != null) {
			if (session.getAttribute("user") != null) {
				UserModel user = (UserModel) request.getSession().getAttribute("user");
				username = user.getName();
			} else {
				response.sendRedirect("index.jsp");
			}
		}
	%>
	Welcome :
	<%=username%>
	<br>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>