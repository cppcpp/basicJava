package transaction;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TransferAccountTransaction {
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="cpprootmysql";
	private static String url="jdbc:mysql://localhost:3306/test";
	static Connection connection=null;
	PreparedStatement preparedStatement=null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		return (Connection)DriverManager.getConnection(url, user, password);
	}
	
	public static User getUser(String name){
		
		try {
			String sql="select * from user where name=?";
			connection=getConnection();
			connection.setAutoCommit(false);
			PreparedStatement pre= (PreparedStatement) connection.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet resultSet= pre.executeQuery();
			User user=new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("password"),resultSet.getDouble("money"),resultSet.getInt("flag"));
			return user;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				connection.rollback();
				return null;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	public void transfer(int fromId,int toId,double money){
		try {
			User from=getUser("zhou");
			User to=getUser("chen");
			
			
			String sql="update user set money=? where id=?";
			
			connection=getConnection();
			connection.setAutoCommit(false);
			//转钱操作
			preparedStatement=(PreparedStatement) connection.prepareCall(sql);
			preparedStatement.setDouble(1, money);
			preparedStatement.setInt(2, fromId);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
