

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S2_ServletToShowUserNameAndPassWord")
public class S2_ServletToShowUserNameAndPassWord extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.print("<h2>Show UserName and PassWord<h2><br/>");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		pw.print("Username :"+username +"<br/>");
		pw.print("Password :"+password);
	}

}
