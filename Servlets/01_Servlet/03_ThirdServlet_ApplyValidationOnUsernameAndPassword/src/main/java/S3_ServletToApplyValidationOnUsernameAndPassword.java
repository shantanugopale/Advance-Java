

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S3_ServletToApplyValidationOnUsernameAndPassword")
public class S3_ServletToApplyValidationOnUsernameAndPassword extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<h4>Check Validity<br/><br/><br/></h4>");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if((username.equals("Shantanu")) && (password.equals("6833")))
		{
			pw.print("Login SuccessFull........!!!<br/><br/>");
			pw.print("UserName :"+username+"<br/>");
			pw.print("PassWord :"+password+"<br/>");
		}
		else
		{
			pw.print("Login Failed.........!!!<br/><br/>");
		}
	}

}
