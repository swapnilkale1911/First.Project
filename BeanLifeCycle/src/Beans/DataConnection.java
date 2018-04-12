package Beans;

import java.sql.*;
import java.sql.DriverManager;

import org.springframework.beans.factory.InitializingBean;

public class DataConnection implements InitializingBean 
{
	private String Driver,Url,UserName,Password;
	Connection con;
	
	public void setDriver(String driver) {
		Driver = driver;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void afterPropertiesSet() throws Exception 
	{
		con=DriverManager.getConnection(Url,UserName,Password);
		System.out.println(con.getClass().getName());
		
	}
	
	public void save(int id,String name,String address,int pincode)throws Exception
	{
		String Insert="insert into studenttable values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(Insert);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3,address);
		ps.setInt(4,pincode);
	
		ps.executeUpdate();
		ps.close();
		System.out.println("Data Successfully Inserted");
		
	}
	
	public void destory()throws  Exception
	{
		con.close();
	}


}
