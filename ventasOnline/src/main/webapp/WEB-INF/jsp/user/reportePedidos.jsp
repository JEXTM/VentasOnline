<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte De Pedidos</title>
</head>
<body>
	<c:if test="${not empty reportes}">
	<table class="table table-hover" id="dataTable">
		<thead>
			<tr>
				<td>Codigo</td>
				<td>Usuario</td>
				<td>Nombre</td>
				<td>Estado</td>
				<td>Sexo</td>
				<td>Cantidad De ventas</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reportes}" var="reporte">
				<tr class="">
					<td><c:out value="${reporte.usuario.idUsuario}"/></td>
					<td><c:out value="${reporte.usuario.usuario}"/></td>
					<td><c:out value="${reporte.usuario.nombre}"/> <c:out value="${reporte.usuario.apellidoPat}"/> <c:out value="${reporte.usuario.apellidoMat}"/></td>
					<td><c:out value="${reporte.usuario.estado}"/></td>
					<td><c:out value="${reporte.usuario.sexo}"/></td>
					<td><c:out value="${reporte.cantidad}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<c:if test="${empty reportes}">
<br>
<br>
	<p class="alert alert-danger"><b>No se Encontraron Clientes</b></p>
</c:if>
</body>
</html>