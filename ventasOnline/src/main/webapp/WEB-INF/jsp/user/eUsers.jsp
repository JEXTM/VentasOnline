<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estado de Usuarios</title>
</head>
<body>
<c:if test="${not empty clientes}">
	<table class="table table-hover" id="dataTable">
		<thead>
			<tr>
				<td>Codigo</td>
				<td>Usuario</td>
				<td>Nombre</td>
				<td>Estado</td>
				<td>Sexo</td>
				<td>idmc</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="cliente">
			<c:choose>
				<c:when test="${cliente.idmc < 17}">
					<c:set var="color" value="warning"/>
				</c:when>
				<c:when test="${cliente.idmc > 25}">
					<c:set var="color" value="danger"/>
				</c:when>
				<c:otherwise>
					<c:set var="color" value="success"/>
				</c:otherwise>
			</c:choose>
				<tr class="<c:out value="${color }"/>">
					<td><c:out value="${cliente.idUsuario}"/></td>
					<td><c:out value="${cliente.usuario}"/></td>
					<td><c:out value="${cliente.nombre}"/> <c:out value="${cliente.apellidoPat}"/> <c:out value="${cliente.apellidoMat}"/></td>
					<td><c:out value="${cliente.estado}"/></td>
					<td><c:out value="${cliente.sexo}"/></td>
					<td><c:out value="${cliente.idmc}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<c:if test="${empty clientes}">
<br>
<br>
	<p class="alert alert-danger"><b>No se Encontraron Clientes</b></p>
</c:if>
</body>
</html>