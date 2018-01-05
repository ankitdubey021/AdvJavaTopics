import java.text.*;
import java.sql.*;

class InsertDob{
	public static void main(String[] args)throws Exception{
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";
		String query="insert into student values(?,?,?)";

		
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
		PreparedStatement ps=con.prepareStatement(query);

		String s="05-06-1999";
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate=sdf.parse(s);

		//convert util date to sql
        long ms= udate.getTime();
		java.sql.Date sdate=new java.sql.Date(ms);

		ps.setInt(1,101);
		ps.setString(2,"hk");
		ps.setDate(3,sdate);
		int res=ps.executeUpdate();
		if(res!=0)
			System.out.println("inserted!");
		else
			System.out.println("failed");

	
		
		
	}
}
