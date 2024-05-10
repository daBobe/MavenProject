<%@page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" 
class="tn.iit.glid23.auth.model.UtilisateurModel" 
scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
	<form method="post" action="interm.jsp">
	<table>
		<tr><td>name : </td><td><input type ="text" name="name" 
		value="${user.name }"></td></tr>
		<tr><td>last Name : </td><td><input type ="text" name="lastName"
		value="${user.lastName }"></td></tr>
		<tr><td>email:</td><td><input type ="text" name="email"
		value="${user.email }"></td></tr>
		<tr><td>role : </td><td><input type ="text" name="role"
		value="${user.role }"></td></tr>
		<tr><td>Mot de passe : </td><td><input type ="password" name="password"
		value="${user.password }"></td></tr>
		<tr><td><input type ="submit" value="Valider"></td>
		<td><input type ="reset" value="annuler"></td></tr>
	</table>
</form>
</body>
</html>