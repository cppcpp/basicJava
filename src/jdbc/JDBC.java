package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



public class JDBC {
	private static String driver="com.mysql.jdbc.Driver";
	private static String user="root";
	private static String password="cpprootmysql";
	private static String url="jdbc:mysql://localhost:3306/test";
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		return (Connection)DriverManager.getConnection(url, user, password);
	}
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pre=null;
		try {
			connection=getConnection();
			connection.setAutoCommit(false);
			
			String sql="insert into user(id,name,password) values(?,?,?)";
			PreparedStatement preparedStatement= (PreparedStatement)connection.prepareStatement(sql);
			connection.setSavepoint();
			preparedStatement.setInt(1, 13);
			preparedStatement.setString(2,"11111111111111111");
			preparedStatement.setString(3, "323");
			preparedStatement.executeUpdate();
			/*String sql="update user set name='lisi' where id='1'";
			pre=(PreparedStatement) connection.prepareStatement(sql);
			pre.executeUpdate();*/
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				//设置自动提交为true
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
