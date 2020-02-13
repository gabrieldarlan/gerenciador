<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<form action="${linkServletNovaEmpresa }" method="post">
		Nome: <input type="text" name="nome" /> 
		<input type="submit" value="Enviar" />
	</form>

</body>
</html>