<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Liste à Chercher</title>
<link rel="StyleSheet" type=text/CSS href="CSS/style.css">
</head>

<body>
<div>
<form action="list" method="post">
<table>
<tr>
  <td>Mot clé:</td>
           <td><input type="text" name="motcle" /></td>
             <td><input type="submit"   value="chercher" name ="action"/></td>
</tr>
</table> 
 </form>
</div>

<div>

<table  class="table1" >
           
            <tr>
                <th>Id</th>
                <th>date_depart</th>
       		   <th>date_arrive</th>
        		<th>lieu</th>
        	  <th>type_voiture</th>
             <th>nombre de place</th>
            </tr>
            <c:forEach var="trip" items="${model.trips}">
                <tr>
                    <th>${trip.idTrip }</th>
                    <th>${trip.datedep}</th>
                    <th>${trip.datearr} </th>
                    <th>${trip.lieu}</th>
                    <th>${trip.type_voit}</th>
                    <th>${trip.nbre_place}</th>
                    
                </tr>
            </c:forEach>
        </table>
       
    </div>   

 
<div style="text-align: right"><a href="<%=request.getContextPath()%>/Logout">Logout</a></div>
</body>
</html>