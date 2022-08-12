package Practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class WritedataFromNonSelectQuery 
{
	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info","root","root");
		Statement stat=conn.createStatement();
		String query="insert into teachers (FIRST_NAME,LAST_NAME,ADDRESS) VALUES ('sachita','devi','lupung')";
		int result=stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
			
		}
		else
		{
			System.out.println("user is not created");
		}
	}

}
