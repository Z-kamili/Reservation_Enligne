<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="/css/style.css"%></style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
    <header>
        <div class="header_groupe">
                <h1 class="Logo">SBAHIA</h1>
               <nav>
                   <ul>
                      <li> <a href="Deconnexion">Deconnexion</a></li>
                   </ul>
               </nav>
            </div>
    </header>
    <section class="section-admin">

    
    <div class="main_container">

        <div class="container admin">
            <div class="row">
                <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                    <th>Email</th>
                    <th>Date</th>
                    <th>Fonction</th>
                    </tr>
                </thead>
                <tbody> 

  <c:forEach items="${rsv}" var="p" varStatus="status">
    
    <tr>
       
     <td class="column-title">${p.email}</td>
    
     <td>${p.date_reservation}</td>
<td class="column-img">
<a class="btn-Modifier" href="Edit.test?id=${p.id}" > Update <img src="img/Icon-update.png"> </a>
<a class="btn-Supprimer" onclick="return confirm('Etes vous sure?')" href="Delete.test?id=${p.id}"> Delete <img src="img/Icondelete.png"> </a>
</td>
    </tr>
    
    </c:forEach>

 
                </tbody>
                </table>
                
                
            </div>
            
            
            </div>
      </div>
    </section>
    
    
    <footer >
        <p>Copyright 2021</p>
    </footer>
</body>
</html>