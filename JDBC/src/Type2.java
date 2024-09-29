import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Type2 {
	
	public static void main(String[] args) throws Exception 
	{
		String name = "xyz";
		String email = "xyz@gmail.com";
		String pass = "xyz123";
		String gender = "female";
		String city = "mumbai";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
		
		PreparedStatement ps = con.prepareStatement("insert into register values('"+name+"', '"+email+"', '"+pass+"', '"+gender+"', '"+city+"')");
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
