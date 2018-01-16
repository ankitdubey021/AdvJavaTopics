import java.sql.*;
class SavePointDemo{
	public static void main(String[] args)throws Exception{
		

		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String pwd="manager";
		String username="system";

		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,username,pwd);
		con.setAutoCommit(false);
		String selectQry="select * from emp where eno=?";
		String updateQry="update emp set balance=? where eno=?";
		PreparedStatement ps=con.prepareStatement(selectQry);

		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("Enter your acount number");
		int accno=sc.nextInt();
		ps.setInt(1,accno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			int sno=rs.getInt(1);
			String sname=rs.getString(2);
			int sbalance=rs.getInt(3);
				
				System.out.println("Enter the amount!");
				int amt=sc.nextInt();
				if(amt<sbalance){
					System.out.println("Enter the beneficiary account number!");
						accno=sc.nextInt();
							ps.setInt(1,accno);
							rs=ps.executeQuery();
							if(rs.next()){
								int dno=rs.getInt(1);
								String dname=rs.getString(2);
								int dbalance=rs.getInt(3);
						
								Savepoint sp=con.setSavepoint();
								ps=con.prepareStatement(updateQry);
								ps.setInt(1,(sbalance-amt));
								ps.setInt(2,sno);
								ps.executeUpdate();

								try{
								System.out.println("in try");
								ps.setInt(1,(dbalance+amt));
								ps.setInt(2,dno);
								ps.executeUpdate();
								System.out.println("transferred successfully!");
								}
								catch(Exception e){
									con.rollback(sp);
									System.out.println("Something went wrong! your transaction is cancelled.");
									System.out.println("Your current balance is : "+sbalance);
								}
								con.commit();
							}
							else
							System.out.println("beneficiary account number doesn't really exist!");
				}
				else
					System.out.println("Insufficient funds");
		}
			else
			System.out.println("ENTER VALID ACOUNT NUMBER PLEASE!");
	}
}
