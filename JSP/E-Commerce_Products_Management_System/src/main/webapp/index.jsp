<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Commerce Website Login</title> 
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<div class="container bg-light">
    <form action="ProductController" method="post">
        <h1>Welcome To E-Commerce Website</h1>
        <h3>Login Page</h3>
        Enter Username : <input type="text" name="username"><br><br>
        Enter Password : <input type="password" name="password"><br><br>
        <input type="submit" name="login" value="login" class="btn btn-outline-primary">
    </form>
    </div>
</body>
</html>