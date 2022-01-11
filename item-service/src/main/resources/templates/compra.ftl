<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- Ensures optimal rendering on mobile devices. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- Optimal Internet Explorer compatibility -->
    <title></title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="../../dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <script
            src="https://www.paypal.com/sdk/js?client-id=AUddr6ksVvb1fj_TPuZu_o-Ya99lBxAZTCDx2gZ_2iGcOGY4GD7tfpKH7FptcXg2pNXqjovTuN7Ylenz"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.
    </script>
    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/" class="logo" style="background-color: #2E6C4D">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>C</b>XA</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b></b></span>
        </a>

        <!-- Header Navbar -->
        <nav style="background-color: #2E6C4D" class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->

                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="hidden-xs">Usuario</span>
                        </a>
                        <ul class="dropdown-menu" style="background-color: #2E6C4D">
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">

                                </div>
                                <div class="pull-right">
                                    <a href="/login" class="btn btn-danger">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside style="background-color: #2E6C4D" class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left info">
                    <p>Usuario</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->

            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <!-- Optionally, you can add icons to the links -->
                <li><a href="/cliente/"><i class="fa fa-users"></i> <span>Clientes</span></a></li>
                <li><a href="/plan/"><i class="fa fa-users"></i> <span>Planes</span></a></li>
                <li><a href="/compra/prueba"><i class="fa fa-desktop"></i> <span>Realizar Compra</span></a></li>
                <li><a href="/empleado/"><i class="fa fa-desktop"></i> <span>Empleados</span></a></li>
                <li><a href="/usuario/"><i class="fa fa-desktop"></i> <span>Usuarios</span></a></li>


            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1 class="text-center">

                <strong>Compra Paquetes</strong>
            </h1>

        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="table-responsive">
                        <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                            <table class="table">
                                <#--                                <form method="post" action="/compra/crear/">-->
                                <thead>
                                <tr>
                                    <th scope="col">Planes</th>
                                    <th scope="col">Costo</th>
                                    <th scope="col">Seleccionar Pedido</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list planes as plan>
                                    <tr>
                                        <th scope="row" value="${plan.nombre}">${plan.nombre}</th>
                                        <td value="${plan.costo}">$${plan.costo?long?c}</td>
                                        <td style="text-align: center">
                                            <input class="seleccionPlan" id="${plan.nombre}" value="${plan.costo}" type="checkbox"/>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                        </div>

                    </div>

                    <div id="paypal-button-container"></div>

                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <!-- Default to the left -->
        <strong>Copyright &copy; 2020 <a href="#">J&R</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="../../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<script>

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">
    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }
    var username = getCookie("username");
  //  alert(username);
    var plan = [];
    $(document).ready(function () {

        console.log('ready');

        //    seleccionPlan
        $('.seleccionPlan').click(function () {
            let seleccion = $(this);

            // $('.seleccionPlan').not(this).prop('checked', false);
            let id = seleccion.attr('id');
            if (seleccion.prop("checked") === true) {
                // plan.push(id);
                plan = {planes: id, monto: seleccion.val(), usuario: username}
            } else {
                plan.splice(plan.indexOf(id), 1);

            }

        });


    });

</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
<script>
    paypal.Buttons({
        createOrder: function(data, actions) {
            // This function sets up the details of the transaction, including the amount and line item details.
            return actions.order.create({
                purchase_units: [{
                    amount: {
                        value: '20'
                    }
                }]
            });
        },
        onApprove: function(data, actions) {
            // This function captures the funds from the transaction.
            return actions.order.capture().then(function(details) {
                console.log(plan);
                // This function shows a transaction success message to your buyer.
                $.ajax({
                    url:"/api/planes/",
                    type:"POST",
                    data: JSON.stringify(plan),
                    contentType:"application/json; charset=utf-8",
                    dataType:"json",
                    success: function(data, status){
                       // alert("Data: " + data + "\nStatus: " + status);
                        window.location.reload();
                    }
                });
             // alert(plan);
                // alert('Transaction completed by ' + details.payer.name.given_name);
            });
        }
    }).render('#paypal-button-container');
    //This function displays Smart Payment Buttons on your web page.
</script>
</body>
</html>