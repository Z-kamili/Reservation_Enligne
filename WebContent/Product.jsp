<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Document</title>
</head>
<body>
    <header>
        <div class="header_groupe">
                <h1 class="Logo">SBAHIA</h1>
               <nav>
                       <ul id="menu_column">
                           <li> <a href="Reservation">My reservation</a> </li>
                            <li> <a href=Add_Reservation>Add Reservation</a> </li>
                           <li> <a href="Deconnexion">Deconnexion</a></li> 
                       </ul>
               </nav>
        </div>

       
    </header>
    
    <section>
  <!-- <p>${sessionScope.sessionUtilisateur.email}</p> -->  
        <div class="Container">
         <c:forEach items="${rsv}" var="p">
            <div class="card">
                <div class="card-div">
                    <div class="Desc">${p.getEmail()}</div>
                    <div class="Desc"> ${p.getDesc()}</div>
                    <div> ${p.getDate_reservation()}</div>
                   <div class="btn-add"><a >Reservation</a></div> 
                </div>
            </div>
         </c:forEach>
        </div>


    </section>
    <footer >
        <p>Copyright 2021</p>
    </footer>
</body>
</html>