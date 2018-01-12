import java.io.*;
import java.util.Properties;
import java.sql.*;

class FlexibleAppDemo{
	public static void main(String[] args)throws Exception{
		 String driver,uname,url,pwd;		
		  File f=new File("driver_info.properties");
		  if(f.exists()){

				FileInputStream fis=new FileInputStream(f);
				Properties p=new Properties();
				p.load(fis);
				uname=p.getProperty("uname");
				url=p.getProperty("url");
				pwd=p.getProperty("pwd");
				driver=p.getProperty("driver");
				
				Class.forName(driver);
				Connection con=DriverManager.getConnection(url,uname,pwd);
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from emp");
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2));
				}
		  }
		  else
			  System.out.println("properties file not found!");
	}
}
