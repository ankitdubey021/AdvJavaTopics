import java.sql.*;
class BatchProcessing{
	public static void main(String[] args){
		Connection con=null;
		Statement st=null;

		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";
		String q1="insert into student values(102,'pk')";
		String q2="delete from student where sno=105";
     	String q3="update student set sname='gk' where sno>1";

		try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,username,pwd);
		st=con.createStatement();
		st.addBatch(q1);
		st.addBatch(q2);
		st.addBatch(q3);
		int res[]=st.executeBatch();
		
		for(int i:res)
			System.out.print(i+" ");

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				st.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		}

	}
}
