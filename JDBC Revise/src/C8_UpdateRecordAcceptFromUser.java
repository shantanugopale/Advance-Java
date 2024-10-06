import java.sql.*;
import java.util.Scanner;
public class C8_UpdateRecordAcceptFromUser {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrevise","root","shantanu");
		System.out.println("Connection SuccessFull...!!!");
		
		System.out.println("Enter the Roll No you want to Update the Record :");
		int rno = sc.nextInt();
		
		System.out.println("Enter the New Name :");
		String name = sc.next();
		
		System.out.println("Enter the New Marks :");
		int marks = sc.nextInt();
		
		String query = "update student set name='"+name+"',marks="+marks+ " where rno=" +rno+ "";
		Statement st = con.createStatement();
		
		st.executeUpdate(query);
		
		System.out.println("Records Updated Successfullyyyy....!");
	}

}
