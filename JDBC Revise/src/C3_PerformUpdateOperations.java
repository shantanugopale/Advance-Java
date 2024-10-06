import java.sql.*;
public class C3_PerformUpdateOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successfull...!");
		
		String query = "update student set rno=101 where name='Shantanu'";
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Data Updated Successfullyy......!");
	}

}
