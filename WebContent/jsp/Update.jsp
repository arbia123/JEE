<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>


<html>
<head>
    <title>Update Page</title>
</head>
<body>
<form action="update" method="post">
<table >
    <tr>
    
        <td>date_départ</td>
        <td>date_arrivé</td>
        <td>lieu</td>
        <td>type_voiture</td>
        <td>nombres de place</td>
    </tr>
    <c:if test="${trip != null}">
                    <input type="hidden" name="id" value="<c:out value='${trip.id}' />" />
                </c:if>   
    <tr>
        <td><input type="time" name="title" size="45"  value="<c:out value='${trip.datedep}' />"
                        /></td>
        <td><input type="time" name="title" size="45"  value="<c:out value='${trip.datearr}' />"
                        /></td>
        <td><input type="text" name="title" size="45"  value="<c:out value='${trip.lieu}' />"
                        /></td>
        <td><input type="text" name="title" size="45"  value="<c:out value='${trip.type_voit}' />"
                        /></td>
        <td><input type="text" name="title" size="45"  value="<c:out value='${trip.nbre_place}' />"
                        /></td>
      
        
       
    </tr>
    <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
   
</table>
</form>

</body>
</html>