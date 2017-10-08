package transaction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;



public class Transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "u1";
		String user_password = "123";
		String sql="";
		Connection conn=null;
		Statement sta=null;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			conn = DriverManager.getConnection(url, user, user_password);
			
			/*sta = conn.createStatement();
			sql="insert into user(name,password) values 'tom','123'";
			System.out.println(sql);
			sta.executeUpdate(sql);*/
			
			CallableStatement cs=conn.prepareCall("call p1(?,?,?)");
			cs.setInt(1, 10);
			cs.setInt(2,10);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.executeUpdate();
			//cs.executeQuery();
			cs.getInt(3);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getErrorCode());//1213À¿À¯   1205≥¨ ±
			System.out.println(e.getMessage());
			
			try{
				conn.rollback();
				conn.close();
				sta.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		
	}

}
