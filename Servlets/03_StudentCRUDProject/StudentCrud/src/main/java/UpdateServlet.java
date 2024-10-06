

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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletStudentCrud","root","shantanu");
			
			PreparedStatement pst = con.prepareStatement("select * from student where rno="+rno);
			ResultSet rs = pst.executeQuery();
			rs.next();
			pw.print("<form action=\"UpdateServletData\">\r\n"
					+ "		<h1>Update Students</h1>\r\n"
					+ "		Enter Rno : <input type=\"text\" name=\"rno\" value='"+rs.getInt(1)+"'><br><br>\r\n"
					+ "		Enter Name : <input type=\"text\" name=\"name\" value='"+rs.getString(2)+"'><br><br>\r\n"
					+ "		Enter Marks : <input type=\"text\" name=\"marks\" value='"+rs.getFloat(3)+"'><br><br>\r\n"
					+ "		<input type=\"submit\" value=\"Update\">\r\n"
					+ "	</form>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
