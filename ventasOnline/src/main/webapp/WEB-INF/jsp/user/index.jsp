<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Index</title>
</head>
<body>



<c:if test="${not empty moClient}">
<button id="btnModal" class="btn btn-info hidden" data-toggle="modal" data-target="#datos">Ver Detalle</button>


    <div id="datos" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header login-header">
                    <button type="button" class="close" data-dismiss="modal">X</button>
                    <h4 class="modal-title">Detalle De Pedidos</h4>
                </div>
                <div class="modal-body">
                            
                    </div>
                <div class="modal-footer">
                	<label for="totalpe">Importe Total</label><input type="text" id="totalPe" disabled="disabled">
                    <button type="button" class="cancel" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>
   <script>
		$( "#btnModal" ).trigger( "click" );
   </script>
</c:if>
</body>
</html>
