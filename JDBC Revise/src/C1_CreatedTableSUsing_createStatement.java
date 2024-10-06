import java.sql.*;

public class C1_CreatedTableSUsing_createStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successful....!!!");
		String query = "create table student(rno int, name varchar(20), marks int)";
		
		Statement st = con.createStatement();
		st.execute(query);
		
		System.out.println("Table Created...");
		con.close();
	}

}
