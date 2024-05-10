<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

Vous avez saisi : <br>
Nom : ${user.name}<br>
Prénom : ${user.lastName }<br>
Login : ${user.email }<br>
role: ${user.role }<br>
Mot de passe : ${user.password }<br>
<input type="button" value="Valider" onclick="window.location.href='InscriptionController'">
 <input type="button" value="Corriger" onclick="window.location.href='inscription.jsp'">



</body>
</html>