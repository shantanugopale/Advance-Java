import java.sql.*;
import java.util.Scanner;
public class C5_GetSingleRecordFromTableUsingScanner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successful....!!");
		
		System.out.println("Enter the RNo you want Select from Table :");
		int rno = sc.nextInt();
		
		String query = "select * from student where rno="+rno;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		System.out.println("-----------------------------------");
		System.out.println("Rno :"+rs.getInt(1));
		System.out.println("Name :"+rs.getString(2));
		System.out.println("Marks :"+rs.getInt(3));
		System.out.println("-----------------------------------");
		
		con.close();
	}

}
