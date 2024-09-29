import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Type3 {

	public static void main(String[] args) throws Exception 
	{
		String name = "pqr";
		String email = "pqr@gmail.com";
		String pass = "pqr123";
		String gender = "female";
		String city = "pune";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
		
		PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, pass);
		ps.setString(4, gender);
		ps.setString(5, city);
		
		int i = ps.executeUpdate();
		
		if(i>0)
		{
			System.out.println("Data inserted");
		}
		else 
		{
			System.out.println("Fail");
		}
	}
}
