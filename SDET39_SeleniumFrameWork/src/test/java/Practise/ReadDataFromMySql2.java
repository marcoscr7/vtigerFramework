package Practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromMySql2
{
	public static void main(String[] args) throws Throwable 
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/teachers_info","root","root");
		Statement stat=conn.createStatement();
		String SelectQuery="select* from teachers";
		ResultSet result=stat.executeQuery(SelectQuery);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
	}
	

}
