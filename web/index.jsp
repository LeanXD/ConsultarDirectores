<%@page import="Beans.BeansFotogramas"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca tu pelicula</title>
</head>
<%
	ArrayList<BeansFotogramas> modelo = (ArrayList<BeansFotogramas>)request.getAttribute("modelo");
%>
<body>
<center>
	<form action="/consultar/comprobar" method="POST">
		<label>Introduza un nombre de director para consultar sus pel&iacute;culas</label>
		<br>
		<input type="text" name="director" requiered/>
		<br>
		<input type="submit" name="accion" value="Consultar"/>
	</form>
	<br>
	<%
		if(modelo!=null){
			if(modelo.size()>0){
				%>
				<table>
				<tr style="color: green;">
					<td>T&iacute;tulo</td><td>Director</td><td>G&eacute;nero</td>
				</tr>
				<%
				for(int i = 0; i<modelo.size(); i++){
					%>
					<tr>
						<td><%=modelo.get(i).getTitPelicula() %></td>
						<td><%=modelo.get(i).getDirector() %></td>
						<td><%=modelo.get(i).getGenero() %></td>
					</tr>
					<%
				}
				%>
				</table>
				<%
			}else{
				%>
				<label style="color: red">No existe ese director</label>
				<% 
			}
		}
	%>
</center>
</body>
</html>