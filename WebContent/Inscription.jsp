<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style><%@include file="/css/style.css"%></style>
    <title>Document</title>
</head>
<body>
    <header>
        <div class="header_groupe">
                <h1 class="Logo">SBAHIA</h1>
               <nav>
                   <ul>
                       <li> <a href="Login">Login</a></li>
                   </ul>
               </nav>
        </div>

       
    </header>
    <section>

        <form class="Login-form" action="Inscriptions" method="post">
         <h1>Sign In</h1>
         <div class="block-input-1"><input type="text" name="name" value="" placeholder="name" required /></div>
         <div class="block-input-2"><input type="email" name="Email" value=""  placeholder="Email" required /></div>   
         <div class="block-input-3"><input type="password" name="password" value="" placeholder="Mot passe" minlength="8" required  /></div>
         <div class="block-input-btn"><input type="submit" value="Sign In" /></div>
         <span>${error}</span>
        </form>
                                 
    </section>

    <footer class="footer-Sign-in">
        <p>Copyright 2021</p>
    </footer>
</body>
</html>