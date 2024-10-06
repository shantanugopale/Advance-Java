import java.sql.*;
import java.util.Scanner;
public class C7_AcceptRecordsFromUserAndInsertInDB {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection Successfull....!!!");
		
		System.out.println("Enter Rno :");
		int rno = sc.nextInt();
		System.out.println("Enter Name :");
		String name = sc.next();
		System.out.println("Enter Marks :");
		int marks = sc.nextInt();
		
		String query = "insert into student values("+rno+",'"+name+"',"+marks+")";
		
		Statement st = con.createStatement();
		st.executeUpdate(query);
		
		System.out.println("Inserted Successfullyyy...!!!");
		
		con.close();
	}

}
