<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<form action="${linkEntradaServlet }" method="post">
		Login: <input type="text" name="login" /> 
		Senha: <input type="password" name="senha" /> 
		<input type="submit" value="Enviar" />
		<input type="hidden" name="acao" value="Login" />
	</form>

</body>
</html>