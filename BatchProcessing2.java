import java.sql.*;
class BatchProcessing2{
	public static void main(String[] args)throws Exception{
		

		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";

		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?)");
		ps.setInt(1,101);
		ps.setString(2,"kk");
		ps.addBatch();

		ps.setInt(1,102);
		ps.setString(2,"pk");
		ps.addBatch();

		ps.setInt(1,103);
		ps.setString(2,"dk");
		ps.addBatch();

		int res[]=ps.executeBatch();
		
		for(int i:res)
			System.out.print(i+" ");
		

	}
}
