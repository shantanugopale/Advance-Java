<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.dao.DBConnect"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<%
	try {
		Connection con = DBConnect.connect();

		PreparedStatement pst = con.prepareStatement("select * from products");
		ResultSet rs = pst.executeQuery();
	%>
	<div class="container">
		<div class="text-center">
			<h1 class="text-center">Products</h1>
			<form action="search.jsp" method="post">
				<input type="text" name="searchProductName"><br> <input
					type="submit" name="searchProduct" value="SEARCH"
					class="btn btn-success">
			</form>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-light table-hover">
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Product Cost</th>
						<th>Product Color</th>
						<th>Product Quantity</th>
						<th colspan="2">Actions</th>
					</tr>
					<%
					while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt(1)%></td>
						<td><%=rs.getString(2)%></td>
						<td><%=rs.getDouble(3)%></td>
						<td><%=rs.getString(4)%></td>
						<td><%=rs.getInt(5)%></td>
						<td><a href="update.jsp?pid=<%=rs.getInt(1)%>">UPDATE</a></td>
						<td><a href="delete.jsp?pid=<%=rs.getInt(1)%>">DELETE</a></td>
					</tr>
					<%
					}
					%>
				</table>
				<%
				} catch (Exception e) {
				e.printStackTrace();

				}
				%>
				<a href="insert.jsp" class="btn btn-primary">Insert new Product</a>
			</div>
		</div>
	</div>

</body>
</html>