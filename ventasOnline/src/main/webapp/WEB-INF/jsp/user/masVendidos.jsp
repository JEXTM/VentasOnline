<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.webstotales.ventasOnline.domain.Usuario"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mas Vendidos</title>
<style>
.img-size{
	max-height: 100px;
	max-width: 200px;
}
</style>
</head>
<body>
	<c:if test="${not empty platos}">

		<table class="table table-hover">
			<thead>
				<tr>
					<td>Imagen</td>
					<td>Codigo</td>
					<td>Nombre</td>
					<td>Precio</td>
					<td>Cantidades Vendidas</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${platos}" var="plato">
					<tr>
 						<%-- <td><img class="img-responsive img-size" src="resources/img/platos/<c:out value="${plato.comida.idComida}"/>.jpg"/></td> --%>
						<td><img class="img-responsive img-size" src="resources/img/platos/<c:out value="${plato.comida.idComida }"/>.jpg"/></td>
						<td><c:out value="${plato.comida.idComida}"/></td>
						<td><c:out value="${plato.comida.nombre }"/></td>
						<td><c:out value="${plato.comida.precio }"/></td>
						<td><c:out value="${plato.cantidad }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>