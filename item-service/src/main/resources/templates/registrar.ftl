<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">

    <title>Bienvenido</title>

    <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">

    <link rel="stylesheet" href="../../style/style.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="../../dist/css/skins/skin-blue.min.css">

</head>
<#--enctype="multipart/form-data"-->
<#--action="/api/auth/registrarse"-->
<form id="form" class="form-horizontal" >
    <div class="row">

        <br>
        <div class="form-group">
            <label for="username" class="control-label col-md-3">Usuario</label>
            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                <input id="username" type="text" name="username" class="form-control" placeholder="Usuario...">
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="control-label col-md-3">Password</label>

            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                <input id="password" type="password" name="password" class="form-control" placeholder="Password...">
            </div>

        </div>
        <div class="form-group">
            <label for="nombre" class="control-label col-md-3">Nombre</label>

            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                <input id="nombre" type="text" name="nombre" class="form-control" placeholder="Nombre...">
            </div>

        </div>
        <div class="form-group">
            <label for="apellido" class="control-label col-md-3">Apellido</label>

            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                <input id="apellido" type="text" name="apellido" class="form-control" placeholder="Apellido...">
            </div>

        </div>

        <div class="form-group">
            <label for="correo" class="control-label col-md-3">Correo</label>

            <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
                <input id="email" type="email" name="email" class="form-control" pattern=".+@gmail.com" placeholder="Correo..." required>
            </div>
        </div>
        <div class="form-group">
            <a id="submit" type="button" name="submit" value="submit" class="btn btn-primary col-md-offset-5" href="/login">Guardar</a>
<#--                <input id="submit" type="button" name="submit" value="submit">-->
                <a class="btn btn-danger" href="/#" role="button">Cancelar</a>
        </div>
    </div>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
    $(document).ready(function(){

        // click on button submit
        $("#submit").on('click', function(){
            $.ajax({
                url:"/api/auth/registrarse",
                type:"POST",
                data: JSON.stringify({
                    "username" :$("#username").val(),
                    "password" :$("#password").val(),
                    "nombre" :$("#nombre").val(),
                    "apellido" :$("#apellido").val(),
                    "email" : $("#email").val(),
                }),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function(data, status){
                  //  alert("Data: " + data + "\nStatus: " + status);
                    window.location.href="/login";
                }
            });
        })
    });

</script>
</body>
</html>

<#--
JSON.stringify-->

<#--// send ajax-->
<#--// console.log($(JSON.stringify($("#form"))));-->
<#--/*$.ajax({-->
<#--contentType: "application/json",-->
<#--url: 'localhost:8002/api/auth/registrarse', // url where to submit the request-->
<#--type : 'POST', // type of action POST || GET-->
<#--data : JSON.stringify($("#form")), // post data || get data-->
<#--success : function(result) {-->
<#--// you can see the result from the console-->
<#--// tab of the developer tools-->
<#--console.log(result);-->
<#--},-->
<#--error: function(xhr, resp, text) {-->
<#--console.log(xhr, resp, text);-->
<#--}-->
<#--})*/-->