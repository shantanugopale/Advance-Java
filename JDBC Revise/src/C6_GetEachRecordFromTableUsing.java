import java.sql.*;
public class C6_GetEachRecordFromTableUsing {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successful....!!!");
		
		String query = "select * from student";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println("------------------------------");
			System.out.println("Rno :"+rs.getInt(1));
			System.out.println("Name :"+rs.getString(2));
			System.out.println("Marks :"+rs.getInt(3));
			System.out.println("------------------------------");
		}
		
		con.close();
	}
}
