<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/dataTables.bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estado de Pedidos</title>
</head>
<body>
	<c:if test="${not empty pedidos }">
		<table class="table table-hover" id="dataTable">
			<thead>
				<tr>
					<td>Codigo</td>
	  				<td>Cliente</td>
	  				<td>Fecha</td>
	  				<td>Estado Actual</td>
	  				<td>Cambiar Estado</td>
	  			</tr>
			</thead>
			<tbody>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
		  			 	<td><c:out value="${pedido.idPedido}"/></td>
		  			 	<td><c:out value="${pedido.usuario.nombre}"/> <c:out value="${pedido.usuario.apellidoPat}"/> <c:out value="${pedido.usuario.apellidoMat}"/></td>
		  			 	<td><c:out value="${pedido.fecha}"/></td>
		  			 	<td><c:out value="${pedido.estado.descripcion}"/></td>
		  			 	<td>
		  			 		<select class="form-control" onchange="cambiarEstado(this)">
		  			 			<option value="0">Seleccione</option>
								<c:if test="${not empty estados }">
									<c:forEach items="${estados }" var="estado">
										<option value="<c:out value="${estado.idPedido }"/>"><c:out value="${estado.descripcion }"/></option>
									</c:forEach>
								</c:if>	  			 			
		  			 		</select>
		  			 	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<script>
		function cambiarEstado(el){
			var row = $(el).parent().parent();
			var codigo = row.children().first();
			ajax.updateEstado(el.value,codigo.text(),function(data){
				row.children().eq(3).text(el.value);
			});
		}
	</script>
	</c:if>
</body>
</html>