<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Maestro Pedidos</title>
</head>
<body>
	<c:if test="${not empty mPedido }">
		
	</c:if>
	<c:if test="${not empty select }">
	<br>
	<br>
	<div class="col-md-4"></div>
	<div class="col-md-4">
		<select class="form-control" id="estadoProceso" onchange="return getEstados(this)">
			<option value="0">--Seleccione--</option>
			<option value="I">Ingresado</option>
			<option value="P">En Proceso</option>
			<option value="T">Terminado</option>
			<option value="C">Cancelado</option>
		</select>
	</div>
	<br>
	<br>
	
	<table class="table table-hover">
		<thead>  
			<tr>			
				<td>Codigo</td>
  				<td>Cliente</td>
  				<td>Fecha</td>
  				<td>Detalle</td>
  				<td>Generar Comprobante</td>
  			</tr>
  		</thead>
		<tbody id="tbody">
	 	  	<c:forEach items="${pedidos}" var="pedido">
	 	  		<tr>
	  			 	<td><c:out value="${pedido.idPedido}"/></td>
	  			 	<td><c:out value="${pedido.usuario.nombre}"/> <c:out value="${pedido.usuario.apellidoPat}"/> <c:out value="${pedido.usuario.apellidoMat}"/></td>
	  			 	<td><c:out value="${pedido.fecha}"/></td>
	  			 	<td><button class="btn btn-primary btn-block" onclick="verDetalle(<c:out value="${pedido.idPedido}"/>)" data-toggle="modal" data-target="#detalle_ped">Ver Detalle</button></td>
	  			 	<td><a  class="btn btn-info btn-block" href="<c:url value="/downloadPdf?pedido=${pedido.idPedido}"/>">Generar Comprobante</a></td>
	  			 </tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	<c:if test="${not empty pedido}">
	<br>
	<br>

			<table class="table table-hover">
		<thead>  
			<tr>			
				<td>Codigo</td>
  				<td>Cliente</td>
  				<td>Fecha</td>
  				<td>Detalle</td>
  				<td>Generar Comprobante</td>
  			</tr>
  		</thead>
		<tbody id="tbody">
	  			 <c:forEach items="${pedido}" var="pedido">
		  			 <tr>
		  			 	<td><c:out value="${pedido.idPedido}"/></td>
		  			 	<td><c:out value="${pedido.usuario.nombre}"/> <c:out value="${pedido.usuario.apellido}"/></td>
		  			 	<td><c:out value="${pedido.fecha}"/></td>
		  			 	<td><button class="btn btn-primary btn-block" onclick="verDetalle(<c:out value="${pedido.idPedido}"/>)" data-toggle="modal" data-target="#detalle_ped">Ver Detalle</button></td>
		  			 	<td><a  class="btn btn-info btn-block" href="<c:url value="/downloadPdf?pedido=${pedido.idPedido}"/>">Generar Comprobante</a></td>
		  			 </tr>
	  			 </c:forEach>
		</tbody>
	</table>	
	</c:if>

	    <div id="detalle_ped" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header login-header">
                    <button type="button" class="close" data-dismiss="modal">X</button>
                    <h4 class="modal-title">Detalle De Pedidos</h4>
                </div>
                <div class="modal-body">
                            <label for="pedidoId">Codigo</label><input type="text" id="pedidoId" name="idPedido" disabled="disabled">
                            <label for="nombrePe">Nombre</label><input type="text" id="nombrePe" disabled="disabled">
							<label for="direccionPe">Direccion</label><input type="text" id="direccionPe" disabled="disabled">
							<label for="fechaPe">Fecha</label><input type="text" id="fechaPe" disabled="disabled">
							<label for="estadoPe">Estado</label><input type="text" id="estadoPe" disabled="disabled">
							<label for="">Detalle Comidas</label>
							<br>
							<label  id="bodyAdd"></label>
<!-- 							<label for="comidaPe">Comida</label><input type="text" id="comidaPe" disabled="disabled">
							<label for="cantidadPe">Cantidad</label><input type="text" id="cantidadPe" disabled="disabled">
							<label for="precioPe">Precio</label><input type="text" id="precioPe" disabled="disabled">---> 
                    </div>
                <div class="modal-footer">
                	<label for="totalpe">Importe Total</label><input type="text" id="totalPe" disabled="disabled">
                    <button type="button" class="cancel" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
	
	
	
	<script type="text/javascript">
		function getEstados(estado){
			if(estado!=0)window.location.href = '<c:url value="/mPedido?estado="/>'+estado.value;
		}
/*		ajax.getpedidobyestado("i",function(data){
			$("tbody").children().remove();
			for(var i=0;i<data.length;i++){
				$("#tbody").append('<tr><td>'+data[i][0]+'<td></tr>');
			}
		});
	} */
	
	function verDetalle(id){
		ajax.getDetallePedido(id,function(data){
			if(data.length==0){
				dwr.util.setValue('pedidoId', 'Lo sentimos Su Consulta No Pudo Realizarse');
				dwr.util.setValue('nombrePe', '');
				dwr.util.setValue('direccionPe', '');
				dwr.util.setValue('fechaPe', '');
				dwr.util.setValue('estadoPe', '');
				dwr.util.setValue('totalPe','');
				$("#bodyAdd").text('');
			}else{
				dwr.util.setValue('pedidoId', data[0][0]);
				dwr.util.setValue('nombrePe', data[0][1]+" "+data[0][2]);
				dwr.util.setValue('direccionPe', data[0][3]);
				dwr.util.setValue('fechaPe', data[0][4]);
				dwr.util.setValue('estadoPe', data[0][5]);
				dwr.util.setValue('totalPe',data[0][9]);
				$("#bodyAdd").text('');
				for(var i=0; i<data.length;i++){
					$("#bodyAdd").append("<label>Comida: "+data[i][6]+" Cantidad: "+data[i][7]+" Precio: "+data[i][8]+"</label>");
				}
			}
		});
	}
	</script>
</body>
</html>
