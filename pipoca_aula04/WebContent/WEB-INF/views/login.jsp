<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<!-- Barra superior com os menus de navegação -->
		<c:import url="Menu.jsp"/>
	<form>
  <div class="form-group">
    <label for="exampleInputEmail1">Login</label>
    <input type="email" class="form-control" id="login" aria-describedby="emailHelp" placeholder="Digite seu login">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Senha</label>
    <input type="password" class="form-control" id="senha" placeholder="Senha">
  </div>
 <a href="logar">
 	<button type="submit" class="btn btn-primary" acao="logar">Entrar</button>
 </a> 
</form>

</body>
</html>