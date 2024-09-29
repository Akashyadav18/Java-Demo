import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateType {

	public static void main(String[] args) throws Exception {
		
		String city ="vasi";
		String gender = "female";
		String email = "abc@gmail.com";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
		
		PreparedStatement ps = con.prepareStatement("update register set city=?, gender=? where email=?");
		ps.setString(1, city);
		ps.setString(2, gender);
		ps.setString(3, email);
		
		int count = ps.executeUpdate();
		if(count>0)
		{
			System.out.println("Update Successfully");
		}
		else 
		{
			System.out.println("fail");
		}
	}

}
