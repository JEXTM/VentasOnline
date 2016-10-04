<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cliente</title>
</head>
<body>
	<form:form action="aClient" method="POST" modelAttribute="clModel">
		<div class="form-group">
			<div class="col-md-3">
				<label for="nombre">Nombre</label>
			</div>
			<div class="col-md-3">
				<form:input path="nombre" cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="apellido">Apellido Paterno</label>
			</div>
			<div class="col-md-3">
				<form:input path="apellidoPat" cssClass="form-control" required="required"/>
			</div>
		</div>
<br>
<br>
<br>
		<div class="form-group">
			<div class="col-md-3">
				<label for="direccion">Apellido Materno</label>
			</div>
			<div class="col-md-3">
				<form:input path="apellidoMat" cssClass="form-control" required="required" />
			</div>
			<div class="col-md-3">
				<label for="dni">DNI</label>
			</div>
			<div class="col-md-3">
				<form:input path="dni" cssClass="form-control"  required="required"/>
			</div>
		</div>
<br>
<br>
		<div class="form-group">
			<div class="col-md-3">
				<label for="email">Email</label>
			</div>
			<div class="col-md-3">
				<form:input path="correo" cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="direccion">Direccion</label>
			</div>
			<div class="col-md-3">
				<form:input path="direccion" cssClass="form-control" required="required" />
			</div>
		</div>
<br>
<br>
		<div class="form-group">
			<div class="col-md-3">
				<label for="username">Usuario</label>
			</div>
			<div class="col-md-3">
				<form:input path="usuario" cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="password">Contraseña</label>
			</div>
			<div class="col-md-3">
				<form:input path="contrasena" cssClass="form-control" required="required"/>
			</div>
		</div>
<br>
<br>
		<div class="form-group">
			<div class="col-md-3">
				<label for="peso">Peso</label>
			</div>
			<div class="col-md-3">
				<form:input path="peso" cssClass="form-control" required="required"/>
			</div>
			<div class="col-md-3">
				<label for="talla">Talla</label>
			</div>
			<div class="col-md-3">
				<form:input path="talla" cssClass="form-control" required="required"/>
			</div>
		</div>
		<br>
<br>
		<div class="form-group">
			<div class="col-md-3">
				<label for="peso">Sexo</label>
			</div>
			<div class="col-md-3">
				<form:select path="sexo" cssClass="form-Control" required="required">
					<form:option value="M">Masculino</form:option>
					<form:option value="F">Femenino</form:option>
				</form:select>
			</div>
		</div>
		<br>
		<br>
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form:button Class="btn btn-success btn-block">Confirmar</form:button>
		</div>
		<div class="col-md-4"></div>
	</form:form>
</body>
</html>