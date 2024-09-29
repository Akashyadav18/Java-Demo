import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CRUDWithMethods {

	public static void main(String[] args) {
		CRUDWithMethods obj = new CRUDWithMethods();
		//obj.insert_data();
		//obj.update_data();
		//obj.delete_data();
		obj.view_data();
	}
	
	//insert
	public void insert_data()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into register values('pqr', 'prq@gmail.com', 'pqr123', 'male', 'auran')");
			int count = ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Inserted Successfully...");
			}
			else
			{
				System.out.println("intert fail!");
			}
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//view
	public void view_data()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from register");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Name :"+rs.getString(1)+ " || city :" +rs.getString(5));
				//we can also get data from DB
//				String name1 = rs.getString("name");
//				System.out.println("Name :"+name1);
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//update
	public void update_data()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
			PreparedStatement ps = con.prepareStatement("update register set city='dadar' where email='prq@gmail.com'");
			int count = ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Updated successfully");
			}
			else
			{
				System.out.println("update fail");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//delete
	public void delete_data()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_db", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from register where gender='male'");
			int count = ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Deleted successfully");
			}
			else
			{
				System.out.println("Dalete fail");
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
