

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S4_ServletToCreateCalculator")
public class S4_ServletToCreateCalculator extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = 0;
		String option = request.getParameter("option");
		
		if(option.equals("Add"))
		{
			result=num1+num2;
			pw.print("Addition is :"+result);
		}
		else if(option.equals("Sub"))
		{
			result=num1-num2;
			pw.print("Substraction is :"+result);
		}
		else if(option.equals("Mul"))
		{
			result=num1*num2;
			pw.print("Multiplication is :"+result);
		}
		else if(option.equals("Div"))
		{
			result=num1/num2;
			pw.print("Division is :"+result);
		}
			
		
	}

}
