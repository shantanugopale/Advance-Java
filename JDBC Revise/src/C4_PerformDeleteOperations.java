import java.sql.*;
public class C4_PerformDeleteOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection SuccessFul.......!!!");
		String query = "delete from student";
		
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Data Deleted SuccessFulyy....!!!");
	}

}
