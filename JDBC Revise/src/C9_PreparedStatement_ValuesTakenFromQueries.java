import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C9_PreparedStatement_ValuesTakenFromQueries {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successfull......!!!");
		String query = "insert into student values(?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, 107);
		pst.setString(2, "Manoj");
		pst.setInt(3, 99);
		
		pst.executeUpdate();
		System.out.println("Records Inserted Successfullyy....!!!");
		
		con.close();
	}

}
