

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletStudentCrud","root","shantanu");
			
			PreparedStatement pst = con.prepareStatement("delete from student where rno="+rno);
			pst.executeUpdate();
			
			response.sendRedirect("DisplayData");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
