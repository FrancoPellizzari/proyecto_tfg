<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>FORMULARIO EDITAR EVENTO</h1>
	<form action="/evento/editar" method="post">
		<p><input type="text" name="codigo" value="${evento.idProducto }">Codigo</p>
		<p><input type="text" name="nombreProducto" value="${evento.nombreProducto }">Nombre</p>
		<p><input type="text" name="descripcion" value="${evento.descripcion }">Descripcion</p>
		<p><input type="text" name="precioUnitario" value="${evento.precio }">Precio</p>
		<p><input type="text" name="familia.codigo" value="${evento.familia.idFamilia }">Familia</p>
		
		
		<p><input type="submit" value="Guardar"></p>
		
	
	</form>
</body>
</html>