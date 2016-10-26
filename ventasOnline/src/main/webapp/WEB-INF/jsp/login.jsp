<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html  lang="es">	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="fullscreen_bg" class="fullscreen_bg"/>
<br>
<br>
<br>
<br>
<div class="container">
	<form:form action="login" cssClass="form-signin" method="POST" commandName="usModel">
		<h1 class="form-signin-heading text-muted">Login</h1>
		<form:input path="usuario" cssClass="form-control" placeholder="Usuario" required="required"/>
		<form:password path="contrasena" cssClass="form-control" placeholder="Contraseña" required="required"/>
		<form:button class="btn btn-lg btn-danger">Enviar</form:button>
		<button class="btn btn-lg btn-danger" onclick="return registrar()" data-toggle="modal" data-target="#modalRegistrar">Registrar</button>
	</form:form>

</div> 



<script>
function registrar(){
	return false;
}
function save(){
	var nombre = $("#cNombre").val();
	var apePat = $("#cApePat").val();
	var apeMat = $("#cApeMat").val();
	var dni = $("#cDNI").val();
	var email = $("#cEmail").val();
	var direccion = $("#cDireccion").val();
	var usuario = $("#cUsuario").val();
	var password = $("#cPassword").val();
	var peso = $("#cPeso").val();
	var talla = $("#cTalla").val();
	var sexo = $("#cSexo").val();
	var celular = $("#cCelular").val();
	var fechaNac = $("#fechaNac").val();
	
	ajax.saveUsuario(nombre,apePat,apeMat,dni,email,direccion,usuario,password,peso,talla,sexo,celular,fechaNac,function(data){
		if(data==1){
			alert("Gracias Por Registrarse al Sistema");
			location.reload();
		}else{
			alert("Llene Datos correctamente");
		}
	});
}

</script>
</body>
</html>