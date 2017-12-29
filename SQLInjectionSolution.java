import java.sql.*;
import java.util.Scanner;
class SQLInjectionSolution{
	public static void main(String[] args)throws Exception{
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";


		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String uname=sc.nextLine();

		System.out.println("Enter password");
		String password=sc.next();




String query="select count(*) from usermaster where username=? and pwd=?";
PreparedStatement st=con.prepareStatement(query);
st.setString(1,uname);
st.setString(2,password);
ResultSet rs=st.executeQuery();
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
