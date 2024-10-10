<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
</head>
<body>
	<form action="ProductController" method="post">
		<div class="container">
			<h1 text-center>Insert The Product</h1>
			<br> Enter Product ID : <input type="text" name="pid"><br>
			<br> Enter Product Name : <input type="text" name="pname"><br>
			<br> Enter Product Cost : <input type="text" name="pcost"><br>
			<br> Enter Product Color : <input type="text" name="pcolor"><br>
			<br> Enter Product Quantity : <input type="text" name="pqty"><br>
			<br> <input type="submit" name="insert" value="INSERT"
				class="btn btn-primary">
		</div>
	</form>
</body>
</html>