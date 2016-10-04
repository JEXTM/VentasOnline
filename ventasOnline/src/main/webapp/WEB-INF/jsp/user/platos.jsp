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
 						<td><img class="img-responsive img-size" src="http://comidasperuanas.net/wp-content/uploads/2015/07/Arroz-con-Pollo-Peruano-730x430.jpg"/></td> 
						<td><c:out value="${plato.idPresentacion}"/></td>
						<td><c:out value="${plato.nombre }"/></td>
						<td><c:out value="${plato.precio }"/></td>
						<td><button  class="btn btn-success" onclick="agregarCarrito(<c:out value="${plato.idPresentacion }"/>)">Agregar al Carrito</button></td>
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
			ajax.insertCarrito(1,codigoComida,function(data){
				
			});
		}
	</script>
</body>
</html>