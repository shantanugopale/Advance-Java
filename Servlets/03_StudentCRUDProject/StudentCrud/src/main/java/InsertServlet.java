

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String name = request.getParameter("name");
		float marks = Float.parseFloat(request.getParameter("marks"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletStudentCrud","root","shantanu");
			
			PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?)");
			pst.setInt(1, rno);
			pst.setString(2, name);
			pst.setFloat(3, marks);
			
			pst.executeUpdate();
			
			RequestDispatcher req = request.getRequestDispatcher("index.html");
			req.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
