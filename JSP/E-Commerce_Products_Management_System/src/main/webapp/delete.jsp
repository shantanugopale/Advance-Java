<%@page import="java.sql.ResultSet"%>
<%@page
	import="org.apache.coyote.http11.upgrade.InternalHttpUpgradeHandler"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dao.DBConnect"%>
<%@page import="java.sql.Connection"%>
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
	<div class="container">
		<form action="ProductController?pid=<%=Integer.parseInt(request.getParameter("pid"))%>" method="post">
			<h4 class="text=center">Are You Sure to Delete this Product ?</h4>
			<%
			try {
				Connection con = DBConnect.connect();
				int pId = Integer.parseInt(request.getParameter("pid"));
				PreparedStatement pst = con.prepareStatement("select * from products where pid=?;");
				pst.setInt(1, pId);
				ResultSet rs = pst.executeQuery();
			%>
			<div class="rows">
				<div class="cols-8">
					<table class="table table-hover">
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Product Cost</th>
							<th>Product Color</th>
							<th>Product Quantity</th>
						</tr>
						<%
						while (rs.next()) {
							out.println("<tr>");
							out.println("<td>" + rs.getInt(1) + "</td>");
							out.println("<td>" + rs.getString(2) + "</td>");
							out.println("<td>" + rs.getDouble(3) + "</td>");
							out.println("<td>" + rs.getString(4) + "</td>");
							out.println("<td>" + rs.getInt(5) + "</td>");
							out.println("</tr>");
						}
						} catch (Exception e) {
						e.printStackTrace();
						}
						%>
					</table>
				</div>
			</div>
			<input type="submit" name="delete" value="delete"
				class="btn btn-danger">
		</form>
	</div>
</body>
</html>