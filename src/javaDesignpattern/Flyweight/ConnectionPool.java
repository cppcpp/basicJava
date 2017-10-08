package javaDesignpattern.Flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


public class ConnectionPool {
	public Vector<Connection> connections;
	
	public String user="root";
	public String password="cpproot";
	public String url="jdbc:mysql://localhost:3306/test";
	public String driver="com.mysql.jdbc.Driver";
	
	//初始化线程池大小
	public int connSize=10;
	java.sql.Connection connection=null;
	
	
	//初始化线程池
	public ConnectionPool() throws ClassNotFoundException, SQLException{
		connections=new Vector<Connection>(connSize);
		
		for(int i=0;i<connSize;i++){
			Class.forName(driver);
			connection=DriverManager.getConnection(user,password,url);
			connections.add(connection);
		}
	}
	
	//从线程池中取出线程
	public synchronized Connection getConnection(){
		if(connections.size()>0){
			Connection connection=connections.get(0);
			connections.remove(connection);
			return connection;
		}else{
			return null;
		}
	}
}
