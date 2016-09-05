<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
  <head>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <script src='<c:url value="dwr/engine.js"/>'></script>
	<script src='<c:url value="dwr/interface/ajax.js"/>'></script>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />    
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
    <link href="<c:url value="/resources/css/AdminLTE.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/skins/_all-skins.min.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/plugins/iCheck/flat/blue.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/plugins/morris/morris.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/plugins/datepicker/datepicker3.css" />" rel="stylesheet" type="text/css" />    
    <link href="<c:url value="/resources/plugins/daterangepicker/daterangepicker-bs3.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" />" rel="stylesheet" type="text/css" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <title>Sistema de Ventas Online <decorator:title/></title>
    <decorator:head/>
  </head>
  <body class="skin-blue">
<%if(request.getAttribute("j_user")==null || request.getAttribute("j_user").equals(null)){
		request.getRequestDispatcher("/login").forward(request, response);
	} %>
    <decorator:body/>
    
	    <div class="wrapper">
      
      <header class="main-header">
        <!-- Logo -->
        <a href="<c:url value="/admin" />" class="logo"><b>Comida Saludable</b></a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              
              <!-- Notifications: style can be found in dropdown.less -->
              
              <!-- Tasks: style can be found in dropdown.less -->
              
              <!-- User Account: style can be found in dropdown.less -->
            </ul>
          </div>
        </nav>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
            <img src="<c:url value="/resources/img/flores.jpg" />"/>
              
            </div>
            <div class="pull-left info">
              <p>Jorge Flores Flores</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">                           
                        <li><a href="<c:url value="/clientes" />"><i class="fa fa-user"></i> XXXXXXXXX</a></li>
                        <li><a href="<c:url value="/rutas" />"><i class="fa fa-users"></i> XXXXXXX</a></li>
                        <!-- <li><a href="<c:url value="/ventas" />"><i class="fa fa-bar-chart"></i> xxxxxxxxxx</li>-->
                        <!-- <li><a href="<c:url value="/ventars" />"><i class="fa fa-bar-chart"></i> xxxxxxxxxxx</a></li>-->
                        <li><a href="<c:url value="/vendedores" />"><i class="fa fa-users"></i> XXXXXXXXXXXXXXX</a></li>
                        <li><a href="<c:url value="/choferes" />"><i class="fa fa-users"></i> XXXXXXXXXXXXXXXXXXXXX</a></li>
                        <li><a href="<c:url value="/modelos" />"><i class="fa fa-car"></i> XXXXXXXXXXXXXXXXXX</a></li>
                        <li><a href="<c:url value="/vendedores1" />"><i class="fa fa-users"></i> XXXXXXXXXXXXXXXXXXXxxx</a></li>
                        <li><a href="<c:url value="/modelos1" />"><i class="fa fa-car"></i> XXXXXXXXXXXXXXXXXXXxxxx</a></li>   
                        <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-sign-out"></i> XXXXXXXXXX</a></li>                 
                                      
                    </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
                    <div >
                        <img src="<c:url value="/resources/img/be.gif" />" height="42" width="42" />
                    </div>
                    <h1>
                        BUSES DE LIMA <small>-  XXXXXXXXXXXXXXX</small>
                    </h1>
                </section>

        <!-- Main content -->
        <section class="content">
         

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <!-- <footer class="main-footer">
        <div class="pull-right hidden-xs">
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="#">BMW</a>.</strong> All rights reserved.
      </footer> -->
    </div><!-- ./wrapper -->    
    

     <!-- jQuery 2.1.3 -->
    <script src=<c:url value="/resources/plugins/jQuery/jQuery-2.1.3.min.js" /> type="text/javascript"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src=<c:url value="/resources/js/bootstrap.min.js" /> type="text/javascript"></script>    
    <!-- Morris.js charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src=<c:url value="/resources/plugins/morris/morris.min.js" /> type="text/javascript"></script>
    <!-- Sparkline -->
    <script src=<c:url value="/resources/plugins/sparkline/jquery.sparkline.min.js" /> type="text/javascript"></script>
    <!-- jvectormap -->
    <script src=<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" /> type="text/javascript"></script>
    <script src=<c:url value="/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" /> type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src=<c:url value="/resources/plugins/knob/jquery.knob.js" /> type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src=<c:url value="/resources/plugins/daterangepicker/daterangepicker.js" /> type="text/javascript"></script>
    <!-- datepicker -->
    <script src=<c:url value="/resources/plugins/datepicker/bootstrap-datepicker.js" /> type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src=<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" /> type="text/javascript"></script>
    <!-- iCheck -->
    <script src=<c:url value="/resources/plugins/iCheck/icheck.min.js" /> type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src=<c:url value="/resources/plugins/slimScroll/jquery.slimscroll.min.js" /> type="text/javascript"></script>
    <!-- FastClick -->
    <script src=<c:url value="/resources/plugins/fastclick/fastclick.min.js" /> type="text/javascript"></script>
    <!-- AdminLTE App -->
    <script src=<c:url value="/resources/dist/js/app.min.js" /> type="text/javascript"></script>

    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src=<c:url value="/resources/dist/js/pages/dashboard.js" /> type="text/javascript"></script>

    <!-- AdminLTE for demo purposes -->
    <script src=<c:url value="/resources/dist/js/demo.js" /> type="text/javascript"></script>
  </body>
</html>