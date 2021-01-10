<%-- 
    Document   : login
    Created on : 27/02/2019, 21:21:08
    Author     : Pedro Davi
--%>

<%@page import="br.com.rokobasi.eakademy.dao.LoginDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="res/css/style.css" rel="stylesheet" id="bootstrap-css">
        <script src="res/js/javascript.js"></script>
        
        <title>Roko Academy</title>
        
    </head>
    
    <body style="background-repeat: no-repeat; background-size: 100%; background-image: url(res/img/bg.png)">
        
        <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->

          <!-- Icon -->
          <div class="fadeIn first"><br>
              <img src="res/img/logoEakademy.svg" id="icon" style="width: 200px" alt="User Icon" /><br>
              <br>
          </div>

          <!-- Login Form -->
          <form name="login" action="loginUser" method="post">
            <input type="text" id="login" class="fadeIn second" name="cpf" placeholder="DIGITE SEU CPF" onkeydown="javascript: fMasc( this, mCPF );">
            <input type="password" id="password" class="fadeIn third" name="senha" placeholder="DIGITE SUA SENHA">
            <input type="hidden" value="login" name="param"/>
            <input type="submit" class="fadeIn fourth" value="entrar" onclick="validaformLogin();">
          </form>

          <!-- Remind Passowrd -->
          <div id="formFooter">
            <a class="underlineHover" href="#">Esqueceu sua senha?</a><br>
            <a class="underlineHover" href="pages/vestibulares.jsp"><b>Ver Vestibulares</b></a>
          </div>

        </div>
      </div>
        <!--
        <form name="login" action="loginUser" method="post">
            cpf<input type="text" name="cpf"><br/><br/>
            senha<input type="text" name="senha"><br/><br/>
            <input type="hidden" value="login" name="param"/>
            <input type="submit" value="enviar" onclick="validaformLogin();"/>
        </form>
         -->
    </body>
</html>
