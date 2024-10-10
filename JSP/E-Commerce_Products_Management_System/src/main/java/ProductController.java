import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DBConnect;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("login") != null) {
			String username = request.getParameter("username");

			String password = request.getParameter("password");

			try (Connection con = DBConnect.connect()) { // Use try-with-resources

				PreparedStatement pst = con
						.prepareStatement("select * from accountinfo where username=? and password=?");
				pst.setString(1, username);
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {
					System.out.println("Login Success!");

					response.sendRedirect("products.jsp");
				} else {
					response.sendRedirect("index.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("insert") != null) {
			Connection con;
			try {
				con = DBConnect.connect();
				int pId = Integer.parseInt(request.getParameter("pid"));
				String pName = request.getParameter("pname");
				double pCost = Double.parseDouble(request.getParameter("pcost"));
				String pColor = request.getParameter("pcolor");
				int pQty = Integer.parseInt(request.getParameter("pqty"));

				PreparedStatement pst = con.prepareStatement("insert into products values(?, ?, ?, ?, ?);");
				pst.setInt(1, pId);
				pst.setString(2, pName);
				pst.setDouble(3, pCost);
				pst.setString(4, pColor);
				pst.setInt(5, pQty);
				pst.executeUpdate();

				response.sendRedirect("products.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("update") != null) {
			try (Connection con = DBConnect.connect()) {
				int pId = Integer.parseInt(request.getParameter("pid"));
				String pName = request.getParameter("pname");
				double pCost = Double.parseDouble(request.getParameter("pcost"));

				String pColor = request.getParameter("pcolor");
				int pQty = Integer.parseInt(request.getParameter("pqty"));

				PreparedStatement pst = con
						.prepareStatement("update products set pname=?, cost=?, color=?, pqty=? where pid=?");
				pst.setString(1, pName);
				pst.setDouble(2, pCost);
				pst.setString(3, pColor);
				pst.setInt(4, pQty);
				pst.setInt(5, pId);

				pst.executeUpdate();
				System.out.println("Product Updated...");
				response.sendRedirect("products.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("delete") != null) {
			try {
				Connection con = DBConnect.connect();
				int pId = Integer.parseInt(request.getParameter("pid"));
				PreparedStatement pst = con.prepareStatement("delete from products where pid=?");
				pst.setInt(1, pId);
				pst.executeUpdate();

				response.sendRedirect("products.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if(request.getParameter("searchProduct")!=null)
		{
			try {
				Connection con = DBConnect.connect();
				String pName = request.getParameter("seachProductName");
				PreparedStatement pst = con.prepareStatement("select * from products where pname=?");
				pst.setString(1, pName);
				ResultSet rs = pst.executeQuery();

				response.sendRedirect("products.jsp");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}