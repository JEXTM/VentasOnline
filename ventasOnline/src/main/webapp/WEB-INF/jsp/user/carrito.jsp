<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito de Compras</title>
<style>
.img-size{
	max-height: 100px;
	max-width: 200px;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${not empty comidas }">
		<form:form action="sPedido" method="GET"  >
			<table class="table table-hover">
				<thead>
					<tr>
						<td>Imagen</td>
						<td>Codigo</td>
						<td>Nombre</td>
						<td>Precio</td>
						<td>Borrar</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comidas}" var="plato">
						<tr>
							<td class="hidden"><input type="hidden" value="${plato.comida.idComida}" name="idComida" id="idComida"></td>
	 						<td><img class="img-responsive img-size" src="resources/img/platos/<c:out value="${plato.comida.idComida }"/>.jpg"/></td> 
							<td><c:out value="${plato.comida.idComida}"/></td>
							<td><c:out value="${plato.comida.nombre }"/></td>
							<td><c:out value="${plato.comida.precio }"/></td>
							<td><button class="btn btn-danger" onclick="return borrar(<c:out value="${plato.idCarrito}"/>, this)">Borrar</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-info btn-block">Generar Comprobante</button>
		</form:form>
		</c:when>
		<c:otherwise>
			<p class="alert alert-danger text-center"><b>NO EXISTEN DATOS EN EL CARRITO</b></p>
		</c:otherwise>
	</c:choose>
	<script>
		function borrar(id,el){
			ajax.borrarCarrito(id,function(data){
				var row =$(el).parent().parent();
				row.remove();
			});
			return false;
		}
	</script>
</body>
</html>