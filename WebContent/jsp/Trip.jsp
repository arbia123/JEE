<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="<%=request.getContextPath()%>/Trip" method="post">
		<div>
		<input type="hidden" value="${model.mode}" name="mode">
			<table>
	
				<tr>
					<th>date_depart</th>
					<td><input type="datetime-local" name="datedep" /></td>
				</tr>
				<tr>
					<th>date_arrivee</th>
					<td><input type="datetime-local" name="datearr" /></td>
				<tr>
					<th>lieu</th>
					<td><input type="text" name="lieu" /></td>
				</tr>
				<tr>
					<th>voiture</th>
					<td><input type="text" name="type_voit" /></td>
				</tr>
				<tr>
					<th>nombre_place</th>
					<th><input type="number" name="nbre_places" /></th>
				</tr>

				<tr>
					<td><input type="submit"  value="save" name="action"></input> <input
						type="reset" value="Reset"></input></td>
				</tr>
			</table>
		</div>
		<div>
	
		</div>
		<div>
			<table>
				<tr>
					<td>liste des trips</td>
					
					<td><input type="submit" value="liste" name="action" /></td>
				</tr>
			</table>
		</div>
		<div>
			<table class="table1">

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
						<th>${trip.datearr}</th>
						<th>${trip.lieu}</th>
						<th>${trip.type_voit}</th>
						<th>${trip.nbre_place}</th>
                        <th><a href="Trip?action=delete&id=${trip.idTrip }"> Supprimer</a></th>
                        <th><a href="Trip?action=edit&id=${trip.idTrip}"> Edit</a></th>
					</tr>
				</c:forEach>
			</table>
</div>
		



	</form>
</body>
</html>