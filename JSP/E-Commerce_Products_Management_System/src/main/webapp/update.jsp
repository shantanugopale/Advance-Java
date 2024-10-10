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
<body>
	<div class="container container-center">
		<div class="d-flex p-2">
			<form action="ProductController" method="post">
				<h1 class="text-center">Update Product</h1><br>
				<%
				int pid = Integer.parseInt(request.getParameter("pid"));
				%>
				Product ID : <input type="text" name="pid" value="<%=pid%>"><br>
				<br> New Product Name : <input type="text" name="pname"><br>
				<br> New Product Cost : <input type="text" name="pcost"><br>
				<br> New Product Color : <input type="text" name="pcolor"><br>
				<br> New Product Quantities : <input type="text" name="pqty"><br>
				<br> <input type="submit" name="update" value="UPDATE"
					class="btn btn-primary">
			</form>
		</div>
	</div>
</body>
</html>