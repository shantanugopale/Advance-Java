

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayData")
public class DisplayData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletStudentCrud","root","shantanu");
			
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			
			pw.print("<h1> Student Data </h1>");
			pw.print("<table border='1' cellsspacing='20' cellspadding='20'>");
			pw.print("<tr><th>Rno</th><th>Name</th><th>Marks</th><th colspan='2'>Actions</th></tr>");
			
			while(rs.next())
			{
				pw.print("<tr>"
						+ "<td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
								+ "<td>"+rs.getFloat(3)+"</td>"
								+ "<td><a href='UpdateServlet?rno="+rs.getInt(1)+"'>Update</a></td>"
								+ "<td><a href='DeleteServlet?rno="+rs.getInt(1)+"'>Delete</a></td>"
								+ "</tr>");
			
			}
			pw.print("</table>");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.print("<a href='insert.html'>Insert Data</a><br/>");
		pw.print("<a href='index.html'> go to Home Page</a><br/>");
		
	}

}
