package Driver;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Beans.DataConnection;

public class StartDriver {

	public static void main(String[] args)throws Exception
	{
		String[] value={"XML/Spring.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(value);
		DataConnection dc=(DataConnection)ac.getBean("dc");
		dc.afterPropertiesSet();
		
		
		
		
		while(true)
		{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Press 1 For Upload More Data");
			System.out.println("Press 2 For Close Connection");
			int No=sc.nextInt();
			
			if(No==1)
			{
				
			
			System.out.println("Enter Id Of Student");
			int Id=sc.nextInt();
			
			System.out.println("Enter Name Of Student");
			String Name=sc.next();
			
			
			
			System.out.println("Enter Pincode Of Student");
			int Pincode=sc.nextInt();
			
			System.out.println("Enter Address Of Student");
			String Address=sc.next();
			
			dc.save(Id, Name, Address, Pincode);
			}
			
			else if(No==2)
			{
				dc.destory();
				System.out.println("Connection Close");
			}
			else
			{
				System.out.println("Select Option 1 Or 2");
			}
			
		}
		

	}

}
