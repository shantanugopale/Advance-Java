

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	
		String name, email, address, age, state, file, gender, qualification[];
		pw.print("<center>");

		pw.print("<h1>Survey Details</h1>");
		name = request.getParameter("name");
		email = request.getParameter("email");
		address = request.getParameter("address");
		gender = request.getParameter("gender");
		qualification = request.getParameterValues("qualification");
		age = request.getParameter("age");
		state = request.getParameter("state");
		file = request.getParameter("file");
		
		pw.print("<br/>Name : "+name);
		pw.print("<br/>Email : "+email);
		pw.print("<br/>Address : "+address);
		
		pw.print("<br/>Gender : "+ gender);
		pw.print("<br/>Qualification : "+ Arrays.toString(qualification));
	
		pw.print("<br/>Age : "+age);
		pw.print("<br/>State : "+state);
		pw.print("<br/>File : "+file);
		
		pw.print("</center>");
		
//		First way to redirect from one Page to Another
//		pw.print("<a href='SecondServlet' action='get'> Go to Second Servlet </a>");
		
//		Second way to redirect from one Page to Another
		
		if(name.equals("Shantanu"))
		{
			response.sendRedirect("SecondServlet");
		}
		else
		{
			pw.print("Cannot Redirect");
		}
		
		
	}

}
