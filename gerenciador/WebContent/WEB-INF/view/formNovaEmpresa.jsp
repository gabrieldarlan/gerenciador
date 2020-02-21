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
	<c:import url="logout-parcial.jsp"/>
	<form action="${linkEntradaServlet }" method="post">
		Nome: <input type="text" name="nome" /> 
		Data Abertura: <input type="text" name="data" /> 
		<input type="submit" value="Enviar" />
		<input type="hidden" name="acao" value="NovaEmpresa" />
	</form>

</body>
</html>