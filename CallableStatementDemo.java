import java.sql.*;
class CallableStatementDemo{
	public static void main(String[] args)throws Exception{
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";
		String query="{call findSquare(?,?)}";


		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
		CallableStatement cs=con.prepareCall(query);
		cs.setInt(1,7);
		cs.registerOutParameter(2,Types.INTEGER);
		cs.execute();
		int res=cs.getInt(2);
		System.out.println("square : "+res);
	}
}
