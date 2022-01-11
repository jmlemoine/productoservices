<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="../../style/stylelogin.css">
    <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
</head>
<body style="background-color: #11B663">

<form style="background-color: #11B663" role="form" id="myform" action="/api/auth" method="post" onsubmit="return makeSearch()">

    <div class="login-box" style="background-color: #11B663">
        <h1>Login</h1>

        <div class="textbox">
            <i class="fa fa-user" aria-hidden="true"></i>
            <input type="text" name="username" id="username" required placeholder="Username">
        </div>
        <div class="textbox">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <input type="password" name="password" id="password" required placeholder="Password">
        </div>

        <input class="btn" type="submit" value="Log in">
        <a href="/registrar">Registrar</a>

    </div>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
    function deleteCookie() {
        document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
    }
    function makeSearch() {
        var usuario = $('#username').val();
     //   alert(usuario);
        $.post("/api/auth",
            {
                username: $('#username').val(),
                password: $('#password').val(),
            },
            function(data, status){
                // alert("Data: " + data + "\nStatus: " + status);
                window.location.href="/compra";
                document.cookie = "username=" + usuario;
                // alert(document.cookie)

        });
    }
</script>
</body>
</html>
<#--function setCookie(usuario, cvalue, exdays) {-->
<#--var d = new Date();-->
<#--d.setTime(d.getTime() + (exdays*24*60*60*1000));-->
<#--var expires = "expires="+ d.toUTCString();-->

<#--}-->