import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Type1 
{
	public static void main(String[] args) throws Exception 
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
		
		PreparedStatement ps = con.prepareStatement("insert into register values('abc', 'abc@gmail.com', 'abc123', 'male', 'mumbai')");
		int i = ps.executeUpdate();
		
		if(i>0)
		{
			System.out.println("Success");
		}
		else 
		{
			System.out.println("Fail");
		}
	}


}
