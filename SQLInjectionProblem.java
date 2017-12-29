import java.sql.*;
import java.util.Scanner;
class SQLInjectionProblem{
	public static void main(String[] args)throws Exception{
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";


		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String uname=sc.next();
		uname="'"+uname+"'";
		System.out.println("Enter password");
		String password=sc.next();
		password="'"+password+"'";

String query="select count(*) from usermaster where username="+uname+" and pwd="+password;

Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
int res=0;
if(rs.next()){
   res=rs.getInt(1);
}
if(res!=0)
	System.out.println("Login successfully");
else
	System.out.println("Sorry shaktiman!");
	
	}
}
