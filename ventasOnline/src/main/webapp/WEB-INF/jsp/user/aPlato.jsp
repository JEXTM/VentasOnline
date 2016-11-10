<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Plato</title>
</head>
<body>
	<form:form action="sPlato" modelAttribute="pModel" method="POST">
		<div class="form-group">
			<div class="col-md-3">
				<label for="nombre">Nombre</label>
			</div>
			<div class="col-md-3">
				<form:input path="nombre" cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="cantidad">Cantidad</label>
			</div>
			<div class="col-md-3">
				<form:input path="cantidad" type="number" cssClass="form-control" required="required"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-3">
				<label for="precio">Precio</label>
			</div>
			<div class="col-md-3">
				<form:input path="precio"  cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="id">Tipo</label>
			</div>
			<div class="col-md-3">
				<form:select path="tipoComida.id" cssClass="form-control">
					<form:options items="${tipos}" itemLabel="nombre" itemValue="id"/>
				</form:select>
			</div>			
		</div>				
			<div class="col-md-4"><br><br><br></div>
			
	<form:button class="btn btn-danger btn-lg">Enviar</form:button>
	</form:form>
</body>
</html>