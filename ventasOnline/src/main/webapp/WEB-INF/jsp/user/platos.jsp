<%@page import="com.webstotales.ventasOnline.domain.Usuario"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Platos</title>
<style>
.img-size{
	max-height: 100px;
	max-width: 200px;
}
</style>
</head>
<body>
<%Usuario user = (Usuario) session.getAttribute("user"); %>
		<c:if test="${not empty tipos }">
			<div class="row">
				<div class="col-md-6">
					<select class="form-control" onchange="buscarComida()" id="slTipo">
						<option value="0">-----Seleccione-----</option>
						<c:forEach items="${tipos }" var="tipo">
							<option value="<c:out value="${tipo.id }"/>"><c:out value="${tipo.nombre }"/></option>
						</c:forEach>
					</select>
				</div>
			</div>
		</c:if>
	<c:if test="${not empty platos}">

		<table class="table table-hover">
			<thead>
				<tr>
					<td>Imagen</td>
					<td>Codigo</td>
					<td>Nombre</td>
					<td>Precio</td>
					<td>Opcion</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${platos}" var="plato">
					<tr>
 						<%-- <td><img class="img-responsive img-size" src="resources/img/platos/<c:out value="${plato.idComida}"/>.jpg"/></td> --%>
 						<td><img class="img-responsive img-size" src="resources/img/platos/<c:out value="${plato.idComida }"/>.jpg"/></td> 
						<td><c:out value="${plato.idComida}"/></td>
						<td><c:out value="${plato.nombre }"/></td>
						<td><c:out value="${plato.precio }"/></td>
						<td><button  class="btn btn-success" onclick="agregarCarrito(<c:out value="${plato.idComida }"/>)">Agregar al Carrito </button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty platos }">
		<br>
		<br>
		<p class="alert alert-danger text-center"><b>No Se Encontraron Platos</b></p>
	</c:if>
	
	<script>
		function agregarCarrito(codigoComida){
			ajax.insertCarrito(<%=user.getIdUsuario()%>,codigoComida,function(data){
				
			});
		}
		function buscarComida(){
			var estado = $("#slTipo").val();
			if(estado!=0)window.location.href = '<c:url value="/bPlatos?tipo="/>'+estado;
		}

	</script>
</body>
</html>