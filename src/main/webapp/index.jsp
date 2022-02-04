<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="FacadeServlet" method="post">

    Username : <input name="username"></input><br/><br/>


    Password :<input name="password" type="password"></input><br/><br/>


    <input type="submit" value="Connexion"/>

</form>
</body>
</html>