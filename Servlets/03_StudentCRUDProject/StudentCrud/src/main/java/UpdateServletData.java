
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServletData")
public class UpdateServletData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String name = request.getParameter("name");
		float marks = Float.parseFloat(request.getParameter("marks"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletStudentCrud","root","shantanu");
			
			PreparedStatement pst = con.prepareStatement("update student set name='"+name+"', marks="+marks+" where rno="+rno);
			pst.executeUpdate();
			
			response.sendRedirect("DisplayData");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
