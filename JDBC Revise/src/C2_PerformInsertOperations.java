import java.sql.*;

public class C2_PerformInsertOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successful...!");
		String query = "insert into student values(101,'Shantanu',99)";
		
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Data Inserted Successfully");
	}

}
