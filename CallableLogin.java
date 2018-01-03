import java.sql.*;
class CallableLogin{
	public static void main(String[] args)throws Exception{

String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";

        String query="{call login(?,?,?)}";
			String uname,password;

		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("enter user name");
		uname=sc.next();

		System.out.println("enter password");
		password=sc.next();


		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
		CallableStatement cs=con.prepareCall(query);
		cs.setString(1,uname);
		cs.setString(2,password);
		cs.registerOutParameter(3,Types.INTEGER);
	
		cs.execute();
		if(cs.getInt(3)==0)
			System.out.println("invalid user name or password!");

		else
			System.out.println("login  successfully");

	}
}
